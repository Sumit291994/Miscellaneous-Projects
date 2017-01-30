import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;

class MyCanvas extends Canvas{

	public void paint(Graphics g) {
		//g.drawLine(0,0,200,200);
		//g.drawRect(200,200,150,200);
		///g.drawOval(100,300,150,200);
		try	{
		Image img = ImageIO.read(new File("dodo0.bmp"));
		//Image img = ImageIO.read(getClass().getResource("dodo0.bmp"));
		//System.out.println(img);
		g.drawImage(img,100,100,null);
		} catch(IOException e)	{
		System.out.println("Exception !!!");
		}
	}
}

class MyPanel extends Panel {

	int x1,y1,x2,y2;
	Graphics g;
	public void paint(Graphics g) {
		try	{
		Image img = ImageIO.read(new File("dodo0.bmp"));
		//Image img = ImageIO.read(getClass().getResource("dodo0.bmp"));
		//System.out.println(img);
		g.drawImage(img,100,100,null);
		} catch(IOException e)	{
		System.out.println("Exception !!!");
		}
	}
	
	public void paintAgain(int x1, int y1,int x2,int y2) {
		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		g = getGraphics();
		paint(g);
	}
	/*
	public void paintComponent(Graphics g) {}
	*/
	
}

class CanvasDemo implements MouseListener{

	int x1,y1,count = 1;
	MyPanel p1;
	Panel p2;
	
	
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + "  "+e.getY());
		if(count == 1) {
			x1 = e.getX();
			y1 = e.getY();	
			count = 2;
		}
		else {
			count = 1;
				
			Graphics g = p2.getGraphics();
			g.drawLine(x1,y1,e.getX(),e.getY());
			
			
		}
		
	}

	public CanvasDemo() {
	
		Frame f = new Frame();
		f.setSize(500,500);
		f.setBackground(Color.lightGray);
		f.setLayout(new BorderLayout());
		
		//MyCanvas cv = new MyCanvas();
		//f.add(cv);
		 p1 = new MyPanel();
		 p1.addMouseListener(this);
		
		//p2 = new Panel();
		//p2.addMouseListener(this);
		
		
		
		f.add(p1);
		f.setVisible(true);
		
	}
	public static void main(String args[]) {
		
		new CanvasDemo();
	}


}