package tw.frank.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONStringer;
import org.json.JSONWriter;

//北風業務業績排行榜 (採用JOIN SQL語法) 揪3表+輸出JSON格式!
public class JDBC10 {
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/northwind";

	public static void main(String[] args) {//從中間人orders開始
		//只要SQL一句話講完，JAVA什麼都不用做!
		//這麼長一串SQL注意大小寫...(Firstname)寫錯了
		String sql = " SELECT e.LastName, e.FirstName, sum(od.UnitPrice * od.Quantity) as sum " + 
					"FROM orders o " + 
					"JOIN employees e ON (e.EmployeeID = o.EmployeeID) " +
					"JOIN orderdetails od ON (od.OrderID = o.OrderID) " +
					"GROUP BY e.LastName, e.FirstName " +
					"ORDER BY sum DESC";
		
		//login
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		
		
		
		// *運用API轉出JSON，做輸出的動作!*
		JSONStringer js = new JSONStringer();
		JSONWriter jw = js.array(); //做頭頭陣列[	
		
		//單的量不用join order details
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			Statement stmt = conn.createStatement();// stmt = 產生敘述句 
			ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String last = rs.getString("LastName");
					String first = rs.getString("FirstName");
					String sum = rs.getString("sum");
				 System.out.printf("%s, %s, %s\n", last, first, sum);
				 
				//*JSON產生物件實體*
				 jw.object();//jw.object在array下創一個物件出來{ 
				 	jw.key("LastName").value(last);//key完寫value裝物件名稱，返回為原物件
				 	jw.key("FirstName").value(first);
				 	jw.key("sum").value(sum);
				 jw.endObject();//寫上結束}
				//*上面寫完形成一個物件*				 
				}
				jw.endArray();//陣列結束]
				System.out.println(jw.toString());
				
			} catch(Exception e) {
				System.out.println(e.toString());
			}			
		}
	}


//加密貨幣的API也用JSON格式回傳，每分鐘120次存取
//幣安 web socket等他主動餵過來

//明天玩Jtable由視窗控資料 雙方都改!

