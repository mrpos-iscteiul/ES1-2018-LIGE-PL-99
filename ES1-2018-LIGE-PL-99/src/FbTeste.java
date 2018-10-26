import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

class FbTeste {
	
	String accessToken="EAACnyXeKEEkBAEBd0pqQAT19f7emVmZCWh8ejRce7YUcY57pFOFux3FTZB93qJgHz9wsA5WW6X4ZCQsm0ivq36QQIAYaoChBsFi7z6ZBANr2fVZC75QZCwEL4WWPWskUQoZBcUpYRSRZCCuzqWmprZB9XaZBYOW4ZAPgIE8S6H88EygRwZDZD";
	FacebookClient fbclient = new DefaultFacebookClient(accessToken);
	User me = fbclient.fetchObject("me", User.class);

	@Test
	public void testGetName() {
		assertEquals(me.getName(), "Diogo Juvandes");
	}
	
	@Test
	public void testGetId() {
		assertEquals(me.getId(), "1986142911424051");
	}
	

}
