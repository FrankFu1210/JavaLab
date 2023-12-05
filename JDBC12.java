package tw.frank.tutor;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

//從SQL撈取頭像icon圖檔，運用FileOutputStream getBinaryStream
public class JDBC12 {
	private static final String USER = "root";	
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/cool";
	private static final String SQL_QUERY = "SELECT * FROM member WHERE id = ?";

	public static void main(String[] args) {
		// 不知道串流檔案大小，才跑while迴圈! 知道大小直接用buf臉盆裝~
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			pstmt.setInt(1, 1);//? = No.1, id = 1
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				InputStream in = rs.getBinaryStream("icon");
				//----
				FileOutputStream fout = new FileOutputStream("dir2/p1.jpg");
				byte[] buf = new byte[128*1024];
				int len = in.read(buf);
				fout.write(buf, 0, len);
				fout.flush();
				fout.close();
				System.out.println("OK");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
