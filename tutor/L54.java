package tw.frank.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
// DgS/DgP DatagramSocket() ; DatagramPacket(byte[] buf, int length, InetAddress address, int port)
public class L54 {

	public static void main(String[] args) {
		String mesg = "Hi, Leo";
		byte[] data = mesg.getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(data, data.length,
				InetAddress.getByName("10.0.104.255"), 8888);
			socket.send(packet);
			socket.close();
			System.out.println("Send OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
