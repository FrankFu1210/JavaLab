package tw.frank.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;

import tw.frank.classes.MyPanel;
import tw.frank.classes.MyPanelV2;
import tw.frank.classes.MyPanelV3;
import tw.frank.classes.MyPanelV4;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
//簽名板+清除/重寫/color+畫不同顏色+存檔讀檔 1128 111526
public class MySignV4 extends JFrame implements Serializable{
	private MyPanelV4 myPanel;
	private JButton clear, undo, redo, color, saveObj, loadObj, save;
	
	public MySignV4() {
		super("簽名APP");
		
		setLayout(new BorderLayout());
		myPanel = new MyPanelV4();
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
		
		saveObj = new JButton("saveObj");
		top.add(saveObj);
		loadObj = new JButton("loadObj");
		top.add(loadObj);	
		
		save = new JButton("save");
		top.add(save);
		
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
				Color color = JColorChooser.showDialog(null, "Change Color", myPanel.getColor());
				if (color != null) {
					myPanel.setColor(color);
				}
			}
		});		
		
		saveObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					File saveFile = jfc.getSelectedFile();
				
					try {
						myPanel.saveObj(saveFile);
						System.out.println("Save Success");
					} catch (Exception e1) {
						System.out.println(e1);
					}
				}
			}
		});
		loadObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					File loadFile = jfc.getSelectedFile();
//					MyPanelV4.loadObj(loadFile);
					try {
//						myPanel.saveObj(loadFile);//saveObj沒改到! 根本load不進來
						myPanel.loadObj(loadFile);
						System.out.println("Load Success");//到1128 1142844
					} catch (Exception e1) {
						System.out.println(e1);
					}
				}
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.saveJPEG();
				
			}
		});
	}




	public static void main(String[] args) {
		new MySignV4();

	}

}
/*java.io.NotSerializableException: tw.frank.classes.Line4
 *java.io.NotSerializableException异常的解决方案，在该实体类的后面加上一句 “implements Serializable”
 * https://blog.csdn.net/yilongchuan/article/details/103770571
 * Java 序列化类时报 Caused by java.io.NotSerializableException
 * 将代码改成如下形式, 用常规的 new 一个 ArrayList 丢到 testMessage 里
 * https://how25.github.io/howtofun/blog/Java-%E5%BA%8F%E5%88%97%E5%8C%96md
 */
