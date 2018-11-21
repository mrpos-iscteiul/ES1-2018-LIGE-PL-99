package test.java.Twitter;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Twitter.Twittermain;
import twitter4j.TwitterException;

public class TwittermainTest {
	
	Twittermain t = new Twittermain();

	@Test
	public void testTimeline() {
		try {
			t.timeline();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		assertFalse(t.getList().isEmpty());
	}

}
