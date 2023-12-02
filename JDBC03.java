package tw.frank.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//修改資料庫: cool 資料表： cust，No.3名字 刪除No.2
public class JDBC03 {

	public static void main(String[] args) {

			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			//預先準備SQL語法
			try (Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/cool",prop);){
				
				//隱碼攻擊在變數上面 直接寫?，變數用字串組合起來%brad%變字串塞到?裡 (不是?%)
				String name = "Leo & Xi";
				int id = 3;
				String sql = "UPDATE cust SET cname = ? WHERE id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				//型別由這邊決定，字串第幾個? JAVA.SQL系列Index從1開始
				pstmt.setString(1, name);//用這邊過濾隱碼攻擊(Statement變成PreparedStatement)
				pstmt.setInt(2, id);
				
				pstmt.executeUpdate();
				System.out.println("OK");
				//-----------------------------------------------
				int id2 = 2;
				String sql2 = "DELETE FROM cust WHERE id = ?";
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				//型別由這邊決定，字串第幾個? JAVA.SQL系列Index從1開始
				pstmt2.setInt(1, id2);
				
				pstmt2.executeUpdate();
				System.out.println("OK");
				
			} catch (SQLException e) {
				System.out.println(e);
			}
			
	}
}