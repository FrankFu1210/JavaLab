package tw.frank.tutor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//TCP接收 ServerSocket(int port) ; .accept()
public class L57 {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);//用網路呼叫80，就是在寫apachi server
			System.out.println("wait...");
			Socket socket = server.accept();
			
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(isr);
			
			String line = reader.readLine();
			while (line = )
			
			InetAddress ip = socket.getInetAddress();
			
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
