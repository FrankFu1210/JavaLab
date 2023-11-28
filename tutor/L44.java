package tw.frank.tutor;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import tw.frank.classes.Student;

//搭配Student 物件序列化-把物件送出去 OOS/BOS/FOS wO
//*implements Serializable*宣告可序列化很重要!
public class L44 {

	public static void main(String[] args) {
		Student s1 = new Student(99, 88, 77);
		Student s2 = new Student(57, 57, 57);
			System.out.println(s1.sum());
			System.out.println(s1.avg());
			System.out.println(s2.sum());
			System.out.println(s2.avg());
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("dir1/s1.brad")));
		
		oos.writeObject(s1);
		oos.writeObject(s2);
		oos.flush();
		oos.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}				
	}
}
//物件序列化(一次一個)! 把物件存出去，再將整包物件還原回來
//並列(一次多個)

//implements Serializable必須要"宣告"可序列化的介面就好了!(給JVM辨別使用)
