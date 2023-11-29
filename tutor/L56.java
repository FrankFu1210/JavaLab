package tw.frank.tutor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
//Socket(InetAddress address, int port)
public class L56 {

	public static void main(String[] args) {
		try {
			Socket client = new Socket(InetAddress.getByName("10.0.104.255"), 9999);
			System.out.println("Send OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
