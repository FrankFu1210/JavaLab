package tw.frank.tutor;

import java.io.File;
//File 會將檔案不同路徑剪下貼上並且改檔名
public class L36 {
	//1127 135908
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);// 分隔環境變數;
		System.out.println(File.separator);// 多根路徑分隔號\ (跳脫字元要畫2根)
		
		File f1 = new File("./dir3");
		if (!f1.exists()) {//物件存在，檔案不一定要在 -> 可以呼叫物件創出檔案
			f1.mkdir();
		}else {
			System.out.println("exist");
		}
		System.out.println("---");
		//會將檔案不同路徑剪下貼上並且改檔名
//		File f2 = new File("dir1/file1.txt");// ./可以省略
//		File f3 = new File("dir2/file1.txt");
		File f2 = new File("dir2/file1.txt");// ./可以省略
		File f3 = new File("dir3/file2.txt");
		if (f2.renameTo(f3)) {//renameTo包含檔名,所在路徑，完整路徑變更
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}		
	}
}
//IO 輸入輸出串流xxxInputStream,xxxOutputStream xxxReader,xxxWriter
//與File間的關係
//跨平台
//W ;分隔環境變數 \多根路徑分隔號(跳脫字元要畫2根) path=_;_;_;
//M : /單根root
//set列出環境變數
//key=value

//\b back space

//http://
//file:///從根講起root，絕對路徑表示法
//(相對路徑比較好搬家XD)

//.本路徑
//..上一層
