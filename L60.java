package tw.frank.tutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//http 抓頁面原始碼 -> 爬蟲
public class L60 {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://www.ispan.com.tw");
			URLConnection conn = url.openConnection();
			
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
				String line;
				while((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			};
			
			//瀏覽器先撈頁面原始碼,文字資料,運用bufferreader!
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
