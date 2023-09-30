package cs523.realEventNews;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class Main {
	public static List<News> getNews(){
		//CloseableHttpClient httpClient = HttpClients.createDefault();
		List<News> newsList = new ArrayList<News>();
		    /**try{
    		//Create a request and execute the request
    		*
    		* HttpGet request = new HttpGet(NewsConstants.GET_HTTP);
    		request.addHeader("x-api-key",Constants.randKey());
    		CloseableHttpResponse response = httpClient.execute(request);
    		*/
    		
    		//Inserting manual data
    		News news1 = new News("1", "Economic Growth Forecast Revised Upwards", "John Smith", "2023-09-10", "Economists are optimistic about the upcoming fiscal year, with a revised GDP growth forecast of 3.5%.", "Economy", "United States", "Economist Association", true);
    		News news2 = new News("2", "Tech Giants Announce Merger", "Alice Johnson", "2023-09-12", "Two major technology companies, TechCorp and InnovateX, have announced a merger that will reshape the industry.", "Technology", "Global", "TechCorp, InnovateX", false);
    		News news3 = new News("3", "Political Unrest in South America", "Maria Rodriguez", "2023-09-15", "Protests and political instability continue to grip several countries in South America, with citizens demanding change.", "Politics", "Various South American Countries", "Human Rights Watch", true);
    		News news4 = new News("4", "New Breakthrough in Medical Research", "Dr. Emily White", "2023-09-18", "Researchers have made a significant advancement in cancer treatment, offering hope for improved patient outcomes.", "Health", "United Kingdom", "Research Institute for Medical Sciences", true);
    		News news5 = new News("5", "Climate Change Summit Set for November", "David Johnson", "2023-09-20", "Global leaders will convene in Glasgow to address the urgent need for climate action and sustainable policies.", "Environment", "United Kingdom", "UN Climate Council", false);
    		News news6 = new News("6", "Tech Startup Secures $10 Million in Funding", "Sarah Davis", "2023-09-22", "XYZ Tech, a promising startup in the artificial intelligence sector, has successfully raised $10 million in a recent funding round.", "Business", "United States", "XYZ Tech", true);
    		News news7 = new News("7", "Celebrity Couple's Lavish Wedding", "Entertainment Weekly", "2023-09-25", "Hollywood power couple, Jane Smith and Mark Johnson, tie the knot in a star-studded ceremony at a luxury resort.", "Entertainment", "United States", "Celebrity Magazine", true);
    		News news8 = new News("8", "New COVID-19 Variants Detected", "Dr. Amanda Lee", "2023-09-28", "Health officials are monitoring the emergence of new COVID-19 variants, emphasizing the importance of vaccination.", "Health", "Global", "World Health Organization", false);
    		News news9 = new News("9", "Space Exploration Mission to Mars", "NASA Press Office", "2023-10-01", "NASA's upcoming mission to Mars aims to uncover more about the Red Planet's geological history and potential for life.", "Science", "United States", "NASA", true);
    		News news10 = new News("10", "Financial Markets Experience Volatility", "Financial Times", "2023-10-05", "Stock markets around the world are experiencing heightened volatility due to economic uncertainties.", "Finance", "Global", "Financial Times", false);
    		News news11 = new News("11", "Education Reform Bill Passes in Congress", "Sarah Adams", "2023-10-10", "After months of debate, a comprehensive education reform bill has been approved by both houses of Congress.", "Education", "United States", "Education Reform Institute", true);
    		News news12 = new News("12", "Major Art Exhibition Opens in New York", "Art News Magazine", "2023-10-15", "The highly anticipated 'Artistry Unveiled' exhibition featuring renowned artists from around the world is now open at the Met Museum.", "Arts", "United States", "Metropolitan Museum of Art", true);
    		News news13 = new News("13", "Cybersecurity Threats on the Rise", "Cybersecurity Today", "2023-10-18", "Experts warn of an increase in cyberattacks targeting critical infrastructure and businesses, highlighting the need for enhanced cybersecurity measures.", "Technology", "Global", "Cybersecurity Alliance", false);
    		News news14 = new News("14", "Olympic Games Conclude with Record Achievements", "Sports Weekly", "2023-10-22", "The 2023 Summer Olympics wrap up with athletes breaking numerous records and achieving exceptional feats.", "Sports", "Japan", "International Olympic Committee", true);
    		News news15 = new News("15", "Renewable Energy Projects Gain Traction", "Clean Energy Times", "2023-10-25", "Investments in renewable energy projects continue to grow, signaling a shift towards a more sustainable energy future.", "Environment", "Various Countries", "Renewable Energy Association", true);
    		News news16 = new News("16", "SpaceX Launches New Satellite Constellation", "Space News Network", "2023-10-28", "SpaceX successfully deploys a series of advanced communication satellites, expanding global internet coverage.", "Science", "Global", "SpaceX", false);
    		News news17 = new News("17", "Historic Preservation Efforts Recognized", "Heritage Preservation Journal", "2023-11-02", "Several historic landmarks receive recognition and funding for preservation, ensuring their cultural significance is preserved for future generations.", "Culture", "Various Countries", "Heritage Preservation Society", true);
    		News news18 = new News("18", "Global Food Security Summit Addresses Challenges", "Food Security Monitor", "2023-11-05", "World leaders convene to discuss strategies for ensuring food security in the face of climate change and population growth.", "Food", "Global", "United Nations Food Program", true);
    		News news19 = new News("19", "AI Breakthrough Enables Medical Diagnostics", "Medical Advances Journal", "2023-11-09", "A new artificial intelligence algorithm shows promising results in early disease detection, revolutionizing medical diagnostics.", "Health", "Global", "AI Medical Diagnostics Ltd.", false);
    		News news20 = new News("20", "Fashion Trends for the Fall Season", "Fashion & Style Magazine", "2023-11-12", "Top designers showcase their latest collections, offering a glimpse into the hottest fashion trends for the fall season.", "Fashion", "United States", "Fashion Industry Council", true);
    		newsList.add(news1);
    		newsList.add(news2);
    		newsList.add(news3);
    		newsList.add(news4);
    		newsList.add(news5);
    		newsList.add(news6);
    		newsList.add(news7);
    		newsList.add(news8);
    		newsList.add(news9);
    		newsList.add(news10);
    		newsList.add(news11);
    		newsList.add(news12);
    		newsList.add(news13);
    		newsList.add(news14);
    		newsList.add(news15);
    		newsList.add(news16);
    		newsList.add(news17);
    		newsList.add(news18);
    		newsList.add(news19);
    		newsList.add(news20);
    		
    		/**HttpEntity entity = response.getEntity();
    		String retSrc = EntityUtils.toString(entity);
    		JSONObject obs = new JSONObject(retSrc);
    		JSONArray jsonArrayP = obs.getJSONArray("articles");
    		*/
    		    	/**	try {
    		    newsList = jsonArrayP.stream()
    		            .map(sv -> {
    		                JSONObject jsonObject = (JSONObject) sv;
    		                return new News(
    		                        jsonObject.get("_id").toString(),
    		                        jsonObject.get("title").toString(),
    		                        jsonObject.get("author").toString(),
    		                        jsonObject.get("published_date").toString(),
    		                        jsonObject.get("excerpt").toString(),
    		                        jsonObject.get("topic").toString(),
    		                        jsonObject.get("country").toString(),
    		                        jsonObject.get("authors").toString(),
    		                        (boolean) jsonObject.get("is_opinion")
    		                );
    		            })
    		            .collect(Collectors.toList());
    		} catch (IOException e) {
    		    e.printStackTrace();
    		}*/
		return newsList;
	}
	
	public static void produceToKafka(Properties props, List<News> newsList){
    	final KafkaProducer<String, String> producer = new KafkaProducer<>(props);
    	for (News newsEntity : newsList) {
    	    ProducerRecord<String, String> record = new ProducerRecord<>(Constants.TOPIC_ID, newsEntity.getId(), newsEntity.toString());
    	    producer.send(record);
    	}
    	// Close the producer after sending all records
    	producer.close();
	}
	
    public static void main(String[] args) {
    	Properties properties = new Properties();
    	properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.BOOTSTRAP_SERVER);
    	properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		int i =1;
    	while(true){
			try{
				System.out.println("Kafka Job "+i+": Start Time: "+String.valueOf(LocalDateTime.now()));
				produceToKafka(properties, getNews());
				TimeUnit.SECONDS.sleep(10);
				i++;
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
    }
}