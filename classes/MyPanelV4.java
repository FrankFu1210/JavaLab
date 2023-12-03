package tw.frank.classes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//簽名板+清除/重寫/color+畫不同顏色 1128 112851
//上網stack查詢JPanel存成jpg檔案的方法 1128 115816 ~ 134354超重要!
public class MyPanelV4 extends JPanel implements Serializable{
//	private LinkedList<LinkedList<Point3>> lines, recycle;
	private LinkedList<Line4> lines, recycle;
	private Color color;
	
	public MyPanelV4 () {
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
			
		for (Line4 line : lines) {
			g2d.setColor(line.color);
			
			for (int i=1; i<line.points.size(); i++) {
				Point4 p0 = line.points.get(i-1);
				Point4 p1 = line.points.get(i);
//				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
				g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
			}
		}
	}
	
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			recycle.clear();
			Line4 line = new Line4(e.getX(), e.getY(), color);
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
	
	public void saveObj(File file) throws Exception{
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		oout.writeObject(lines);
		oout.flush();
		oout.close();
	}
	
	public void loadObj(File file) throws Exception {
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
//		oin.read();//不對
		Object obj = oin.readObject();
//		oin.close();//傳送進來後再關閉
		
		if (obj instanceof LinkedList) {
			System.out.println("debug1");//load檔案沒進來
			lines = (LinkedList<Line4>)obj;
			repaint();
			System.out.println("debug2");//load檔案沒進來
		}else {
			throw new Exception("ERR04");
		}
		oin.close();
	}
	
	//參考stack 1128 134344
	public void saveJPEG() {
		BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_BGR);
		
		Graphics g = img.getGraphics();
		paint(g);
		
		try {
			ImageIO.write(img, "jpg", new File("dir1/paintbrush.jpg"));
			System.out.println("Save JPG Success");
		} catch (IOException e) {
			System.out.println(e);
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

//因為NotSerializableException，一併將Point4/Line4進行implements Serializable
class Point4 implements Serializable{int x, y;}

class Line4 implements Serializable{
	LinkedList<Point4> points;
	Color color;
	Line4(int x, int y, Color color){
		this.color = color;
		
		points = new LinkedList<Point4>();//1127 091356
//		Point3 point = new Point3();
//		point.x = x; point.y = y;
//		points.add(new Point)
//		points.add(point);
		addPoint(x, y);
	}
	void addPoint(int x, int y) {
		Point4 point = new Point4();
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
