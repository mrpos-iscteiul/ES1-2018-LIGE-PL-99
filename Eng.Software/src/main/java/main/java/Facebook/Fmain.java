package main.java.Facebook;

import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;
import com.restfb.types.User;

public class Fmain {
	
	int countP=0;
	
	public int getC() {
		return countP;
	}
	
	public void feed() {
		
		String accessToken="EAACnyXeKEEkBAEBd0pqQAT19f7emVmZCWh8ejRce7YUcY57pFOFux3FTZB93qJgHz9wsA5WW6X4ZCQsm0ivq36QQIAYaoChBsFi7z6ZBANr2fVZC75QZCwEL4WWPWskUQoZBcUpYRSRZCCuzqWmprZB9XaZBYOW4ZAPgIE8S6H88EygRwZDZD";
		FacebookClient fbclient = new DefaultFacebookClient(accessToken);
		User me = fbclient.fetchObject("me", User.class);
		
		Connection<Post> result = fbclient.fetchConnection("me/feed", Post.class);
		
		for(List<Post> page : result) {
			for(Post aPost : page){
				System.out.println(aPost.getMessage());
				System.out.println("Id: "+"fb.com/"+aPost.getId());
				countP++;
			}
			
		}
		System.out.println("Nº de resultados: " + countP);
	}

	public static void main(String[] args) {
		Fmain fm = new Fmain();
		fm.feed();
		
		/**
		 * Acesso ao utilizador
		 */
		
		
		
		/**
		 * Acesso e impressão do feed do utilizador e nr de resultados
		 */
		
		

	
		

	}

}