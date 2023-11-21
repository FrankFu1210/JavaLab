package tw.frank.tutor;

import tw.frank.classes.Scooter;

public class L16 {

	public static void main(String[] args) {
		// 玩字串方法
		byte[] b1 = {97, 98, 99, 100};
		byte[] b2 = {65, 66, 67, 68};
		String s1 = new String("我是空值");
		String s2 = new String(b1);
		String s3 = new String(b2);
		String s4 = new String(b1, 1, 2);
		Scooter s5 = new Scooter();
		// 從觀念去作延伸
		System.out.println(b1); //byte陣列[]在這記憶體的位置
		System.out.println(b2); //byte陣列[]在這記憶體的位置
		System.out.println(s1); // 字串肚子裡的內容()
		System.out.println(s2); // abcd 97, 98, 99, 100 字元oskey code小寫
		System.out.println(s3); // ABCD 65, 66, 67, 68 字元oskey code大寫
		System.out.println(s4); // byte陣列b c
		System.out.println(s5); //印出摩托車記憶體的位置，這個類別所做出來的物件實體，在這個記憶體的位置
								//參照Scooter: return color + ":" + gear + ":" + speed;
	}

}
