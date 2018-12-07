package test.java.Facebook;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Facebook.Fmain;
import main.java.GUI.facebook_GUI;

public class FmainTest {
	
	facebook_GUI fg = new facebook_GUI("789");
	

	@Test
	public void testFeed() {
		fg.start();
		fg.init();
		assertFalse(fg.getPost().isEmpty());
	}

}
