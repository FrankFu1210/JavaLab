package tw.frank.tutor;

public class L08 {

	public static void main(String[] args) {
//		JAVA是物件 陣列 強型別固定 字串長度內容固定 宣告
//		(在迴圈中遇到字串會採用StringBuilder或StringBuffer來代替固定長度的string，避免浪費內存)
//		https://blog.csdn.net/Mr_Smile2014/article/details/48275005
//		https://www.freecodecamp.org/chinese/news/java-string-stringbuffer-and-stringbuilder/

		//認識記憶體空間，宣告初始化
		int[] a; //只有宣告，尚未初始化
		int[] b = new int[3]; //宣告同時，進行初始化，因為是物件，new，創造出記憶體空間，後面再對這個空間進行初始化 (3 = 2^32)，從此之後就有值，語法範圍到[+int]正29億，但run time邏輯不對
		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);
		
	}
}
