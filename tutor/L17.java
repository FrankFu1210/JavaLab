package tw.frank.tutor;

public class L17 {
	//字串在記憶體中不同位置比較
	public static void main(String[] args) {
		String s1 = "Brad"; //看到雙引號馬上在記憶體中作出空間物件實體String pool，字串跟雙引號都是物件，所以句法上面沒有new
		System.out.println("Brad".charAt(0)); //a 雙引號點字串方法
		String s2 = "Brad"; //雙引號裡面一樣，String pool不會重新new
		String s3 = new String("Brad");//new記憶體配置空間，才來到字串的建構式，拿這個字串到新位置初始化
		String s4 = new String("Brad");//又一個新的
		
		//比物件實體是否相等，比肚子裡面裝什麼 值/址?
		System.out.println(s1 == s2); 
		System.out.println(s1 == s3);
		System.out.println(s3 == s4);
		System.out.println("---");
		
		//比字串內容
		System.out.println(s1.equals(s2)); 
		System.out.println(s1.equals(s3));
		System.out.println(s3.equals(s4));
	}

}
