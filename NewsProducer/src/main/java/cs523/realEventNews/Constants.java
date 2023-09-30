package cs523.realEventNews;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Constants {
	public static final String BOOTSTRAP_SERVER = "127.0.0.1:9092";
	public static final String GET_API_HTTP ="https://api.newscatcherapi.com/v2/latest_headlines?lang=en&page_size=50";
	public static final String API_KEY_ONE ="NAUSOLjeywns8462wgbvq61tepsbqvey7EBQGbs7";
	public static final String API_KEY_TWO ="hm2cE8AcumZuGJ-shdl8YTPO73Jjflsnavronq";
	public static final String API_KEY_THREE ="ZgeTpjKuoGC8-NAI7kjd7ks0jsljdhwyp";
	public static final List<String> API_LIST = Arrays.asList(API_KEY_ONE, API_KEY_TWO, API_KEY_THREE);
	public static final String TOPIC_ID ="event-news";

	public static String randKey(){
		 Random rand = new Random();
		 return (API_LIST.get(rand.nextInt(API_LIST.size())));
	}
}
