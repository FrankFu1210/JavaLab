package tw.frank.tutor;

public class L07 {

	public static void main(String[] args) {
		// loop 154536
		// for ( ; ; )執行流程一定會做，不會不做，第一道敘述句執行一次初始化(一定會做)，中間視為true(決定要不要做)，第三道程式區塊做完，一定會做的事(最後再做)
		for (int a = 0 ; a < 3 ; a++) {
			System.out.println(a);} // 0,1,2
			
		int b = 0;
		for (printBrad() ; b < 3 ; ) {
			System.out.println(b++);} // 0,1,2
		
		int c = 0;
		for (c = 1 ; c < 5 ; printline()) {
			System.out.println(c++);} // 0,1,2
		
//		int d = 0;
//		for ( ;  ; ) {
//			System.out.println(d++);} // 就變成黑客無限迴圈request攻擊!
		
	}
	
	static void printBrad() { //與物件無關，所以寫static
		System.out.println("Brad");
	}
	static void printline() { //與物件無關，所以寫static
		System.out.println("-----");
	}
}

// 回家作業: 迴圈寫九九乘法表 + JS寫 + 同一段程式改變數 行列 起始數字 2 row 4 column 3 row 3 column
