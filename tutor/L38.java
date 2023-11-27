package tw.frank.tutor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//FileOutputStream write/flush/close 移除舊檔案，覆蓋新內容
public class L38 {
	//1127 160005
	public static void main(String[] args) {
		try {
			String msgn = "Hi, Leo \n爸爸想給你全世界";
			FileOutputStream fout = new FileOutputStream("dir1/file1.txt", true);//(String name, boolean append)
			fout.write(msgn.getBytes());//把字串內容轉成byte陣列 (亂碼因為顯示的關係，一個一個寫沒問題)			
			fout.flush();
			fout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
//基本串流&文字串流，差別在於文字編碼
//ISO8859-1預設編碼 --> UTF8
//HW: read 一次讀一個 中英文字