package tw.frank.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import org.json.JSONStringer;
import org.json.JSONWriter;

import tw.frank.classes.BCrypt;
import tw.frank.classes.Member;

//檢查帳號密碼進階版本，加上變更密碼，並產生JSON -> String變成會員物件化! 結合class Member
public class JDBC09_1 {
	private static Connection conn;
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/cool";
	private static final String SQL_LOGIN = "SELECT * FROM member WHERE account = ?";
	private static final String SQL_CHPASSWD = "UPDATE member SET password = ? WHERE id = ?";

	public static void main(String[] args) {		
		//User Input
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
			conn = DriverManager.getConnection(URL, prop);
			
			//check account
//			String name;
			Member member;

//			if ((name = login(account, passwd)) != null) {
			if ((member = login(account, passwd)) != null) {
//				System.out.println("Welcome, " + name);//*把字串改成物件寫法*
				System.out.println("Welcome, " + member.getName());//*把字串改成物件方法*
				
				//*產生 Member JSON*，這段居然沒寫到@@
				JSONStringer js = new JSONStringer();
				JSONWriter jw = js.object();
				js.key("id").value(member.getId());
				js.key("account").value(member.getAccount());
				js.endObject();
				System.out.println(jw.toString());//例如{"id":2,"account":"Xi"}
				
				System.out.println("New Password : ");
				String newpasswd = scanner.next();
//				if (chPasswd(newpasswd)) {//The method chPasswd(Member, String) in the type JDBC09_1 is not applicable for the arguments (String)
				if (chPasswd(member, newpasswd)) {
					System.out.println("New Password changed");
				}else {
					System.out.println("Password change ERROR");
				}
			}else {
				System.out.println("Login Failure");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//將String變成會員物件化! 結合Member class 1204 145114
//	static String login(String account, String passwd) {
	static Member login(String account, String passwd) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();			
			
			if (rs.next()) {
				String hashPasswd = rs.getString("password");
				if (BCrypt.checkpw(passwd, hashPasswd)) {
					//OK					
//					Member member = new Member(0, account, hashPasswd)
					Member member = new Member(rs.getInt("id"), rs.getString("account"), rs.getString("name"));
//					return rs.getString("name");
					return member;
				}else {
					//ERR		
					return null;
				}
			}else {
				//ERROR
				return null;
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
//		return false;
		return null;
	}
	
	static boolean chPasswd(Member member, String newpasswd) {
//		String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL_CHPASSWD);
//			pstmt.setString(1, account);//account cannot be resolved to a variable
			pstmt.setString(1, BCrypt.hashpw(newpasswd, BCrypt.gensalt()));
			pstmt.setInt(2, member.getId());
			
//			ResultSet rs = pstmt.executeQuery();
			int num = pstmt.executeUpdate();
			if (num == 1) {
				return true;
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
// void 加例外拋出

//資料物件化! -> 將String變成會員物件化! 結合Member class
//好方法是撰寫會員類別 物件實體，讓外面拿到會員物件實體去運用，就不用再寫~

//用ID改密碼 change passwd
//書: 通用，不要版本
//不一定尋訪過程，產生一個物件(這邊沒有陣列) 會員登入順便把JSON格式印出來 (不過另外寫方法會比較好)

//笔记|关于Java出现“* cannot be resolved to a variable”错误
//https://blog.csdn.net/weixin_45846185/article/details/105480711
