package tw.frank.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//FileInputStream (byte)(有File檔案才能玩) read/close 祖父lang.Exception -> 使用try catch，適合非文字資料
public class L37 {
	//1127 144034
	public static void main(String[] args) {
		try {
//			FileInputStream fin = new FileInputStream("dir3/file2.txt");
//			int b = fin.read();
//			System.out.println((char)b); //印出第一個位置c，字元強制轉型(char)c
			
			File file = new File("dir3/file2.txt");//改成把整個file放進來，運用file，new File 我擁有File物件了!!!
			FileInputStream fin = new FileInputStream(file);
			
//先進行指派，()括起來再進行比對，用while就好，不用到do while
//一個read移動指標一次!
//			int b; byte[] buf = new byte[3];//UTF8 3byte
//			while ((c = fin.read(buf)) != -1) {//=指派放入
//				System.out.print((char)b);	//單一字元 a 97 archi code			
//				System.out.print(new String(buf));				
//				System.out.print(new String(buf, 0, b));//從0開始計算到c=3，不過遇到資a策會就無法辨識				
			
			int b; byte[] buf = new byte[(int)file.length()];//return回來是long，但陣列只能放INT
			fin.read(buf);
			System.out.print(new String(buf));					
			
			fin.close();// Input完水龍頭關起來
//		} catch (FileNotFoundException e) {
//			System.out.println("OK"); //除錯點先OK檢查沒意外
			
//		} catch (IOException e) {
		} catch (Exception e) {//使用try catch -> 祖父lang.Exception  
			System.out.println(e.toString());
		}
	}
}

//回家3種案例都寫，純文字檔用read,write去處理