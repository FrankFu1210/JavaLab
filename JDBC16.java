package tw.frank.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

//視窗修表
public class JDBC16 extends JFrame {
	
	public JDBC16() {
		
		setLayout(new BorderLayout());
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
		
	public static void main(String[] args) {
		//呼叫override model時間到會自動做
		new JDBC16();

	}

}

