package tw.frank.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
//傳照片 BIS接FIS BOS接FOS 接水管 設定byte (0.017秒很快)
//BufferedInput/OutputStream串接 (先一根一根接)適合讀系統log很大檔案
//但還是1 byte 1 byte讀取
public class L43 {
	//1128 100936
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("dir1/La_Java_Cafe.jfif"));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("dir3/La_Java_Cafe.jfif"));
						
			int b;//byte
			while ((b = bis.read()) != -1) {
				bos.write(b);
			}
			
			bos.flush();
			bos.close();
			bis.close();
			System.out.println("Finish:" + (System.currentTimeMillis() - start));
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
