package cs523.realEventNews;

import java.io.Serializable;


public class News implements Serializable{
	
	private static final long serialVersionUID = 1L;
    private String newsId;
    private String newsTitle;
    private String newsAuthor;
    private String newsPublishedDateTime;
    private String newsExc;
    private String newsTopic;
    private String newsCountry;
    private String newsAuthors;
    private boolean newsIsOpinion;
    
	public String getId() {
		return newsId;
	}

	public void setId(String id) {
		this.newsId = id;
	}

	public String getTitle() {
		return newsTitle;
	}

	public void setTitle(String title) {
		this.newsTitle = title;
	}

	public String getAuthor() {
		return newsAuthor;
	}

	public void setAuthor(String author) {
		this.newsAuthor = author;
	}

	public String getPublishedDateTime() {
		return newsPublishedDateTime;
	}

	public void setPublishedDateTime(String publishedDateTime) {
		this.newsPublishedDateTime = publishedDateTime;
	}
	
	public String getExcerpt() {
		return newsExc;
	}

	public void setExcerpt(String excerpt) {
		this.newsExc = excerpt;
	}

	public String getTopic() {
		return newsTopic;
	}

	public void setTopic(String topic) {
		this.newsTopic = topic;
	}

	public String getCountry() {
		return newsCountry;
	}

	public void setCountry(String country) {
		this.newsCountry = country;
	}

	public String getAuthors() {
		return newsAuthors;
	}

	public void setAuthors(String authors) {
		this.newsAuthors = authors;
	}

	public boolean isOpinion() {
		return newsIsOpinion;
	}

	public void setOpinion(boolean isOpinion) {
		this.newsIsOpinion = isOpinion;
	}

	public News(String id, String title, String author,
			String publishedDateTime, String newsExc, String topic,
			String country, String authors, boolean isOpinion) {
		super();
		this.newsId = id;
		this.newsTitle = title;
		this.newsAuthor = author;
		this.newsPublishedDateTime = publishedDateTime;
		this.newsExc = newsExc;
		this.newsTopic = topic;
		this.newsCountry = country;
		this.newsAuthors = "["+authors+"]";
		this.newsIsOpinion = isOpinion;
	}

	@Override
	public String toString() {
		return newsTitle + "::" + newsAuthor
				+ "::" + newsPublishedDateTime + "::"
				+"\"" +newsExc + "\"" + "::"
				+ "::" + newsTopic + "::" + newsCountry
				+ "::" + newsAuthors + "::" + newsIsOpinion;

	}
    
}
