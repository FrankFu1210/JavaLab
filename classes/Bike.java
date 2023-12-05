package tw.frank.classes;

import java.io.Serializable;

public class Bike extends Object implements Serializable { //沒寫的話，爸爸為extends Object天公單一繼承
//	設計觀念
	public double speed; //寫上在意的屬性，腳踏車設計大公開	
//	private double speed; //改為private，範圍僅限本類別!!
//	protected double speed; //改為保護級，富類別讓繼承的子類別拿去運用 (不在相同package也可以用)
	
	public void upSpeed() { //upSpeed原本()沒寫給Bike
//	public void upSpeed(int args) {//upSpeed因為繼承給Scooter，為了設定參數方法因此給()中加入參數
		speed = speed < 1 ? 1 : speed * 1.4;
	}
	
	public void downSpeed() {
		speed = speed < 1 ? 0 : speed * 0.5;
	}
	
//	公開值，不是變數，屬性不太會對外公開，透過方法來取得到
	public double getSpeed() { // double為傳回值行為
		return speed;
	}
}

//類別: Public 全世界 / protected 子類別 / 沒寫 相同package / private本類別
