package tw.frank.tutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

//http parse頁面JSON資料 -> 爬蟲 from L60
public class L63 {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
			URLConnection conn = url.openConnection();
			
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
				String line;
				//API變大字串
				StringBuffer sb = new StringBuffer();
				
				while((line = reader.readLine()) != null) {
//					System.out.println(line);
					sb.append(line);
				}
				parseJSON(sb.toString());
			};
			
			//瀏覽器先撈頁面原始碼,文字資料,運用bufferreader!
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
		//解析JSON
		//尋訪，有for each直接轉型變成JSON obj，再取得key值，沒有for each要一個一個get出來
		static void parseJSON(String json) {
			JSONArray root = new JSONArray(json);
			System.out.println(root.length());//裡面有幾個元素? 139，確認JSON資料可被印出
			
			for ( Object row : root) {
				JSONObject data = (JSONObject)row;//強制轉型
//				String name = data.getString("Name");
				System.out.println(data.getString("Name"));
			}
		}		
}

//應用程式可以匯集多個open data
//1131準備進入資料庫!
