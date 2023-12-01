package tw.frank.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

//http 將網頁存成PDF檔案 from L61
public class L62 {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://pdfmyurl.com/?url=https://codepen.io/");
			URLConnection conn = url.openConnection();
			
			try(BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
					FileOutputStream fout = new FileOutputStream("dir2/codepen.pdf")
					){
				
				int len; byte[] buf = new byte[4*1024*1024];
				while ((len = bin.read(buf)) != -1) {
					fout.write(buf, 0, len);
				}
				
				fout.flush();
				System.out.println("OK");
				
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}	
