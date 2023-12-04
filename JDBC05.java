package tw.frank.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//查詢句法 (連線帳密conn等寫成常數比較好)
public class JDBC05 {

	public static void main(String[] args) {	
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			Connection conn = DriverManager.getConnection(		
				"jdbc:mysql://127.0.0.1/cool", prop);
			
			String sql = "SELECT * FROM food";
			Statement stmt = conn.createStatement();// stmt = 產生敘述句 
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String lat = rs.getString("lat");
				String lng = rs.getString("lng");
			 System.out.printf("%s, %s, %s, %s\n", id, name, lat, lng);
			}
			
			conn.close();
			} catch(Exception e) {
				System.out.println(e.toString());
			}
	}
}
//SQL語法數學運算(該系統使用時)才會用INT(型別數值型態，會有預設值)，不然直接用varchart就好!
//JAVA配合自己寫程式要用的就好，呈現不用特別運算，不用再努力INT變字串
//改成用字傳(欄位名稱)取代數字123，來帶*內東西，方便辨識

//資料庫(單一檔案)不等於資料庫伺服器
//chrome table定時匯出備份SQL
