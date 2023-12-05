package tw.frank.tutor;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

//到SQL儲存頭像icon圖檔，運用FileInputStream setBinaryStream
//(BIOB 64kb) frome JDBC10 -> 變成base64字串出來
public class JDBC11 {
	//沒有static的話，需要JDBC11這檔案的物件屬性!
	private static final String USER = "root";	
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/cool";
	private static final String SQL_UPDATE = "UPDATE member SET icon = ? WHERE id = ?";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);

		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
			FileInputStream fin = new FileInputStream("dir1/p1.jpg");
			pstmt.setBinaryStream(1, fin);//? = No.1, file
			pstmt.setInt(2, 1);//? = No.2, id = 1
			
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Update Success");
			}else {
				System.out.println("Update Failure");
			}			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
