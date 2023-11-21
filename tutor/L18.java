package tw.frank.tutor;

public class L18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		JAVA基本型態共8個:
//		整數4 byte, short, int, long  
//		浮點數2 float, double
//		布林7 boolean
//		字元8 Char 2^16 0~65535字元特性，骨子數值，單引號一個字元
		
// 文字檔，含換列符號: 一般指只有字元原生編碼構成的二進位電腦檔案，與富文字相比，其不包含字樣樣式的控制元素，能夠被最簡單的文字編輯器直接讀取
// 非文字檔: 其他2進制
		
		char c1 = 'a';		
		int a = c1 + 1;
		System.out.println(c1);//a
		System.out.println(a);//97+1 (因為// abcd 97, 98, 99, 100)
		
		char c2 = '樂';
		int b = c2 + 1;
		System.out.println(c2);//a
		System.out.println(b);//97+1 (因為// abcd 97, 98, 99, 100)
		

	}

}
