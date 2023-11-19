package tw.frank.tutor;

public class L02 { //定義類別

	//程式執行進入點
	public static void main(String[] args) { //宣告 {內容}
		// TODO Auto-generated method stub
		
		//單行註解

		/* 區塊註解
		*
		*/

		/** 不是註解，產生JAVA DOC API文件
		*
		*/
	
		// 整數 byte, short, int, long (包含正/負 一人一半，但控制硬體無正負號麻煩需要轉換)
		// byte 2^8 -> 256 -> -128~127
		byte var1; //宣告byte 1.[a-zA-Z$_]正規表示法 2.[a-zA-Z0-9$_]* 第2個字多了0-9
		byte $$$, $_$ = 123, 變數 = -12; //一次宣告多個
		System.out.println($_$); //盡量不要用$_
		
		System.out.println(變數);
		//System.out.println(var1); //var1區域變數(定義在方法中)可能沒有被初始化 只有宣告，但沒有給值 只要曾經給值，就已經完成初始化 宣告後給NULL也算完成初始化
		
		
		
		// short 2^16 -> 65536 -> -32768~32767
		
		// int 2^32 -> 42億9千多萬 10位數 (MySQL int 11位 獨立+-號) -> 4G (早期隨身碟限制,INT範圍)
		
		// long 2^64
		
		byte var2 = 1, var3 = 2;
		int var4 = var2 + var3; //編譯先檢查語法，看到運算，先找一個INT記憶體空間放，再指派給byte他，所以放不進去
		// 強制轉型，大杯變小杯，喪失精確度
		
		byte a = 127;
//		a++; //透過位元移動方式處理，並非執行+-*/運算範圍 -128
		a+= 3; //+=是指派運算，也不是運算範圍 -128, -127, -126
		System.out.println(a);
	}

}
