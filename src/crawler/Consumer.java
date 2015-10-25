package crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Consumer {

	public void crawl(URL url)
	{
		HashSet<String> links = new HashSet<String>();

		try{
//			System.setProperty("http.proxyHost", "10.3.100.207");
//			System.setProperty("http.proxyPort", "8080");
			
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.3.100.207",8080));
			HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);
			uc.connect();
			String line = null;
			StringBuffer tmp = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			while((line = in.readLine())!= null){
				tmp.append(line);
			}
			Document doc = Jsoup.parse(String.valueOf(tmp));
			
			Elements divs = doc.select("a");
			for(Element div : divs){
				String link = div.attr("href");
				links.add(link);
//				System.out.println(div.attr("href"));
			}
			for(String str:links){
				System.out.println(str);
			}
		} catch(IOException ex){
			Logger.getLogger(firstcrawler.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		

	
	}
	public void start(URL url)
	{
		crawl(url);
	}
}
