package tw.frank.classes;

public class TWId {
//	搭配static
//	身分證物件，建構式的設計，取得哪些屬性，字串不能任意修改
	private String id;//has a id物件屬性
	private static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";//區域變數變成物件擁有letter屬性，需要物件才能呼叫，配合下面應用加static，區域變數變成static屬性
	
	//建構式物件實體，id完成初始化，id內容合理非隨便字串
//	public TWId () {//物件被建構，但id還沒初始化
//		id = "A123456789";//id被初始化，且正確
//	}
//	public TWId (String id) {//讓使用者傳送進來
//		this.id = id;//可被初始化，但不確定是否正確
//	}
	
	//參數不同，形成overload
	public TWId () {
		this((int)(Math.random()*2) == 0);//隨機產生0~1,是否為0，隨機產生T/F，交給下面處理
	}
	public TWId (boolean isMale) {
		this(isMale, (int)(Math.random()*26));//沒指定的擺英文亂數，交給下面處理
	}
	public TWId (int area) {
		this((int)(Math.random()*2) == 0, area);//同上
	}
	public TWId (boolean isMale, int area) {//多方面彈性，以及存取維護性特性
		String c1 = letters.substring(area, area+1); //產生字串物件
//		String c2 = isMale ? "1" : "2";
		StringBuilder sb = new StringBuilder(c1);
		sb.append(isMale ? "1" : "2");
//			.append("Brad")
//			.append("iSpan"); //return該方法傳回StringBuilder物件自己本身，最後再;
		for (int i=0; i<7; i++) {
			sb.append((int)(Math.random()*10));//省這段記憶體
		}
		
		for (int i=0; i<10; i++) {
			if (isRightID(sb.toString()+i)) {//toString有override，不再是記憶體內容!
				id = sb.toString() + i;
			break;
			}
		}
	}
	
	//用這招透過static方法建構來達成private
	private TWId (String id) {//留著以後使用
	this.id = id;
}
	public static TWId createTWId(String id) {//對外營業，自己接受，控制營業權
		if (isRightID(id)) {
			return new TWId(id);
		}else {
			return null; //拿不到物件(以後會有拋出例外)
		}
	}
	
	
	public String getId() {return id;} //因為把ID設為private，呼叫來查看
	
	public static boolean isRightID(String id) {//分類的觀念，不用物件也能呼叫，static讓物件彈性更大! 讓人方便查找
		// id 區域變數
		//設計方法條件
		// 1.長度 = 10
		// 2. 1碼 A-Z
		// 3. 2碼 1or2
		// 4. 3~10碼 0~9數字
//		String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO"; //移到上面去，從區域變數變成static屬性
		boolean isRight = false; //boolean區域變數
//		if (id.length() == 10) {
//			if (letters.indexOf(id.charAt(0)) >=0) {
//				if (id.charAt(1) == '1' || id.charAt(2) == '2') {
//					
//				}
//			}
//		}
		
		//正規表示法 密碼, Email, log壞人IP
		if (id.matches("^[A-Z][12][0-9]{8}$")) {//前面字元出現8次，JAVA不用加^$頭尾，因為只有一個字串，不用讀文字檔
//			isRight = true;
			int a12 = letters.indexOf(id.charAt(0)) + 10;
			int a1 = a12 / 10;
			int a2 = a12 % 10;
			
			String s1 = id.substring(1,2);
			int n1 = Integer.parseInt(s1); //把[12]字串轉換成為int
//			int n1 = Integer.parseInt(id.substring(1, 2)); ?
			int n2 = Integer.parseInt(id.substring(2, 3));
			int n3 = Integer.parseInt(id.substring(3, 4));
			int n4 = Integer.parseInt(id.substring(4, 5));
			int n5 = Integer.parseInt(id.substring(5, 6));
			int n6 = Integer.parseInt(id.substring(6, 7));
			int n7 = Integer.parseInt(id.substring(7, 8));
			int n8 = Integer.parseInt(id.substring(8, 9));
			int n9 = Integer.parseInt(id.substring(9, 10));
			
			int sum = a1*1 + a2*9 + n1*8 + n2*7 + n3*6 + n4*5 + n5*4 + n6*3 + n7*2 + n8*1 + n9*1;
			isRight = sum % 10 == 0;
		}
		
		return isRight;
//		return true;
//		TWId.isRightID(id)
	}

}
