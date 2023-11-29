package tw.frank.tutor;

import java.net.InetAddress;
import java.net.UnknownHostException;
// InetAddress ; getByName(String host) ; getHostAddress()
public class L53 {

	public static void main(String[] args) {
		try {
//			InetAddress ip = InetAddress.getByName("www.iii.org.tw");//140.92.87.25			
//			InetAddress ip = InetAddress.getByName("www.ispan.com.tw");//125.227.255.80		
//			InetAddress ip = InetAddress.getByName("www.google.com.tw");//142.251.43.3		
			InetAddress ip = InetAddress.getByName("192.168.3.4");//192.168.3.4		
			System.out.println(ip.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println(e);
		}		
	}
}
