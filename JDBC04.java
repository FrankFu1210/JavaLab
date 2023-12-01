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
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
//from L63 & JDBC02
public class JDBC04 {
	
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
	

		static void parseJSON(String json) {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			//預先準備SQL語法
			try (Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/cool",prop);){
				
				//隱碼攻擊在變數上面 直接寫?，變數用字串組合起來%brad%變字串塞到?裡 (不是?%)
				String name = "Brad";
				String tel = "123";
				String birthday = "1999-01-01";
				String sql = "INSERT INTO cust (cname,tel,birthday) VALUE (?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				//型別由這邊決定，字串第幾個? JAVA.SQL系列Index從1開始
				pstmt.setString(1, name);//用這邊過濾隱碼攻擊(Statement變成PreparedStatement)
				pstmt.setString(2, tel);
				pstmt.setString(3, birthday);
				
				pstmt.executeUpdate();
				System.out.println("OK");
				
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
}
