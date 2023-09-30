package cs523.sparkStreamerKafkaHIve;

import java.util.Arrays;
import java.util.List;


public class BlackList {
	public static final List<String> blackList = Arrays.asList(
	"adult","violence","drugs","sex","porn", "explicit","hate","racism","terrorism","gore",
    "gambling","weapons","self-harm","suicide","abuse");
	public static List<String> getBlackList(){
		return blackList;
	}
}
