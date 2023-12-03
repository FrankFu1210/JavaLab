package tw.frank.classes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;

//簽名板+清除/重寫/color+畫不同顏色 1127 090931
public class MyPanelV3 extends JPanel {
//	private LinkedList<LinkedList<Point3>> lines, recycle;
	private LinkedList<Line> lines, recycle;
	private Color color;
	
	public MyPanelV3 () {
		setBackground(Color.yellow);
		
		lines = new LinkedList<>();
		recycle = new LinkedList<>();
		color = Color.cyan;
		
		MyMouseListener listener = new MyMouseListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)(g);
		
//		g2d.setColor(Color.blue);
//		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(3));
			
		for (Line line : lines) {
			g2d.setColor(line.color);
			
			for (int i=1; i<line.points.size(); i++) {
				Point3 p0 = line.points.get(i-1);
				Point3 p1 = line.points.get(i);
//				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
				g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
			}
		}
	}
	
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			recycle.clear();
			Line line = new Line(e.getX(), e.getY(), color);
			lines.add(line);
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			lines.getLast().addPoint(e.getX(), e.getY());
			repaint();
		}
	}
	
	public void clear() {
		lines.clear();
		repaint();
	};
	
	public void undo() {
		if (lines.size() > 0) {
//		lines.removeLast();
			recycle.add(lines.removeLast());
			repaint();			
		}
	};
	
	public void redo() {
		if (recycle.size() > 0) {
//			lines.removeLast();
				lines.add(recycle.removeLast());
				repaint();			
		}
	}

	//Eclipse自動添加get與set方法
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}	
	
}

//複製MyPanelV2到MyPanelV3就顯示The type Point is already defined
class Point3 {int x, y;}

//1127 090931
class Line {
	LinkedList<Point3> points;
	Color color;
	Line(int x, int y, Color color){
		this.color = color;
		
		points = new LinkedList<Point3>();//1127 091356
//		Point3 point = new Point3();
//		point.x = x; point.y = y;
//		points.add(new Point)
//		points.add(point);
		addPoint(x, y);
	}
	void addPoint(int x, int y) {
		Point3 point = new Point3();
		point.x = x; point.y = y;
		points.add(point);
	}
}
/* The type 类名 is already defined
 * 点击Projects=>clean，然后点击clean仍然無效 -> 將Point全數改名為Point3
 * https://blog.csdn.net/ylchou/article/details/7573610
 * https://blog.csdn.net/twxwjh/article/details/107222613 
 * 
 * Eclipse自動添加get與set方法
 * 1. 按下滑鼠右鍵 選 Source -> Generate Getters and setters
 * 2. 選擇要建立get與set方法的變數：color
 * https://www.victsao.com/blog/101-eclipse/444-eclipse-get-set
 * https://blog.csdn.net/m0_37586991/article/details/117969167
 */
