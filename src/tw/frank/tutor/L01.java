package tw.frank.tutor;

import java.util.Scanner; //不是JAVA lang要import，不能用打的

public class L01 { //定義類別

	//程式執行進入點
	public static void main(String[] args) { //宣告 {內容}
//		Scanner scanner = null; //命令列做輸入 建構式 宣告 直接進行初始化
//		System.out.println(scanner);
		
//		Scanner scanner = new; //記憶體配置新的空間出來，再交給建構式去進行空間初始化
		Scanner scanner = new Scanner(System.in); //初始串流，回reboot stream，從鍵盤輸入一個整數進來，放在INT身上，印出來
		System.out.print("a = ");
		int a = scanner.nextInt();
		System.out.print("b = ");
		int b = scanner.nextInt();
		int r = a + b;
		System.out.printf("%d + %d = %d\n", a, b, r);
	
//		System.out.println(a); //印完換列
//		System.out.printf("%d + %d = %d", a, b, r); //整數 格式化format(index node索引)，照"%d + %d = %d"的順序
//		%d和%f分别用来表示输出时，替换整型输出和浮点型输出的占位符
//		強型別只能整數
		
//		//134433
		
		System.out.print("c = ");
		int c = scanner.nextInt();
		System.out.print("d= ");
		int d = scanner.nextInt();
		
		int r1 = c + d;
		int r2 = c - d;
		int r3 = c * d;
		int r4 = c / d;
		int r5 = c % d;
		System.out.printf("%d + %d = %d\n", c, d, r1); 
		System.out.printf("%d - %d = %d\n", c, d, r2); 
		System.out.printf("%d * %d = %d\n", c, d, r3); 
		System.out.printf("%d / %d = %d ... %d\n", c, d, r4, r5); 
	}	
}
