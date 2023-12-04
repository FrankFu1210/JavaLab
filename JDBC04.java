package tw.frank.tutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
//將open data資料抓回資料庫表單中，農委會open data到資料庫: cool 資料表： food (from L63 & JDBC02)
public class JDBC04 {
	
	public static void main(String[] args) {
		//L63
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
		//JDBC02
		static void parseJSON(String json) {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			try (Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/cool",prop);){
			
			// 老師寫的
			Statement stmt = conn.createStatement();
			//砍全部
			stmt.executeUpdate("DELETE FROM food");
			//歸0 ALTER表執行改造
			stmt.executeUpdate("ALTER TABLE food AUTO_INCREMENT=1");
			
			// 下面自己寫的:)
			String sql2 = """
							DELETE FROM food;
							""";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);	
			pstmt2.executeUpdate();
			System.out.println("OK");
			
			//ALTER表執行改造
			String sql3 = """
							ALTER TABLE food AUTO_INCREMENT=1;
							""";
			PreparedStatement pstmt3 = conn.prepareStatement(sql3);	
			pstmt3.executeUpdate();
			System.out.println("OK");
				
				
			String sql = """
							INSERT INTO food (name, addr, tel, pic, lat, lng) VALUES (?,?,?,?,?,?)
					
							""";
//	// //				ALTER TABLE food AUTO_INCREMENT=1
						
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			JSONArray root = new JSONArray(json);//[]
			for (Object row : root) {//{}
				JSONObject data = (JSONObject)row;//{裡面的data}
				String name = data.getString("Name");
				String addr = data.getString("Address");
				String tel = data.getString("Tel");
				String pic = data.getString("PicURL");
				String lat = data.getString("Latitude");
				String lng = data.getString("Longitude");
				System.out.println(name);
				
				pstmt.setString(1, name);
				pstmt.setString(2, addr);
				pstmt.setString(3, tel);
				pstmt.setString(4, pic);
				try {
					pstmt.setDouble(5, Double.parseDouble(lat));
					pstmt.setDouble(6, Double.parseDouble(lng));					
				} catch (Exception e) {
					pstmt.setDouble(5, 0.0);
					pstmt.setDouble(6, 0.0);
				}
				pstmt.executeUpdate();
				
			}
				
				System.out.println("OK");
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
}
// [MySQL]如何設定歸零自動編號
// 由於auto_increment ，在刪除資料列後的id會累加
// 1.在MyAdmin用truncate table food; 可以將MySql 自動遞增歸零
// 2.刪除資料DELETE FROM food; 然後輸入ALTER TABLE food AUTO_INCREMENT=1;
// https://maxine-divinglife.medium.com/mysql-auto-increment-%E6%AD%B8%E9%9B%B6%E5%92%8C%E9%87%8D%E6%96%B0%E8%A8%88%E7%AE%97-a427ca3d56eb

// 通過使用三個雙引號"""將SQL語句括起來，可以在多行中編寫SQL，而不需要使用字符串拼接
// https://blog.51cto.com/u_16213410/7655208

// 開發時期不要做foreign key，開發後固定再連結