package com.sale;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import com.sale.consumer.SaleMessageConsumerService;
import com.sale.producer.SaleMessageProducerService;
import com.sale.vo.IMessage;

public class SaleMessageProcessingApplication {

	public static void main(String[] args) {
		BlockingQueue<IMessage> salesMessagesQueue = new LinkedBlockingDeque<IMessage>(50);
		
		new Thread(new SaleMessageConsumerService(salesMessagesQueue)).start();
		
		new Thread(new SaleMessageProducerService(salesMessagesQueue)).start();
		
	}

}
