package tw.frank.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

//L39 FileReader (char) 適合文字資料
public class L39 {
	//1127 144034
	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader("dir3/file2.txt");
			int c;
			while ((c = fr.read()) != -1) {
				System.out.print((char)c);			
			}
				
		} catch (Exception e) {
//			System.out.println(e.toString()); //excetion override to string (e.toString()不寫沒關係)
		}
	}
}
//		try {//下面自己寫的NG
//			InputStreamReader in = new InputStreamReader(null, "dir3/file2.txt");
//			int c = in.read();
//			System.out.print((char)c);	
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}		
		
//		FileInputStream (byte)
//		FileReader (char)
//		R/W讀文字檔，組態設定