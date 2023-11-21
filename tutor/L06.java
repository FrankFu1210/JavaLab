package tw.frank.tutor;

import java.util.Scanner;

public class L06 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		System.out.print("x =");
		int x = a.nextInt();
	switch (x) { // byte, short, int, char, String, Enum
		// 1. case有沒有到 2. 拿掉break敘述句，變成2階段執行 3. 多種case用列舉動作執行
		//153132
		case 1:
			System.out.println("A");
			break;
		case 10:
			System.out.println("B");
			break;
		case 100:
			System.out.println("C");
			break;
		default:
			System.out.println("NULL");
			
		//月份
			
	}
	}

}
