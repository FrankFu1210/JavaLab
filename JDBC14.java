package tw.frank.tutor;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.frank.classes.Bike;

//從SQL撈取腳踏車檔案，運用getBinaryStream (沒有getObject)，from JDBC12, Bike class
public class JDBC14 {
	private static final String USER = "root";	
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/cool";
	private static final String SQL_QUERY = "SELECT * FROM member WHERE id = ?";

	public static void main(String[] args) {			
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			pstmt.setInt(1, 1);//? = No.1, id = 1
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {//有沒有rs.next()!= null結束用法? 除if外方法?
				InputStream in = rs.getBinaryStream("bike");// 拿出物件管子一樣是getBinaryStream，沒有getObject
				//----
//				FileOutputStream fout = new FileOutputStream("dir2/p1.jpg");
				ObjectInputStream oin = new ObjectInputStream(in);// 解序列化 串接 oin，無ObjectOutputStream? 可下載檔案?
				Object obj = oin.readObject();
				if (obj instanceof Bike) {
					System.out.println("Bike");//只能存放，不能搜尋的資料	
					
					Bike bike = (Bike)obj;//強制轉型回來，擁有該物件屬性方法
					System.out.println(bike.getSpeed());//速度2.7439999999999993
				}
				
//				byte[] buf = new byte[128*1024];
//				int len = in.read(buf);
//				fout.write(buf, 0, len);
//				fout.flush();
//				fout.close();
				System.out.println("OK");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
//再來跟隨指標更新資料