Step About How to Start a Kafka Service and Zookeper


Steps:

1. Start Zookeper Server Using Command Line
   bin/zookeeper-server-start.sh config/zookeeper.properties

2. Start Kafka Server or Kafka Broker Using Command Line
   bin/kafka-server-start.sh config/server.properties

3. Check Message in Command Line Which Message Kafka-Producer is Produce
   bin/kafka-console-consumer.sh --topic <TOPIC_NAME> --from-beginning --bootstrap-server localhost:9092



Notes:-

Producer for Send a Message to Broker.
Consumer is Read message in and show in Console. 