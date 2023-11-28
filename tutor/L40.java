package tw.frank.tutor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

//L40 FileReader/BufferedReader水管串接，印出opendata標題/第一列，不要逗點
public class L40 {
	//1127 144034
	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader("dir1/ns1hosp.csv");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			System.out.println(line);//標題
			line = br.readLine();
			System.out.println(line);//第一列
			line = br.readLine();
			System.out.println(line);//第二列
			line = br.readLine();
			System.out.println(line);//第三列
			
			System.out.println("-----");
			
			String line2;
			br.readLine();//跳過這一個
			while ((line2 = br.readLine()) != null) {
				String[] row = line2.split(",");
				System.out.printf("%s : %s : %s\n", row[2], row[5], row[6]);
			}			

			fr.close();
				
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}