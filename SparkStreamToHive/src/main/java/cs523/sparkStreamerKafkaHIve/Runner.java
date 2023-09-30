package cs523.sparkStreamerKafkaHIve;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.StreamingContext;
import org.apache.spark.streaming.api.java.*;
import org.apache.spark.streaming.dstream.InputDStream;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import scala.Tuple2;

public class Runner {
	public static void main(String[] args) throws InterruptedException, TimeoutException, StreamingQueryException{		
		Map<String,Object> kafkaProperties = new HashMap<>();
    	kafkaProperties.put("bootstrap.servers", Constants.BOOTSTRAPSERVER);
    	kafkaProperties.put("key.deserializer", StringDeserializer.class);
    	kafkaProperties.put("value.deserializer", StringDeserializer.class);
    	kafkaProperties.put("group.id", Constants.TOPIC_ID);
    	kafkaProperties.put("auto.offset.reset", Constants.RESETPARAM);
    	kafkaProperties.put("enable.auto.commit", false);
    	
    	SparkConf sparkConf = new SparkConf().setAppName(Constants.TOPIC_ID).setMaster("local[*]");
    	StreamingContext streamingContext = new StreamingContext(sparkConf, new Duration(20001));
    	Collection<String> kafkaTopics = Arrays.asList(Constants.TOPIC_ID);
    	InputDStream<ConsumerRecord<String,String>> inputStream = 
    			KafkaUtils.createDirectStream(
    				streamingContext,
        			LocationStrategies.PreferConsistent(),
        			ConsumerStrategies.<String,String>Subscribe(kafkaTopics,kafkaProperties)

    	);
    	
    	// Creation of SparSession
    	
    	/**SparkSession spark = SparkSession
    		    .builder()
    		    .appName(Constants.TOPIC_ID)
    		    .config("hive.metastore.uris", "thrift://127.0.0.1:9083") // Configure Hive metastore URI
    		    .enableHiveSupport()
    		    .getOrCreate();
    	
    	spark.sql("SELECT * FROM newDB").show();
    	*/
    	JavaInputDStream<ConsumerRecord<String,String>> dStream = new JavaInputDStream<ConsumerRecord<String,String>>(inputStream, null);
    	
    	JavaPairDStream<String,String> filtredNews = dStream
    			.map(f->f.key()+" "+f.value())
    			.map(f->Arrays.asList(f.split(Constants.DILIMETER)))
    			.map(f->Arrays.asList(f.get(0).split("[ ^'\"]")))
    			.map(e->e.stream().map((k)->{
    				return k.replaceAll("[^a-zA-Z0-9]", " ").trim();
    				}).collect(Collectors.toList()))
    			.map(f->{
    				f.removeIf(BlackList.blackList::contains);
    				f.removeIf(r->r.matches("\\s*"));
    				return f;
    			})
    			.mapToPair(f->{
    				String id = f.remove(0);
    				f.add(String.valueOf(f.size()));
    				return new Tuple2<String,String>(id,f.toString());
    			});
    	
    	filtredNews.foreachRDD(rdd->{
    		//rdd.saveAsTextFile(StreamerConstants.HDFS_URI+StreamerConstants.DIRECTORY_HDFS+"_"+String.valueOf(LocalDateTime.now().getDayOfYear())+String.valueOf(LocalDateTime.now().getHour())+"/output_"+String.valueOf(LocalDateTime.now().getMinute())+String.valueOf(LocalDateTime.now().getSecond()));
    	    rdd.collect().forEach(item -> System.out.println(item.toString()));
    		/** if (!rdd.isEmpty()) {
    	        SparkSession sparkSession = SparkSession.builder().config(rdd.context().getConf()).getOrCreate();
    	        JavaRDD<Row> rowRDD = rdd.map(tuple -> RowFactory.create(tuple._1(), tuple._2()));
    	        StructType schema = new StructType(new StructField[]{
    	            new StructField("id", DataTypes.StringType, false, Metadata.empty()),
    	            new StructField("data", DataTypes.StringType, false, Metadata.empty())
    	        });
    	        Dataset<Row> df = sparkSession.createDataFrame(rowRDD, schema);
    	        
    	        // Save the DataFrame into a Hive table
    	        df.createOrReplaceTempView("newDB"); // Create a temporary view
    	        sparkSession.sql("INSERT INTO TABLE newDB SELECT * FROM newDB");
    	    } */
    	});
    	streamingContext.start();
    	
    	streamingContext.awaitTermination();
	}
}

