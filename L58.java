package tw.frank.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//TCP接收 ServerSocket() 存成jpg檔案 from57
public class L58 {

	public static void main(String[] args) {
		while (true) {
		try {
			ServerSocket server = new ServerSocket(6666);
			System.out.println("wait...");
			Socket socket = server.accept();
			InetAddress ip = socket.getInetAddress();
			
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(String.format("dir2/%s.jpg", ip.getAddress())));
			
			//只有InputStream，沒有BufferedReader
			InputStream in = socket.getInputStream();
//			InputStreamReader isr = new InputStreamReader(in);
//			BufferedReader reader = new BufferedReader(isr);
			BufferedInputStream bin = new BufferedInputStream(in);
			int len; byte[] buf = new byte[4*1024*1024];
			while ((len = bin.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}
			
			bout.flush();
			bout.close();
			in.close();			
			
//			reader.close();
			server.close();
			System.out.println(ip.getHostAddress() + ":OK");
			
//			System.out.println(ip.getHostAddress() + ":" + sb.toString());
//			if (sb.toString().contains("quit")) {
//				break;
//			}				
			
		} catch (Exception e) {
			System.out.println(e);
		}}
	}
}
