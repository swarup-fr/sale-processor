package com.sale.consumer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import com.sale.vo.IMessage;
import com.sale.vo.Sale;
import com.sale.vo.SaleAdjustment;
import com.sale.vo.SaleOccurence;
import com.sale.SaleLogger;

public class SaleMessageConsumerService implements Runnable {

	private BlockingQueue<IMessage> salesMessagesQueue;
	private static final int MAX_SALE_COUNT = 50;
	private static final int TENTH_MESSAGE_COUNT = 10;
	
	public SaleMessageConsumerService(BlockingQueue<IMessage> salesMessagesQueue) {
		this.salesMessagesQueue = salesMessagesQueue;
	}
	
	@Override
	public void run() {
		try {
			SaleLogger.LOGGER.info("--------------------- Listener started, waiting for messages ------------------------------");
			IMessage message;
			int saleMessageCount=0;
			Map<String,List<Sale>> saleItems = new HashMap<String,List<Sale>>();
			List<SaleAdjustment> saleAdjustments = new ArrayList<SaleAdjustment>();
			BlockingQueue<SaleAdjustment> salesAdjustmentBackoutMessagesQueue = new LinkedBlockingDeque<SaleAdjustment>();
			
			while(true) {
					if(saleMessageCount<MAX_SALE_COUNT && salesMessagesQueue.peek()!=null) {
						message = salesMessagesQueue.take();
						saleMessageCount++;
						if(message instanceof SaleAdjustment) {
							SaleAdjustment saleAdjustment = (SaleAdjustment) message;
							
							//if all messages received till now are of Adjustment then do not process them and 
							//move them to back out queue to process later based on requirement.
							if(saleItems.isEmpty()) {
								salesAdjustmentBackoutMessagesQueue.add(saleAdjustment);
								continue;
							}
							saleAdjustments.add(saleAdjustment);
							List<Sale> saleList = saleItems.get(saleAdjustment.getProduct());
							applyAdjustment(saleAdjustment,saleList);
							
						}else if(message instanceof SaleOccurence){
							handleSaleOccurence(message, saleItems);
						}else if(message instanceof Sale) {
							handleSale(message, saleItems);
						}
						
						if(saleMessageCount % TENTH_MESSAGE_COUNT ==0) {
							handleTenthRecordReport(saleItems, salesAdjustmentBackoutMessagesQueue);
						}
				}
				else if(saleMessageCount==MAX_SALE_COUNT) {
					SaleLogger.LOGGER.info("--------------------- Generating Final Report ------------------------------");
					generateAdjustmentsReport(saleAdjustments);
					SaleLogger.LOGGER.info("Total messages processed : "+saleMessageCount);
					break;
				}
			}
		} catch (InterruptedException e) {
			SaleLogger.LOGGER.severe(e.getMessage()); 
		} catch (Exception e) {
			SaleLogger.LOGGER.severe(e.getMessage()); 
		}
	}

	private void handleTenthRecordReport(Map<String, List<Sale>> saleItems,
			BlockingQueue<SaleAdjustment> salesAdjustmentBackoutMessagesQueue) {
		SaleLogger.LOGGER.info("--------------------- Generating Intermidiate Report ------------------------------");
		if(null!=saleItems && !saleItems.isEmpty())
			generateIntermidiateReport(saleItems);
		else if (!salesAdjustmentBackoutMessagesQueue.isEmpty())
			SaleLogger.LOGGER.info("All the messages received till now are of Sale Adjustment.");
		
		SaleLogger.LOGGER.info("---------------------------------------------------------------------");
	}

	private void handleSale(IMessage message, Map<String, List<Sale>> saleItems) {
		if(saleItems.isEmpty() || null==saleItems.get(((Sale)message).getProduct())) {
			List<Sale> saleList = new ArrayList<Sale>();
			saleList.add((Sale) message);
			saleItems.put(((Sale)message).getProduct(), saleList);
		}else {
			List<Sale> saleList = saleItems.get(((Sale)message).getProduct());
			saleList.add((Sale) message);
			saleItems.put(((Sale)message).getProduct(), saleList);
		}
	}

	private void handleSaleOccurence(IMessage message, Map<String, List<Sale>> saleItems) {
		int saleOccuerence = ((SaleOccurence)message).getOccurence();
		while(saleOccuerence > 0) {
		
			if(saleItems.isEmpty() || null==saleItems.get(((Sale)message).getProduct())) {
				List<Sale> saleList = new ArrayList<Sale>();
				saleList.add(new Sale (((SaleOccurence)message).getProduct(),((SaleOccurence)message).getValue()));
				saleItems.put(((Sale)message).getProduct(), saleList);
			}else {
				List<Sale> saleList = saleItems.get(((Sale)message).getProduct());
				saleList.add(new Sale (((SaleOccurence)message).getProduct(),((SaleOccurence)message).getValue()));
				saleItems.put(((Sale)message).getProduct(), saleList);
			}
			
			saleOccuerence --;
		}
	}
	
	private void applyAdjustment(SaleAdjustment saleAdjustment, List<Sale> saleList) {
		
		switch(saleAdjustment.getAdjustmentOperation()) {
		
			case ADD : 		saleList.forEach(sale -> {
								sale.setValue(saleAdjustment.getAdjustmentOperation().apply(sale.getValue(),saleAdjustment.getValue()));
							});
							break;
			case SUBTRACT : saleList.forEach(sale -> {
								sale.setValue(saleAdjustment.getAdjustmentOperation().apply(sale.getValue(),saleAdjustment.getValue()));
							});
							break;
				
			case MULTIPLY : saleList.forEach(sale -> {
								sale.setValue(saleAdjustment.getAdjustmentOperation().apply(sale.getValue(),saleAdjustment.getValue()));
							});
							break;
			default : SaleLogger.LOGGER.info("Invalid Adjustment operation "+saleAdjustment.getAdjustmentOperation()+" for product "+saleAdjustment.getProduct());
		}
		
	}

	private void generateIntermidiateReport(Map<String,List<Sale>> saleItems) {
		for(Map.Entry<String, List<Sale>> saleEntry : saleItems.entrySet()) {
			BigDecimal totalSaleForProduct = saleEntry.getValue().parallelStream().map(Sale::getValue).reduce(BigDecimal.ZERO,BigDecimal::add);
			SaleLogger.LOGGER.info("Total Sale for "+saleEntry.getKey()+" is "+totalSaleForProduct);
		}
	}
	
	private void generateAdjustmentsReport(List<SaleAdjustment> saleAdjustments) {
		saleAdjustments.forEach(saleAdjustment -> {
			SaleLogger.LOGGER.info("Adjustment operation "+saleAdjustment.getAdjustmentOperation()+" has been performed for product = "+saleAdjustment.getProduct()+" with value = "+saleAdjustment.getValue());
		});
		
	}
}
