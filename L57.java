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
		while (true) {
		try {
			ServerSocket server = new ServerSocket(9999);//用網路呼叫80，就是在寫apachi server
			System.out.println("wait...");
			Socket socket = server.accept();
			
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(isr);
			
//			String line = reader.readLine();
			String line; StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			InetAddress ip = socket.getInetAddress();
			
			reader.close();
			server.close();
			
//			System.out.println("OK");
//			System.out.println(ip.getHostAddress() + ":" + line);
			System.out.println(ip.getHostAddress() + ":" + sb.toString());
//			if (line.equals("quit")) {
//			if (line.contains("quit")) {
			if (sb.toString().contains("quit")) {
				break;
			}		
		
		} catch (Exception e) {
			System.out.println(e);
		}}

	}

}
