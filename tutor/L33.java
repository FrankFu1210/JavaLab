package tw.frank.tutor;

import java.util.HashMap;
//HashMap<K,V> 印出姓名身高體重年紀
public class L33 {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "Brad");
		map.put("gender", false);
		map.put("age", 18);
		map.put("weight", 79.6);
		
		System.out.println(map.get("name"));
		

	}

}