package tw.frank.tutor;

import tw.frank.classes.BCrypt;
//運用BCrypt.java密碼加密，根據Blowfish加密演算法所設計的密碼雜湊函數
public class L65 {

	public static void main(String[] args) {
		String passwd = "123456";
		String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());// return回加密編碼的字串
		System.out.println(hashPasswd);//雜湊值密碼，此密碼開頭固定為$2a$10$，其他字串每次都不一樣
		System.out.println(hashPasswd.length());//長度為60個字
		
		String passwd2 = "123457";
		
		//明碼擺前面，加密擺後面
		if (BCrypt.checkpw(passwd2, hashPasswd)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");//再輸入一次密碼123457進行比對，不符合為XX
		}
	}
}
//業界常用為AES
//進階加密標準（英語：Advanced Encryption Standard，縮寫：AES），又稱Rijndael加密法
//是美國聯邦政府採用的一種區塊加密標準，成為對稱金鑰加密中最流行的演算法之一
