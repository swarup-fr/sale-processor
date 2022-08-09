package com.sale.producer;

import java.math.BigDecimal;
import java.util.concurrent.BlockingQueue;

import com.sale.vo.IMessage;
import com.sale.vo.Sale;
import com.sale.vo.SaleAdjustment;
import com.sale.vo.SaleOccurence;
import com.sale.vo.SaleOperation;

public class SaleMessageProducerService implements Runnable {
	
	private BlockingQueue<IMessage> salesMessagesQueue;
	
	public SaleMessageProducerService(BlockingQueue<IMessage> salesMessagesQueue) {
		this.salesMessagesQueue = salesMessagesQueue;
	}

	@Override
	public void run() {
		try {
			
			produceMoreThanFiftyMessagesPositiveScenario();
//			
//			produceLessThanFiftyMessagesPositiveScenario();
//			
//			produceLessThanTenType2Type3Messages();
			
//			produceMoreThanFiftyType2Type3Messages();
//			
//			produceType3Messages();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void produceMoreThanFiftyMessagesPositiveScenario() throws InterruptedException {
		Thread.sleep(200);
		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(10)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(40000.10)));
		
		Thread.sleep(200);
		SaleOccurence saleOccureanceApple = new SaleOccurence();
		saleOccureanceApple.setProduct("Apple");
		saleOccureanceApple.setValue(new BigDecimal(15));
		saleOccureanceApple.setOccurence(2);
		
		salesMessagesQueue.put(saleOccureanceApple);
		
		SaleAdjustment saleAdjustmentApple = new SaleAdjustment();
		saleAdjustmentApple.setAdjustmentOperation(SaleOperation.ADD);
		saleAdjustmentApple.setProduct("Apple");
		saleAdjustmentApple.setValue(new BigDecimal(20));
		
		salesMessagesQueue.put(saleAdjustmentApple);
		
		Thread.sleep(200);
		
		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(20)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(30000.10)));
		
		SaleOccurence saleOccureanceMilk = new SaleOccurence();
		saleOccureanceMilk.setProduct("Milk");
		saleOccureanceMilk.setValue(new BigDecimal(15));
		saleOccureanceMilk.setOccurence(3);
		
		salesMessagesQueue.put(saleOccureanceMilk);
		
		SaleAdjustment saleAdjustmentMilk = new SaleAdjustment();
		saleAdjustmentMilk.setAdjustmentOperation(SaleOperation.SUBTRACT);
		saleAdjustmentMilk.setProduct("Milk");
		saleAdjustmentMilk.setValue(new BigDecimal(10));
		
		salesMessagesQueue.put(saleAdjustmentMilk);
		
		Thread.sleep(2000);

		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(20)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(30000.10)));
		
		SaleOccurence saleOccureanceCake = new SaleOccurence();
		saleOccureanceCake.setProduct("Cake");
		saleOccureanceCake.setValue(new BigDecimal(45));
		saleOccureanceCake.setOccurence(2);
		
		salesMessagesQueue.put(saleOccureanceCake);
		
		SaleAdjustment saleAdjustmentCake = new SaleAdjustment();
		saleAdjustmentCake.setAdjustmentOperation(SaleOperation.MULTIPLY);
		saleAdjustmentCake.setProduct("Cake");
		saleAdjustmentCake.setValue(new BigDecimal(10));
		
		salesMessagesQueue.put(saleAdjustmentCake);
		
		Thread.sleep(1000);
		
		
		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(20)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(30000.10)));
		
		SaleOccurence saleOccureanceToy = new SaleOccurence();
		saleOccureanceToy.setProduct("Toy");
		saleOccureanceToy.setValue(new BigDecimal(45));
		saleOccureanceToy.setOccurence(2);
		
		salesMessagesQueue.put(saleOccureanceToy);
		
		SaleAdjustment saleAdjustmentToy = new SaleAdjustment();
		saleAdjustmentToy.setAdjustmentOperation(SaleOperation.ADD);
		saleAdjustmentToy.setProduct("Toy");
		saleAdjustmentToy.setValue(new BigDecimal(10));
		
		salesMessagesQueue.put(saleAdjustmentToy);
		
		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(20)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(30000.10)));
		
		SaleOccurence saleOccureanceCar = new SaleOccurence();
		saleOccureanceCar.setProduct("Car");
		saleOccureanceCar.setValue(new BigDecimal(45000));
		saleOccureanceCar.setOccurence(2);
		
		Thread.sleep(200);
		
		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(20)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(30000.10)));
		
		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(20)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		Thread.sleep(500);
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(30000.10)));
		
		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(20)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(30000.10)));
		
		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(20)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(30000.10)));
	}
	
	private void produceLessThanFiftyMessagesPositiveScenario() throws InterruptedException {
		Thread.sleep(200);
		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(10)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(40000.10)));
		
		Thread.sleep(200);
		SaleOccurence saleOccureanceApple = new SaleOccurence();
		saleOccureanceApple.setProduct("Apple");
		saleOccureanceApple.setValue(new BigDecimal(15));
		saleOccureanceApple.setOccurence(2);
		
		salesMessagesQueue.put(saleOccureanceApple);
		
		SaleAdjustment saleAdjustmentApple = new SaleAdjustment();
		saleAdjustmentApple.setAdjustmentOperation(SaleOperation.ADD);
		saleAdjustmentApple.setProduct("Apple");
		saleAdjustmentApple.setValue(new BigDecimal(20));
		
		salesMessagesQueue.put(saleAdjustmentApple);
		
		Thread.sleep(200);
		
		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(20)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(30000.10)));
		
		SaleOccurence saleOccureanceMilk = new SaleOccurence();
		saleOccureanceMilk.setProduct("Milk");
		saleOccureanceMilk.setValue(new BigDecimal(15));
		saleOccureanceMilk.setOccurence(3);
		
		salesMessagesQueue.put(saleOccureanceMilk);
		
		SaleAdjustment saleAdjustmentMilk = new SaleAdjustment();
		saleAdjustmentMilk.setAdjustmentOperation(SaleOperation.SUBTRACT);
		saleAdjustmentMilk.setProduct("Milk");
		saleAdjustmentMilk.setValue(new BigDecimal(10));
		
		salesMessagesQueue.put(saleAdjustmentMilk);
		
		Thread.sleep(2000);

		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(20)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(30000.10)));
		
		SaleOccurence saleOccureanceCake = new SaleOccurence();
		saleOccureanceCake.setProduct("Cake");
		saleOccureanceCake.setValue(new BigDecimal(45));
		saleOccureanceCake.setOccurence(2);
		
		salesMessagesQueue.put(saleOccureanceCake);
		
		SaleAdjustment saleAdjustmentCake = new SaleAdjustment();
		saleAdjustmentCake.setAdjustmentOperation(SaleOperation.MULTIPLY);
		saleAdjustmentCake.setProduct("Cake");
		saleAdjustmentCake.setValue(new BigDecimal(10));
		
		salesMessagesQueue.put(saleAdjustmentCake);
		
		Thread.sleep(1000);
		
		
		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(20)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(30000.10)));
		
		SaleOccurence saleOccureanceToy = new SaleOccurence();
		saleOccureanceToy.setProduct("Toy");
		saleOccureanceToy.setValue(new BigDecimal(45));
		saleOccureanceToy.setOccurence(2);
		
		salesMessagesQueue.put(saleOccureanceToy);
		
		SaleAdjustment saleAdjustmentToy = new SaleAdjustment();
		saleAdjustmentToy.setAdjustmentOperation(SaleOperation.ADD);
		saleAdjustmentToy.setProduct("Toy");
		saleAdjustmentToy.setValue(new BigDecimal(10));
		
		salesMessagesQueue.put(saleAdjustmentToy);
		
		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(20)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(30000.10)));
		
		SaleOccurence saleOccureanceCar = new SaleOccurence();
		saleOccureanceCar.setProduct("Car");
		saleOccureanceCar.setValue(new BigDecimal(45000));
		saleOccureanceCar.setOccurence(2);
		
		Thread.sleep(200);
		
		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(20)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
		salesMessagesQueue.put(new Sale("Laptop",new BigDecimal(30000.10)));
		
		salesMessagesQueue.put(new Sale("Apple",new BigDecimal(20)));
		
		salesMessagesQueue.put(new Sale("Car",new BigDecimal(1000000.10)));
		
		salesMessagesQueue.put(new Sale("Cake",new BigDecimal(100.10)));
		
		salesMessagesQueue.put(new Sale("Milk",new BigDecimal(50.10)));
		
	}

	
	private void produceLessThanTenType2Type3Messages() throws InterruptedException {

		for(int i=0;i<9;i++) {
			SaleOccurence saleOccureanceToy = new SaleOccurence();
			saleOccureanceToy.setProduct("Toy");
			saleOccureanceToy.setValue(new BigDecimal(45));
			saleOccureanceToy.setOccurence(2);
			
			salesMessagesQueue.put(saleOccureanceToy);
			
			SaleAdjustment saleAdjustmentToy = new SaleAdjustment();
			saleAdjustmentToy.setAdjustmentOperation(SaleOperation.ADD);
			saleAdjustmentToy.setProduct("Toy");
			saleAdjustmentToy.setValue(new BigDecimal(10));
			
			salesMessagesQueue.put(saleAdjustmentToy);
			
			Thread.sleep(200);
		}

	}

	
	private void produceMoreThanFiftyType2Type3Messages() throws InterruptedException {

		for(int i=0;i<51;i++) {
			SaleOccurence saleOccureanceToy = new SaleOccurence();
			saleOccureanceToy.setProduct("Toy");
			saleOccureanceToy.setValue(new BigDecimal(45));
			saleOccureanceToy.setOccurence(2);
			
			salesMessagesQueue.put(saleOccureanceToy);
			
			SaleAdjustment saleAdjustmentToy = new SaleAdjustment();
			saleAdjustmentToy.setAdjustmentOperation(SaleOperation.ADD);
			saleAdjustmentToy.setProduct("Toy");
			saleAdjustmentToy.setValue(new BigDecimal(10));
			
			salesMessagesQueue.put(saleAdjustmentToy);
			
			Thread.sleep(200);
		}

	}
	
	private void produceType3Messages() throws InterruptedException {
		
		for(int i=0;i<51;i++) {
			Thread.sleep(200);
			
			SaleAdjustment saleAdjustmentApple = new SaleAdjustment();
			saleAdjustmentApple.setAdjustmentOperation(SaleOperation.ADD);
			saleAdjustmentApple.setProduct("Apple");
			saleAdjustmentApple.setValue(new BigDecimal(20));
			
			salesMessagesQueue.put(saleAdjustmentApple);
		}
	}

}
