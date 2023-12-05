package tw.frank.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//再寫一個類別，專門處理資料庫!
public class FoodDB {
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/cool";
	private static final String SQL_QUERY = "SELECT * FROM food";
	
	//還沒建構，只有屬性等下運用
	private Connection conn;
	private ResultSet rs;
	//欄位名稱宣告就好了，去下面建構，順便for迴圈變成陣列!
	
	//建構式，跳回MyTable
	//連線不成功，宣告拋出例外
	public FoodDB()	{
		
	}
	
	//物件方法對外營業，查詢讓rs有東西，不拋出不傳回
	public void queryDB() {
		queryDB(SQL_QUERY);//丟回去給第一招
	}
	
	//怎麼去查詢
	//招式2 JTable傳遞呼叫外部去查
	public void queryDB(String sql) {
		Statement stmt = conn.createStatement()
	}
	
	//回答裡面有幾筆資料
	public int getRows() {
		try {
			rs.last();
		}catch(Ex)
		return 1;
	}
	
	//原本拿column count，順便把column做成字串陣列 (或直接把他變成物件實體)
	//column包含欄位 & 資料
	public int getCols() {
		
		return 1;
	}
	
	//取資料
	public String getData() {
		//陣列要col-1
	}
	//只有說要砍 資料表沒有移動
	//提供外部方法讓他去砍
}

