package Twitter;

import java.util.List;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Twittermain {
	private List<Status> Estado;

	public static void timeline() throws TwitterException {
		ConfigurationBuilder cf = new ConfigurationBuilder();

		cf.setDebugEnabled(true)
		.setOAuthConsumerKey("S3zvRA8J9QMlFFQneABHyNU68")
		.setOAuthConsumerSecret("xYcjr59LMFWiWBTYPX4ZzZah8JAtAyaEPhZzeqrd4u1lZKcm9I")
		.setOAuthAccessToken("561479088-UJZeNdtVGUbyyFCoNaaPqFkyOrYtPngufARZWeeb")
		.setOAuthAccessTokenSecret("uSKkUOPxJSf9HyT76oLGEoY14g8mbDlp0tVSxCahBMRmz");

		TwitterFactory tf = new TwitterFactory(cf.build());
		twitter4j.Twitter twitter=tf.getInstance();

		 Estado= twitter.getHomeTimeline();

		for(Status s : Estado) {
			System.out.println(s.getUser().getName()+"  "+s.getText());
		}
	}

	public static void main(String[] args) throws TwitterException {
		Twittermain.timeline();
		

	}

}
