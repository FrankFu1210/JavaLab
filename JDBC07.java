package tw.frank.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

//limit看分頁，帶入常數~
public class JDBC07 {

	public static void main(String[] args) {
//		System.out.println("Keyword: ");
		System.out.println("Page: ");
		Scanner scanner = new Scanner(System.in);
//		String key = scanner.next();
		int page = scanner.nextInt();
		System.out.println("-----");
		
		//一頁有幾筆資料變數rows per page，final不會動常數!
		final int rpp = 10;
//		int page = 3;//上面寫完int page這行拿掉~
		//少目前第幾頁變數!
		//int start = ?;
		int start = (page - 1) * rpp;
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try (Connection conn = DriverManager.getConnection(		
				"jdbc:mysql://127.0.0.1/cool",prop)){			
			
			//先查詢資料長度，如何知道139這數字?
			//SELECT查詢用Query，也有結果resultset
			Statement stmt = conn.createStatement();
			ResultSet rs0 = stmt.executeQuery("SELECT count(*) count FROM food");
			rs0.next();//沒寫這句會顯示Before start of result set拋出java.sql.SQLException例外!!!
			int count = rs0.getInt("count");
			//小技巧~count與rpp皆為沒帶小數點的INT，乘上1.0變成double運算!
			int pages = (int)Math.ceil(count * 1.0 / rpp);
			
				if (page <= 0 || page > pages) {
					throw new MyException("Page ERROR");
				}			
			
			//定義一頁有幾筆資料，玩一下句法，從誰開始取幾筆
//			String sql = "SELECT * FROM food";
//			String sql = "SELECT * FROM food ORDER BY id LIMIT 10, 10";//11~20
//			String sql = "SELECT * FROM food ORDER BY id LIMIT 20, 10";//21~30
			String sql = "SELECT * FROM food ORDER BY id LIMIT ?, ?";
//			Statement stmt = conn.createStatement();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, rpp);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s : %s\n", id, name);
			}
			
			//拋出去後conn.就沒做到了，非常適合上面try()自動關閉
//			conn.close();
			
		//捕捉上面例外
//		} catch(MyException e) {//但實測有了這句，超出數字範圍就不會顯示"Page ERROR"，會變成空白...
				
		//當有其他例外的拋出
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}

//上面main搞得太複雜，自行訂義一個例外，當父類別發揚光目的可被拋出
class MyException extends Exception{
	private String mesg;
	//建構式
	public MyException(String mesg) {this.mesg = mesg;}	
	@Override
	public String toString() {
		return mesg;
	}
}
//SQL語法數學運算(該系統使用時)才會用INT(型別數值型態，會有預設值)，不然直接用varchart就好!
//JAVA配合自己寫程式要用的就好，呈現不用特別運算，不用再努力INT變字串
//改成用字傳(欄位名稱)取代數字123，來帶*內東西，方便辨識

//資料庫(單一檔案)不等於資料庫伺服器
//chrome table定時匯出備份SQL

//before start of result set 是什么错误
//https://blog.csdn.net/sinat_35767703/article/details/67632918
//https://blog.csdn.net/hhy62011980/article/details/5525438
