package Facebook;

import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;

public class Fmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String accessToken="EAACnyXeKEEkBAEBd0pqQAT19f7emVmZCWh8ejRce7YUcY57pFOFux3FTZB93qJgHz9wsA5WW6X4ZCQsm0ivq36QQIAYaoChBsFi7z6ZBANr2fVZC75QZCwEL4WWPWskUQoZBcUpYRSRZCCuzqWmprZB9XaZBYOW4ZAPgIE8S6H88EygRwZDZD";
		FacebookClient fbclient = new DefaultFacebookClient(accessToken);
		
		Connection<Post> result = fbclient.fetchConnection("me/feed", Post.class);
		int countP=0;
		for(List<Post> page : result) {
			for(Post aPost : page){
				System.out.println(aPost.getMessage());
				System.out.println("Id: "+"fb.com/"+aPost.getId());
				countP++;
			}
			
		}
		System.out.println("Nº de resultados: " + countP);
		

	}

}