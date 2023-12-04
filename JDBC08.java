package tw.frank.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.frank.classes.BCrypt;
//運用BCrypt.java密碼加密存到資料表裡面，建立常數化模板~ SQL_INSERT SQL_CHECK
public class JDBC08 {
	//把重要資料常數化，以後可以直接複製貼上，並整理一下程式碼維護性，且較好除錯!
	//輸入資料
	private static Connection conn;
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/cool";
	private static final String SQL_INSERT = "INSERT INTO member (account, password, name) VALUES (?,?,?)";
//	private static final String SQL_CHECK = "SELECT * FROM member WHERE account = ?";//*招式1 判斷next()有沒有重複*
	private static final String SQL_CHECK = "SELECT count(*) as count FROM member WHERE account = ?";//*招式2 判斷count(*)是否=0*

	//把main方法寫得太複雜，寫完才能入進去，改採下面static check方法
	public static void main(String[] args) {
		// User Input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Account : ");
		String account = scanner.next();//account是資料庫的事，先檢查唯一鍵不用等資料庫罵回來
		System.out.println("Password : ");
		String passwd = scanner.next();
		System.out.println("Name : ");
		String name = scanner.next();
		
		//把加密碼寫入資料表中
		String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		
		//建立連線
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);		
		
		//負責主流程
		try {
//			Connection conn = DriverManager.getConnection(URL, prop);//Connection conn連線寫在上面
			conn = DriverManager.getConnection(URL, prop);
//			PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);//挪到下面
			
			//check account;
			if (checkAccount(account)) {
				//INSERT INTO member
				if (addMember(account, passwd, name)) {
					System.out.println("Add success");
				}else {
					System.out.println("Add failure");
				}
			}else {
				System.out.println("account REPEAT ERROR");
			}
		}catch(Exception e) {
			System.out.println(e);
		}

	}

	static boolean checkAccount(String account) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL_CHECK);
			pstmt.setString(1, account);
			//查詢 拿到
			ResultSet rs = pstmt.executeQuery();
			rs.next();//rs又忘了寫...!!!
			//1204 142839
			//*招式1 判斷next()有沒有重複*
//			if (rs.next()) {
//				return false;
//			}else {
//				return true;
//			}
			
			//*招式2 判斷count(*)是否=0*
			int num = rs.getInt("count");
			if (num == 0) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
//		return true;//*招式1 判斷next()有沒有重複*
		return false;//*招式2 判斷count(*)是否=0*
	}
	
	static boolean addMember(String account, String passwd, String name) {
		String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		try {
//			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, account);
			pstmt.setString(2, hashPasswd);
			pstmt.setString(3, name);
			int n = pstmt.executeUpdate();//換成接受INT好做判斷
			if (n > 0) {
				return true;
//			}else {
//				return false;//跟外面例外一樣，可以不用寫
			}			
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}

//http + 查詢密碼 = 超危險!
//分享是進步的動力~ 自學非本科系，看書/除錯知道為什麼超爽
//(資料庫member SQL測試密碼我設為123)
