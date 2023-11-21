package tw.frank.tutor;

public class L09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1120 101253
		// 統計擲骰子100次，記錄各點出現幾次 -> leetcode題目/實務
		// 什麼時候用到陣列? 這題先使用變數
		// 迴圈就是跑次數而已，先把邏輯建立出來

//		1120上完課後回家寫錯的版本...
//		int [] = p0, p1, p2, p3, p4, p5, p6;
//		int [] = new int[0] = p0= p1= p2= p3= p4= p5= p6;
//		for (i=1, i <= 100, i++) {
//		int i = (int)(Math,random*100)
//		}
		
		int p0, p1, p2, p3, p4, p5, p6; //宣告
		p0 = p1 = p2 = p3 = p4 = p5 = p6 = 0; //初始化
		
		for (int i=1; i<=1000; i++) { //樣本數不夠多!
		int point = (int)(Math.random()*6) + 1; //1~6
		switch (point) { 
				case 1: p1++;break;
				case 2: p2++;break;
				case 3: p3++;break;
				case 4: p4++;break;
				case 5: p5++;break;
				case 6: p6++;break;
				default: p0++;
		}}
		
		if (p0 == 0) {
		System.out.printf("1點出現%d次\n", p1);
		System.out.printf("2點出現%d次\n", p2);
		System.out.printf("3點出現%d次\n", p3);
		System.out.printf("4點出現%d次\n", p4);
		System.out.printf("5點出現%d次\n", p5);
		System.out.printf("6點出現%d次\n", p6);
		}else {
			System.out.printf("ERROR" + p0);
		}
	}
}