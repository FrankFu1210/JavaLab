package tw.frank.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//http 抓URL圖片 -> 爬蟲
public class L61 {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://img.freepik.com/premium-photo/caffee-cup-book-wooden-table-world-coffee-day-concept-generated-ia_911917-826.jpg?w=740");
			URLConnection conn = url.openConnection();
			
			try(BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
					FileOutputStream fout = new FileOutputStream("dir2/caffee.jpg")
				){
				//準備另外一個輸出串流把它存起來FOS (圖片看頁面原始碼binary沒意義)
				
//				String line;
				int len; byte[] buf = new byte[4*1024*1024];
//				while((line = reader.readLine()) != null) {
//					System.out.println(line);
				while((len = bin.read(buf)) != -1) {
					fout.write(buf, 0, len);
				}
				fout.flush();
				System.out.println("OK");
				
			}
			
			//瀏覽器先撈頁面原始碼,文字資料,運用bufferreader!
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
