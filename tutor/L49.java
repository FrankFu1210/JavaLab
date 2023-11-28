package tw.frank.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//序列化OOS/FOS wO & 解序列化OIS/FIS rO 考古題其中一題! 超漂亮核心物件導向觀念!
public class L49 {
	//1128 140150
	public static void main(String[] args) {
		//產生493物件實體，祖宗8八代完成初始化
		L493 obj= new L493(); //印出L491() L492() L493()祖宗8代初始化叫出來打群架

		//物件序列化 出去，把493存出去(*要宣告可序列化*)
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dir1/tt"));
			oos.writeObject(obj);
			oos.flush();
			oos.close();
			System.out.println("write OK");
		} catch (Exception e) {
			System.out.println(e);			
		}
		System.out.println("-----");	
		
		//解序列化 回來
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dir1/tt"));
			L493 tt = (L493)(ois.readObject());
			ois.close();
			System.out.println("read OK");
		} catch (Exception e) {
			System.out.println(e);			
		}
		
	}

}
//三代純物件建構式，將祖宗8代屬性完成初始化，但方法沒有
class L491 {
//class L491 implements Serializable{
	L491() {System.out.println("L491()");}
}
class L492 extends L491 {
//class L492 extends L491 implements Serializable{
	L492() {System.out.println("L492()");}
}
//class L493 extends L492 {
class L493 extends L492 implements Serializable{
	L493() {System.out.println("L493()");}
}
//當建構式寫出去，讀回來會發生什麼事情?
//可序列化在做什麼事? (物件最重要的是屬性(屬性不同)，把屬性序列化了，但方法沒有序列化)

//因為解序列化回來還是原本物件，但是爸爸/阿公沒有宣告序列化，所以被再抓去做初始化的動作變成L491() L492()
//(之後API要多看可不可以序列化處理)