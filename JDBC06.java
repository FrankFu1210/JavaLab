package tw.frank.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

//scanner輸入關鍵字 模糊查詢欄位
public class JDBC06 {

	public static void main(String[] args) {
		System.out.println("Keyword: ");
		Scanner scanner = new Scanner(System.in);
		String key = scanner.next();
		System.out.println("-----");		
		
		//%字串相加，3個?統一使用mykey
		String mykey = "%" + key + "%"; 
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			Connection conn = DriverManager.getConnection(		
				"jdbc:mysql://127.0.0.1:3306/cool",prop);
			String sql = "SELECT * FROM food WHERE name LIKE ? OR addr LIKE ? OR tel LIKE ?";
//			Statement stmt = conn.createStatement();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mykey);
			pstmt.setString(2, mykey);
			pstmt.setString(3, mykey);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				String add = rs.getString("addr");
				String tel = rs.getString("tel");
				System.out.printf("%s : %s : %s\n", name, add, tel);
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
