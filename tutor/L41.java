package tw.frank.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//傳照片 FIS/FOS byte (2.579秒很慢)
public class L41 {
	//1128 100936
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileInputStream fis = new FileInputStream("dir1/La_Java_Cafe.jfif");
			FileOutputStream fos = new FileOutputStream("dir2/La_Java_Cafe.jfif");
			
			int b;//byte
			while ((b = fis.read()) != -1) {
				fos.write(b);
			}
			
			fos.flush();
			fos.close();
			fis.close();
			System.out.println("Finish:" + (System.currentTimeMillis() - start));
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
