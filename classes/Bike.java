package tw.frank.classes;

//設計觀念
//public公開宣告 class類別 Bike物件
public class Bike { //沒寫的話，爸爸為extends Object天公單一繼承

	//double浮點數型態 speed屬性
//	public double speed; //*寫上在意的屬性，腳踏車設計大公開*	
	public double speed = 5; //*設定速度=5*
//	private double speed; //改為private，範圍僅限本類別!!
//	speed = 5; //speed重複，屬性值直接寫在型態屬性上
	
	//void空類型，不用回傳值，保持對class類別的引用 upSpeed()方法
//	public void upSpeed() { //*upSpeed原本()沒寫給Bike*
	public void upSpeed(int args) {//*upSpeed因為繼承給Scooter，為了設定參數方法因此給()中加入參數*
		speed = speed < 5 ? 5 : speed * 1.4;
	}
	
	public void downSpeed() {
		speed = speed < 18 ? 18 : speed * 0.5;
	}
	
//	公開值，不是變數，屬性不太會對外公開，透過方法來取得到
	public double getSpeed() { // double為傳回值行為
		return speed;
	}
}

//類別: Public 全世界 / protected 子類別 / 沒寫 相同package / private本類別
