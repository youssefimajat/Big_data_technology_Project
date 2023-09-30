Open your terminal or command prompt.

 

Navigate to the directory where you want to download Kafka or simply use the cd command to go to your preferred location. For example:

 

cd /path/to/download/location

 

Use wget to download Kafka

wget https://downloads.apache.org/kafka/2.8.0/kafka_2.13-2.8.0.tgz

 

Once the download is complete, you can extract the Kafka archive using the following command:

 

tar -xzf kafka_2.13-2.8.0.tgz

 

we start zookeeper

 zookeeper-server-start.sh config/zookeeper.properties

 

we start kafka

 

kafka-server-start.sh config/server.properties

 

Please extract the contents within your VM and place them in the following directory: /home/cloudera

 

Afterwards, import the project into Eclipse as a fresh project. Then, execute the realEventnews.Main.java and sparkStreamKafkaHive.Runner.java classes.

 

The tables will be loaded as Hive-managed tables, making them conveniently accessible through the hue.

 

Connect to the Hive instance:

!connect jdbc:hive2://localhost:10000 cloudera cloudera