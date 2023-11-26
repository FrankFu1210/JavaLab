package tw.frank.tutor;

import java.util.HashSet;
import java.util.Iterator;

import tw.frank.classes.Bike;
//auto-boxing自動封箱;迭代器iterator
public class L30 {

	public static void main(String[] args) {
		// auto-boxing自動封箱 把123基本型別變成物件，自動將數值變物件(記憶體變大...)
		// 等下拿出來要強制轉型回來
		// override to string
		
		//叫出迭代器，return回已經完成實作該介面的物件實體
		// obj to string(印出肚子裡的東西)
		HashSet set = new HashSet();
		set.add("Brad");
		set.add(new Bike());
		set.add(123);	// auto-boxing <> auto-unboxing
		set.add(true);
		set.add(12.3);
		System.out.println(set.size());
		set.add(123);
		set.add("Brad");
		System.out.println(set.size());
		System.out.println(set);
		System.out.println("----");
		
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
	}
}
//Iterable<E>迭代
//可存放資料結構的定義，全部物件，不能放基本型別
//但有另一個機制，可以將基本型別變成物件

//介面java.util -> collection -> set 跟 list
//set: 元素不重複，無順序性，實作可迭代->for each ( : 尋訪的對象)
//list:可重複，有順序性index，實作可迭代->for each( : 尋訪的對象)
//PHP陣列好用