package tw.frank.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
//傳照片 FIS/FOS 設定byte buf*4K (0.002秒很快)
public class L42 {
	//1128 100936
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileInputStream fis = new FileInputStream("dir1/La_Java_Cafe.jfif");
			FileOutputStream fos = new FileOutputStream("dir3/La_Java_Cafe.jfif");
			
			int leng; byte[] buf = new byte[4*1024];//設定byte buf*4K
			while ((leng = fis.read(buf)) != -1) {
				fos.write(buf, 0, leng);
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
