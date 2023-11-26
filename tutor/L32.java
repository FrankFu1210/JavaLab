package tw.frank.tutor;

import java.util.LinkedList;
//LinkedList<String>名字順序排列
public class L32 {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		//用0導致後面一直往上排列到第一個
		list.add(0, "Brad");	// 0
		list.add(0, "Amy");	// 1
		list.add(0, "Peter");	// 1
		list.add(0, "Tony");
		System.out.println(list.size());
		System.out.println(list);
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("---");
		for (String name : list) {
			System.out.println(name);
		}
	}
}

//資料結構: 
//ArrayList元素個數不太會異動，使用陣列效能較好
//LinkedList串接，先進先出first/last/push/pop