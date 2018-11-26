package main.java.Twitter;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Twittermain {
	
	 ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	
	public class Tweet{
		String user;
		String text;
		public Tweet(String user, String text) {
			this.user=user;
			this.text=text;
		}
		
		public String toString() {
			return user+":  "+text;
		}
	}
	
	
	public List getList() {
		return tweets;
	}
	

	public void timeline() throws TwitterException {
		ConfigurationBuilder cf = new ConfigurationBuilder();

		cf.setDebugEnabled(true)
		.setOAuthConsumerKey("S3zvRA8J9QMlFFQneABHyNU68")
		.setOAuthConsumerSecret("xYcjr59LMFWiWBTYPX4ZzZah8JAtAyaEPhZzeqrd4u1lZKcm9I")
		.setOAuthAccessToken("561479088-UJZeNdtVGUbyyFCoNaaPqFkyOrYtPngufARZWeeb")
		.setOAuthAccessTokenSecret("uSKkUOPxJSf9HyT76oLGEoY14g8mbDlp0tVSxCahBMRmz");

		TwitterFactory tf = new TwitterFactory(cf.build());
		twitter4j.Twitter twitter=tf.getInstance();

		List<Status> Estado=twitter.getHomeTimeline();
		for(Status s : Estado) {
			
			Tweet t = new Tweet(s.getUser().getName(), s.getText());
			tweets.add(t);
			System.out.println(t);
		}
	}

	public static void main(String[] args) throws TwitterException {
		Twittermain t = new Twittermain();
		t.timeline();
		System.out.println(t.tweets.isEmpty());
	

	}

}
