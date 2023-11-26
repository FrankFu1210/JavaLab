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

//多條線 1124 104620
public class MyPanelV2 extends JPanel {
	private LinkedList<LinkedList<Point>> lines, recycle;
	
	public MyPanelV2 () {
		setBackground(Color.yellow);
		
		lines = new LinkedList<>();
		recycle = new LinkedList<>();
		
		MyMouseListener listener = new MyMouseListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
//		System.out.println("OK");
		
//		if (g instanceof Graphics2D) {
//			System.out.println("OK");
//		}else {
//			System.out.println("XX");		
//		}

//		Graphics2D g2d = (Graphics2D)g;
//		g2d.drawLine(0, 0, 200, 400);
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)(g);
		
		g2d.setColor(Color.blue);
		g2d.setStroke(new BasicStroke(3));
		
//		g2d.drawLine(0, 0, 200, 400);	
		for (LinkedList<Point> line : lines) {			
			for (int i=1; i<line.size(); i++) {
				Point p0 = line.get(i-1);
				Point p1 = line.get(i);
//				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
				g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
			}
		}
	}
	
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			recycle.clear();
//			HashMap<String, Integer> point = new HashMap<>();
//			point.put("x", e.getX()); point.put("y", e.getY());
			Point point = new Point();
			point.x = e.getX(); point.y = e.getY();
			
			LinkedList<Point> line = new LinkedList<>();
			line.add(point);
			
			lines.add(line);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
//			HashMap<String, Integer> point = new HashMap<>();
//			point.put("x", e.getX()); point.put("y", e.getY());
			Point point = new Point();
			point.x = e.getX(); point.y = e.getY();
			
			lines.getLast().add(point);			
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
	};
}

class Point {int x,y;}



