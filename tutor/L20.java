package tw.frank.tutor;

public class L20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Brad201 obj1 = new Brad201(); //建構出201的物件實體，但沒有定義建構式! 千萬別以為是obj的
		Brad201 obj1 = new Brad201(2); //隨便給他一個int
		//所有類別，都有建構式! 沒寫在編譯的時候，編譯器會將爸爸類別的建構式拿來當唯一的建構式 (爸爸無傳參數建構式)
//*		System.out.println(obj1.toString());
		Brad202 obj2 = new Brad202();
//*		System.out.println(obj2.toString());
	}

}

class Brad201 {//類別
//	Brad201() {//有寫了，到此一遊
	Brad201(int a) {//定義一個要傳參數的建構式
		System.out.println("Brad201()");
	}
}
class Brad202 extends Brad201 {//找不到爸爸的無傳參數建構式，編譯器無法幫忙，不符合JAVA類別
		Brad202(){//再自創給他一個...但發現爸爸沒有初始化! 使用傳遞整數這招
		super(3);//父類別的物件實體，來去做第19行動做
//*		System.out.println("Brad202()");
	}
}

//物件存在，爸爸/obj源頭等都已完成初始化先，會強迫在第一道敘述句，將隱含的上代類別先完成初始化來達到目的
//建構只有成員繼承，其他沒有
//1. JAVA所有類別都有建構式，編譯器只會幫忙無傳參數
//2. 第一道敘述句，要努力將長輩初始化

//在定義類別時，可以使用建構式定義物件建立的初始流程。建構式是與類別名稱同名，無需宣告傳回型態的方法
//建構物件時，資料成員就會初始化，如果沒有指定初始值，會使用預設值初始化