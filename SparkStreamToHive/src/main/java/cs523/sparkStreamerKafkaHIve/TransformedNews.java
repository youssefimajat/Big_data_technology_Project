package cs523.sparkStreamerKafkaHIve;

import java.io.Serializable;

public class TransformedNews implements Serializable {
	   private int id;
	    private String keywords;

	    public TransformedNews() {
	        // Default constructor
	    }

	    public TransformedNews(int id, String keywords) {
	        this.id = id;
	        this.keywords = keywords;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getKeywords() {
	        return keywords;
	    }

	    public void setKeywords(String keywords) {
	        this.keywords = keywords;
	    }

	    @Override
	    public String toString() {
	        return id + ", " + keywords;
	    }
}
