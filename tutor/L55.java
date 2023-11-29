package tw.frank.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
//.getAddress() ; .getHostAddress()
public class L55 {

	public static void main(String[] args) {
		while (true) {//無窮迴圈			
			byte[] buf = new byte[1024];
			try {
				DatagramSocket socket = new DatagramSocket(8888);
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				socket.close();
				System.out.println("Receive OK");
				
				int len = packet.getLength();
				byte[] data = packet.getData();//印出字串內容
				
				InetAddress yourip = packet.getAddress();//印出ip
	//			System.out.println(new String(data, 0, len));
				System.out.printf("%s : %s\n", yourip.getHostAddress(), new String(data, 0, len));
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
