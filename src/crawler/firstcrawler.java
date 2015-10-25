package crawler;

import java.net.MalformedURLException;
import java.net.URL;

public class firstcrawler {

	public static void main(String[] args) {
		try {
			new Consumer().start(new URL("http://www.jsoup.org/"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
