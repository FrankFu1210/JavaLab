package tw.frank.tutor;

import tw.frank.classes.TWId;

public class L19 {

	public static void main(String[] args) { //static不要new! 沒有對外營業XD
		TWId myId = TWId.createTWId("R123457315");
		TWId id1 = new TWId();
		TWId id2 = new TWId(false);
		TWId id3 = new TWId(7);
		TWId id4 = new TWId(true, 25);
		
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
		
//		if (TWId.isRightID("R123457315")) {// 傳回布林值用if判斷
//			System.out.println("OK");
//		} else {
//			System.out.println("XX");
//		}
	}
}
