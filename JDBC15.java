package tw.frank.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

//查詢資料，移動游標!然後去做增刪修，運用TYPE_SCROLL_INSENSITIVE, CONCUR_UPDATABLE, rs.updateRow()
public class JDBC15 {
	private static final String USER = "root";	
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/cool";
	private static final String SQL_QUERY = "SELECT * FROM cust";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(
					SQL_QUERY,
					ResultSet.TYPE_SCROLL_INSENSITIVE, // 招式1，定義移動方式 (另外2招與commit有關)
					ResultSet.CONCUR_UPDATABLE
					);
			
			// 拿到Resultset，用普通方法巡訪他
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String cname = rs.getString("cname");
				System.out.printf("%s : %s\n", id, cname);// 1 : Brad 3 : Leo & Xi 4 : Brad 5 : Brad		
			}
			System.out.println("----");
			
			if (rs.first()) {
				String id = rs.getString("id");
				String cname = rs.getString("cname");
				System.out.printf("%s : %s\n", id, cname);// 1 : Brad
				
				rs.absolute(3);
				id = rs.getString("id");
				cname = rs.getString("cname");
				System.out.printf("%s : %s\n", id, cname);// 5 : Brad
				
				rs.updateString("cname", "Tony");
				rs.updateString("tel", "456");
				// rs物件實體就是記憶體，在記憶體裡面修改運作 rs.updateRow()
//				rs.updateRow();  //變成5 Tony tel(456)				
				
				System.out.println("---");
				rs.absolute(3);
//				rs.deleteRow();//刪除4 Brad
				
				System.out.println("----");
				rs.moveToInsertRow();
				rs.updateString("cname", "Kevin");
				rs.updateString("tel", "789");
				rs.updateString("birthday", "1999-02-03");
				rs.insertRow();//變成6 Kevin tel(789) birthday(1999-02-03)	
				
				
			}else {
				System.out.println("XX");
			}				
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}