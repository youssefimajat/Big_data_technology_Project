package cs523.sparkStreamerKafkaHIve;

import java.time.LocalDateTime;

public class Constants {
	public static final String BOOTSTRAPSERVER = "localhost:9092";
	public static final String RESETPARAM ="earliest";
	public static final String TOPIC_ID ="event-news";
	public static final String SERVER_TYPE ="kafka.bootstrap.servers";
	public static final String LOCALHOST_MASTER_URL = "spark://localhost:7077";
	public static final String DILIMETER ="::";
	public static final String URI_HDFS = "hdfs://localhost:8020";
	public static final String HDFS_DIRECTORY = "/user/cloudera/OutputFile";
	public static String dateHour = String.valueOf(LocalDateTime.now().getDayOfYear())+String.valueOf(LocalDateTime.now().getHour());
	public static String ms = dateHour+String.valueOf(LocalDateTime.now().getSecond());

}