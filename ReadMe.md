# Sale Message Processing Application

The application helps to consume messages related to Sale operations and generates multiple reports.

# Getting started

Technology stack includes - Java 8

# Overall flow
 
1. SaleMessageProcessingApplication class is main entry point for application.
2. Main application instantiates BlockingQueue which is used in application to demonstrate messaging application.
3. Main application spawns 2 threads to mimic real life scenario of messages publishing/consuming in parallel. One thread for message producer and another thread for message consumer over BlockingQueue created in main thread.
4. ProducerService creates messages of all 3 message types randomly and publishes over BlockingQueue with random sleep time in between.
4.1 ProducerService has multiple message generation test scenarios
	4.1.1 Produce more than 50 messages with all 3 types and happy path sequence of Type1 messages, then Type 2 then Type 3 and repeat.
	4.1.2 Produce less than 50 messages with all 3 types and happy path sequence of Type1 messages, then Type 2 then Type 3 and repeat.
	4.1.3 Produce more than 50 messages with only type2 (Occurrence) and Type3 (Adjustment) messages.
	4.1.4 Produce only Type 3 messages which will be moved to back out queue.
	4.1.5 Produce less then 10 type2 and type3 messages.
5. Consumer runs in separate thread to consume message and process them as per business logic.
	5.1 As per current consideration if application receives only Type 3 (Adjustment) messages then those will be stored in back out queue and will not be processed.
	5.2 As per current consideration if application receives very first message(s) of Type 3 message before any Type1 or Type2 then those will be stored in back out queue and will not be processed.
6. After processing 50 messages application exits and prints all adjustment 