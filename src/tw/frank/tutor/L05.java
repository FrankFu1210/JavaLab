package tw.frank.tutor;

import java.util.Scanner;

public class L05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//判斷輸入西元年份是否為閏年，400整除閏，100整除不閏
		//1117 150644
		Scanner a = new Scanner(System.in);
		System.out.print("x =");
		int x = a.nextInt();
// 沒有把4,100,400包在範圍裡面...會到第2個判斷迴圈if (x % 100 != 0)就變成了閏年
//		if (x % 4 == 0) {
//			System.out.printf("閏年");
//		} else if (x % 100 != 0) {
//			System.out.printf("閏年");
//		} else if (x % 400 == 0) {
//			System.out.printf("閏年");
//		} else {
//			System.out.printf("平年");
//		}
//	}
//}
		
//		Brad
		if (x % 4 == 0) {
			if (x % 100 == 0) {
				if (x % 400 == 0) {
					System.out.println("閏年");
				}}}else if (x % 4 == 0) {
						if (x % 100 == 0) {
							System.out.println("平年");
				}}else if (x % 4 == 0) {
					System.out.println("閏年");
				}else {
					System.out.println("平年");
				}
		
//		other 1117 151424
		System.out.print("y =");
		int y = a.nextInt();
		if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
			System.out.printf("閏年");}
		else {System.out.printf("平年");}
			}
		}
