package tw.frank.tutor;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.frank.classes.Student;

//搭配Student 物件序列化-把物件接收回來 OIS/BIS/FIS 打回原型
//*implements Serializable*宣告可序列化很重要!
public class L45 {

	public static void main(String[] args) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("dir1/s1.brad")));
			
			Object object = ois.readObject();
			if (object instanceof Student) {
//				System.out.println("OK");
				Student s1 = (Student)object;//打回原型
				System.out.println(s1.sum());
				System.out.println(s1.avg());
				System.out.println("-----");
			}
			
			Object object2 = ois.readObject();
			if (object2 instanceof Student) {
//				System.out.println("OK");
				Student s2 = (Student)object2;//打回原型
				System.out.println(s2.sum());
				System.out.println(s2.avg());
				System.out.println("-----");
			}
			
			ois.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
//L44與L45檔案相依
//Student s1 = (Student)obj; 打回原型
//循序存放多個物件，先進先出呼叫出來
