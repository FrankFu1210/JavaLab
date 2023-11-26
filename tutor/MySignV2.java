package tw.frank.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tw.frank.classes.MyPanel;
import tw.frank.classes.MyPanelV2;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
//簽名版功能 1123 114409
public class MySignV2 extends JFrame {
	private MyPanelV2 myPanel;
	private JButton clear, undo, redo, color;
	
	public MySignV2() {
		super("簽名APP");
		
		setLayout(new BorderLayout());
		myPanel = new MyPanelV2();
		add(myPanel, BorderLayout.CENTER);
		
		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear");
		top.add(clear);
		undo = new JButton("Undo");
		top.add(undo);
		redo = new JButton("Redo");
		top.add(redo);
		color = new JButton("Color");
		top.add(color);
		
		add(top, BorderLayout.NORTH);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupListener();
	}
		
	private void setupListener() {
		clear.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.clear();
			}
		});
		
		undo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.undo();
			}
		});
		
		redo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.redo();
			}
		});
		
		color.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "Change Color", Color.cyan);
			}
		});		
	}




	public static void main(String[] args) {
		new MySignV2();

	}

}
