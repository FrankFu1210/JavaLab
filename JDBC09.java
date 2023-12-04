package tw.frank.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.frank.classes.BCrypt;

//檢查帳號密碼，讓user去輸入帳號密碼! SQL_LOGIN
public class JDBC09 {
	private static Connection conn;
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/cool";
	private static final String SQL_LOGIN = "SELECT * FROM member WHERE account = ?";

	public static void main(String[] args) {
		// 1.帳號是否存在 -> SQL只要查帳號就好了
		// 2.查詢拿出密碼這串字，再拿出來比對
		
		//連線User Input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Account : ");
		String account = scanner.next();//account是資料庫的事，先檢查唯一鍵不用等資料庫罵回來
		System.out.println("Password : ");
		String passwd = scanner.next();
		
		//login
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		
		//要做的事
		try {
//			Connection conn = DriverManager.getConnection(URL, prop);//原本Connection conn沒改會變成Cannot invoke "java.sql.Connection.prepareStatement(String)" because "tw.frank.tutor.JDBC09.conn" is null
			conn = DriverManager.getConnection(URL, prop);
			//check account
			
			String name;
//			if (login(account, passwd)) {//l小寫...
			if ((name = login(account, passwd)) != null) {//if 執行 assign 比對
				System.out.println("Welcome, " + name);//歡迎誰?? 先導入String
			}else {
				System.out.println("Account REPEAT ERROR");
			}
		}catch(Exception e) {
			System.out.println(e);
		}

	}
//	static boolean login(String account, String passwd) {//布林可以更換成String，也是可以return true/false
	static String login(String account, String passwd) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN);
			pstmt.setString(1, account);
			//查詢 拿到
			ResultSet rs = pstmt.executeQuery();
			
			//開始String 1204 144253
			if (rs.next()) {
				String hashPasswd = rs.getString("password");
				if (BCrypt.checkpw(passwd, hashPasswd)) {
					//OK					
//					return true;
					return rs.getString("name");
				}else {
					//ERR
//					return false;//型別字串return null
					return null;
				}
			}else {
				//ERROR
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
//		return false;
		return null;
	}
}
