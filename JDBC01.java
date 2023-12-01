package tw.frank.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//資料庫連線
public class JDBC01 {

	public static void main(String[] args) {
		//1. Load Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//類別的類別，載入驅動程式，反射類別(直接問)
			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} 
		//--------------------------------------
		
		try {
			//招1
//			Connection conn = DriverManager.getConnection(
//					//連到主機，通訊協定代參數的方法為?
//					//加入cool連到該資料庫
//					"jdbc:mysql://127.0.0.1:3306/cool?user=root&password=root");

			//招2 變更連接方式
//			Connection conn = DriverManager.getConnection(
//					"jdbc:mysql://127.0.0.1:3306/cool","root","root");
			
			//招3 太多參數用一個物件帶入
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/cool",prop);
			
			//連線物件實體
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM cust";
//			String sql = "INSERT INTO cust (id,cname,tel)" + //字串相加
////					"VALUES (1,'brad','123')" +//數值不加其他通加''
//					"VALUES (2,'brad','123')" +
//					",(3,'brad','123')" +
//					",(4,'brad','123')" +
//					",(5,'brad','123')" ;
								
			//1.塞入execute傳回布林值
//			stmt.execute(sql)
			//2.執行更新update (增刪修好用)
			int n = stmt.executeUpdate(sql);
			System.out.println(n);
			//3.執行query
//			stmt.exQ
			
			//			System.out.println("OK2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
