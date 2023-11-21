package tw.frank.tutor;

public class L10 {

	public static void main(String[] args) {
		// 1120 102454
		// 統計擲骰子100次，記錄各點出現幾次 -> leetcode題目/實務

//		陣列玩index		
//		賭博=作弊=下參數 settimeout interval 前後頻率正確，跑的瞬間多跑幾格
//		甭1/6 -> 1/9 -> 4,5,6賠率變成2/9 博弈產業園區大樓 跑步機
//		生意不好再把賠率調回來
//		陣列好處對於多個變數index的管控處理
//
//		3個數字，可不可以構成三角形的三邊
//		不能出錯 不能備份/版本更新 飛機 太空梭
//		可能出錯 可以挽救 問題很大 金融 博弈

		
//		int p0, p1, p2, p3, p4, p5, p6; //宣告
//		p0 = p1 = p2 = p3 = p4 = p5 = p6 = 0; //初始化
		int [] p = new int[7]; //宣告並初始化!
		
		for (int i=1; i<=1000; i++) {
//		int point = (int)(Math.random()*6) + 1; //1~6
		int point = (int)(Math.random()*9) + 1; //調賠率1~9
		
//			switch (point) { 
//					case 1: p1++;break;
//					case 2: p2++;break;
//					case 3: p3++;break;
//					case 4: p4++;break;
//					case 5: p5++;break;
//					case 6: p6++;break;
//					default: p0++;
//			}
//			if(point<1 || point>6) {
			if(point<1 || point>9) { //調賠率1~9
				p[0]++;
			}else {
//				p[point]++;
				p[point > 6 ? point - 6 : point]++;
			}
		}
		
//		if (p0 == 0) {
		if (p[0] == 0) {
//		System.out.printf("1點出現%d次\n", p1);
//		System.out.printf("2點出現%d次\n", p2);
//		System.out.printf("3點出現%d次\n", p3);
//		System.out.printf("4點出現%d次\n", p4);
//		System.out.printf("5點出現%d次\n", p5);
//		System.out.printf("6點出現%d次\n", p6);
			for (int i = 1; i<= 6; i++) {
				System.out.printf("%d點出現%d次\n", i, p[i]);
			}
		}else {
			System.out.printf("ERROR" + p[0]);
		}
	}
}