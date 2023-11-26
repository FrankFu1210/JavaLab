package tw.frank.tutor;

import java.awt.BorderLayout;

import tw.frank.classes.MyPanel;
import tw.frank.classes.MyPanelV2;

import javax.swing.JFrame;
//簽名版功能 1123 114409
public class MySign extends JFrame {
	private MyPanelV2 MyPanel;
	
	public MySign() {
		super("簽名APP");
		
		setLayout(new BorderLayout());
		MyPanel = new MyPanelV2();
		add(MyPanel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	
	public static void main(String[] args) {
		new MySign();

	}

}
