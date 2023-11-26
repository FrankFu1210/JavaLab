package tw.frank.tutor;

import java.util.LinkedList;
import java.util.TreeSet;
//*威力彩開獎! TreeSet有實作SortedSet的介面*
public class L31 {

	public static void main(String[] args) {
		TreeSet<Integer> lottery1 = new TreeSet<>();
		while (lottery1.size() < 6) {
			lottery1.add((int)(Math.random()*38)+1);
		}
		System.out.printf("1: %s\n2: %d\n", lottery1, (int)(Math.random()*8)+1);
		System.out.println("---");
		for (Integer num : lottery1) {
			System.out.println(num);
		}
	}
}

//大樂透 威力彩 資料庫 -> 找出關聯性 預測
//L31 set 實作威力彩開獎 
//泛型裡面都是整數，幫助開發者不亂丟東西
//%s to string
//印物件 透過記憶體位置呈現 變成字串
