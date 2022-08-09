1. SaleMessageProcessingApplication is main entry point for application.
2. Main application instantials BlockingQueue which is used in application to demostrate messaging application.
3. Main application spawns 2 threads to mimic real life scenario of messages publishing/consuming in parallel. One thread for message producer and another thread for message consumer over BlockingQueue created in main thread.
4. ProducerService creats messages of all 3 message types randomly and publishes over BlockingQueue.
5. Consumer runs in a seprate thread to consume message and process them as per business logic.
