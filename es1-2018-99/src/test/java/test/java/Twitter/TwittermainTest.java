package test.java.Twitter;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.GUI.TwitterGUI;
import main.java.Twitter.Twittermain;
import twitter4j.TwitterException;

public class TwittermainTest {
	
	TwitterGUI t = new TwitterGUI("iscte");

	@Test
	public void testTimeline() {
		t.start();
		t.init();
		assertFalse(t.getEcra().isEmpty());
	}

}
