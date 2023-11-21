package tw.frank.tutor;

import tw.frank.classes.Bike;
import tw.frank.classes.Scooter; //列出2個import，upSpeede跟誰

public class L15 {

	public static void main(String[] args) {//字串陣列的參數
		Bike b1 = new Bike(); //生一台腳太車
		Scooter s1 = new Scooter(); //生一台摩托車
		
		//導向Bike
		b1.speed = 10; //speed屬性
		System.out.println(b1.getSpeed()); //10
		b1.upSpeed(6); //upSpeed()方法
		System.out.println(b1.getSpeed()); //10*1.4=14
		b1.upSpeed(7);
		System.out.println(b1.getSpeed()); //14*1.4=19.6
		System.out.println("-----");
		
		//導向Scooter
		s1.speed = 10;
		System.out.println(s1.getSpeed()); //10
		s1.changeGear(3);
		System.out.println(s1.getSpeed()); //10 changeGear給值無效
		s1.changeGear(2);
		System.out.println(s1.getSpeed()); //10 changeGear給值無效
		s1.upSpeed(6);
		System.out.println(s1.getSpeed()); //10 upSpeed於Scooter無效
		s1.upSpeed(7);
		System.out.println(s1.getSpeed()); //10 upSpeed於Scooter無效
		s1.upSpeed(); //踩踩踩 (執行動作即可)
		System.out.println(s1.getSpeed()); //10*3=30 upSpeed被導向Scooter的upSpeed()
	}
}
