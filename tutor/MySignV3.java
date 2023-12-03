package tw.frank.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tw.frank.classes.MyPanel;
import tw.frank.classes.MyPanelV2;
import tw.frank.classes.MyPanelV3;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
//簽名板+清除/重寫/color+畫不同顏色 1127 090349
public class MySignV3 extends JFrame {
	private MyPanelV3 myPanel;
	private JButton clear, undo, redo, color;
	
	public MySignV3() {
		super("簽名APP");
		
		setLayout(new BorderLayout());
		myPanel = new MyPanelV3();
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
//				Color color = JColorChooser.showDialog(null, "Change Color", Color.cyan);
				Color color = JColorChooser.showDialog(null, "Change Color", myPanel.getColor());
				if (color != null) {
					myPanel.setColor(color);
				}
			}
		});		
	}




	public static void main(String[] args) {
		new MySignV3();

	}

}
