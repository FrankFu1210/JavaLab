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
public class MyPanel extends JPanel {
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines;
	
	public MyPanel () {
		setBackground(Color.yellow);
		
		lines = new LinkedList<>();
		
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
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(3));
		
//		g2d.drawLine(0, 0, 200, 400);	
		for (LinkedList<HashMap<String, Integer>> line : lines) {			
			for (int i=1; i<line.size(); i++) {
				HashMap<String, Integer> p0 = line.get(i-1);
				HashMap<String, Integer> p1 = line.get(i);
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
			}
		}
	}
	
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX()); point.put("y", e.getY());
			
			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();
			line.add(point);
			
			lines.add(line);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX()); point.put("y", e.getY());
			
			lines.getLast().add(point);
			
			repaint();
		}
	}
}

