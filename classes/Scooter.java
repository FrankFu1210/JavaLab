package tw.frank.classes;

public class Scooter extends Bike { //宣告，速克達發揚光大腳踏車override，介於父子類別間
	private int gear; //屬性增加 int基本型別已經自動初始化0
	
// 字串本身是物件! 包含字串內容，有屬性方法，佔記憶體空間，不能改變內容
// 字串內容不要動，語法沒有錯，但浪費記憶體空間!
	
    // 下列4種物件型別+屬性
	//1.	
	private String color; //String物件型別中的color屬性沒有自動初始化，所以沒辦法存取
	
	//2. 物件型別透過Constructor建構式(){}將其屬性初始化
	public Scooter() {//沒有傳回值型別，()沒有傳參數，預設
		color = "gold";
	}
	
	//3.
	public Scooter(String color) {
		this.color = color;
	}
	
	//4.
	public String getColor() {//建構式改完顏色後不能改
		return color;
	}
	
	//Override覆寫: 與爸爸方法名稱，傳遞參數一樣
	//改寫父類別原有的方法內容，當覆寫父類別的方法，則方法的名稱，回傳值的資料型態，參數型態及數量都必須相同
	public void upSpeed() {
		speed = speed < 1 ? 1 : speed * (1 + 1 * gear);
	}
	
	//Overload覆載: 方法名稱一樣，傳遞參數個數型別不一樣
	//在一個類別(class)中，定義多個名稱相同，但參數(Parameter)不同的方法(Method)
	public void upSpeed(int args) { //argument
		if(args > 0 && args < 1) {//參數<0，且<1
			speed = speed < 1 ? 1: speed * (2+args) *gear;
		}
	}
	
	//參數傳遞，changeGear有成功，才會開啟布林值，其他方法改變屬性
	public boolean changeGear(int gear) {//設計一個方法改變檔位
		if (gear >= 0 && gear <= 4) {//宣告第19欄gear檔位，以最接近優先
			this.gear = gear;//this.gear本物件(第4欄gear檔位) = 等於gear值(第19欄int gear)
			return true;
		}else {
			return false;
		}
	}
	
	@Override 
		public String toString() {
			// TODO Auto-generated method stub
//			return super.toString();
		return color + ":" + gear + ":" + speed; // 改寫toString方法，印出字串內容
		//String改寫了toString，除了繼承的沒有改
		}
	
}
