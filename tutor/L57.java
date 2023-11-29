package tw.frank.tutor;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//ServerSocket(int port) ; .accept()
public class L57 {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);
			Socket socket = server.accept();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
