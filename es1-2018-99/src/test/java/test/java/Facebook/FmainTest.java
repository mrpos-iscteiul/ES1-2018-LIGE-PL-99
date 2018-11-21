package test.java.Facebook;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Facebook.Fmain;

public class FmainTest {
	
	Fmain fm = new Fmain();

	@Test
	public void testFeed() {
		fm.feed();
		assertEquals(fm.getC(), 215);
	}

}
