package tw.frank.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//增加庫的表單 資料庫: cool 資料表： cust
public class JDBC02 {

	public static void main(String[] args) {

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