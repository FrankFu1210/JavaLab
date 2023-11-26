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