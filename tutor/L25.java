package tw.frank.tutor;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import	javax.swing.JFrame;
import	javax.swing.JPanel;

//JFrame叫出滑鼠點/拖曳紀錄位置 ; 抽象類別 -> 漂亮實做
public class L25 extends JFrame{
	private int a;
	public L25() {
		super("L25");

		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		MyMouseListener listener = new MyMouseListener();
		panel.addMouseListener(listener);
		panel.addMouseMotionListener(listener);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new L25();//內部槽狀類別member，與其他普通方法屬性地位相同，不用再透過參數傳遞，可以存取外部類別的屬性方法
	}
	
	private void m1() {System.out.println("m1():" + a);}
	//*同一個物件，聽2個不同介面*
	//*沒有抽象方法，幹嘛宣告為抽象類別 -> 漂亮實做*
	class MyMouseListener extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			a++;
			m1();
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			System.out.println(e.getX() + ", " + e.getY());
		}
	}
}		

//長度固定 -> 資料結構
//小朋友畫資料結構 點點變成線 -> Hello Kitty
//遊戲開發物理引擎 JAVA遊戲引擎 
//遊戲更新畫面 渲染 重刷
//<E>泛型

