package tw.frank.tutor;

import tw.frank.classes.Bike;

public class L14 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		System.out.println(b1.getSpeed());
		//*當Bike.java中第10欄upSpeed(int args)有設定參數，L14 b1.upSpeed()就無法使用*
		//*調回第9欄upSpeed()不設定參數，就可以沿用*
		b1.upSpeed(); //速度設定5
		System.out.println(b1.getSpeed());
		b1.upSpeed(); //踩踩踩 (執行動作即可) 5*1.4=7
		System.out.println(b1.getSpeed());
		b1.upSpeed(); //踩踩踩 (執行動作即可) 7*1.4=9.8
		System.out.println(b1.getSpeed());
//		b1.speed = 10.1; 此直接修改參數/值的bug已經無法使用，避免屬性失控!
//		System.out.println(b1.getSpeed());
		
		Bike b2 = new Bike();
		System.out.println(b2.getSpeed());
		b2.downSpeed(); //速度設定18
		System.out.println(b2.getSpeed());
		b2.downSpeed(); //踩踩踩 (執行動作即可) 18*0.5=9
		System.out.println(b2.getSpeed());
		b2.downSpeed(); // 9*0.5=4.5?
		System.out.println(b2.getSpeed());

	}

}
