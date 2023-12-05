package tw.frank.tutor;

import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import tw.frank.classes.Bike;

//到SQL儲存腳踏車檔案，(但Bike腳踏車沒有宣告實作序列化) 運用setObject，from JDBC11, Bike class
//JAVA程式弄到外面去，通通都叫序列化
public class JDBC13 {
	private static final String USER = "root";	
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/cool";
	private static final String SQL_UPDATE = "UPDATE member SET bike = ? WHERE id = ?";

	public static void main(String[] args) {
		Bike b1 = new Bike();
		b1.upSpeed();b1.upSpeed();
		b1.upSpeed();b1.upSpeed();
		System.out.println(b1.getSpeed());//速度2.7439999999999993
		
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);

		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
			
//			FileInputStream fin = new FileInputStream("dir1/p1.jpg");
//			pstmt.setBinaryStream(1, fin);//? = No.1, file			
			pstmt.setObject(1, b1); // 原本拋出例外java.io.NotSerializableException -> 去Bike將腳踏車類別extends Object implements Serializable			
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
