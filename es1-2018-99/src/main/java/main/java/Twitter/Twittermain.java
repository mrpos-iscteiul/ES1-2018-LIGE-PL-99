package main.java.Twitter;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Twittermain {

	ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	ConfigurationBuilder cf = new ConfigurationBuilder();
	TwitterFactory tf;
	twitter4j.Twitter twitter;

	public class Tweet{
		String user;
		String text;
		long id;
		public Tweet(String user, String text, long id) {
			this.user=user;
			this.text=text;
			this.id=id;
		}

		public String toString() {
			return user+":  "+text;
		}
		
		public long getId() {
			return id;
		}
	}


	public List getList() {
		return tweets;
	}


	public void timeline() throws TwitterException {
		

		cf.setDebugEnabled(true)
		.setOAuthConsumerKey("S3zvRA8J9QMlFFQneABHyNU68")
		.setOAuthConsumerSecret("xYcjr59LMFWiWBTYPX4ZzZah8JAtAyaEPhZzeqrd4u1lZKcm9I")
		.setOAuthAccessToken("561479088-UJZeNdtVGUbyyFCoNaaPqFkyOrYtPngufARZWeeb")
		.setOAuthAccessTokenSecret("uSKkUOPxJSf9HyT76oLGEoY14g8mbDlp0tVSxCahBMRmz");
		
//		cf.setDebugEnabled(true)
//		.setOAuthConsumerKey(t1)
//		.setOAuthConsumerSecret(t2)
//		.setOAuthAccessToken(t3)
//		.setOAuthAccessTokenSecret(t4);

		tf = new TwitterFactory(cf.build());
		twitter=tf.getInstance();
		
		List<Status> Estado=twitter.getHomeTimeline();
		for(Status s : Estado) {

			Tweet t = new Tweet(s.getUser().getName(), s.getText(), s.getId());
			tweets.add(t);
		

		}
	}
	
	

	public void retweeet (long id) throws TwitterException {
		twitter.retweetStatus(id);
	}
	
	public void like (long id) throws TwitterException {
		twitter.createFavorite(id);
	}
	//
	//	public static void main(String[] args) throws TwitterException {
	//		Twittermain t = new Twittermain();
	//		t.timeline();
	//		System.out.println(t.tweets.isEmpty());
	//	
	//
	//	}

}
