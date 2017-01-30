import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;


class DrawArt implements ActionListener,MouseListener,MouseMotionListener {
	
	int x,y,prvx,prvy;
	Canvas cv;
	Graphics g,prvg;
	Button b1,b2,b3,b4,b5;
	boolean flag = true,pencil=false,erase=false,rect=false,oval=false;
	
	public DrawArt()	{
		Frame f = new Frame("DrawART- (Draw Anything)");
		f.setBackground(Color.gray);
		f.setSize(500,600);
		f.setLayout(new BorderLayout());
		
		Panel p1 = new Panel();
		p1.setBackground(Color.lightGray);
		p1.setLayout(new GridLayout(12,1));
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		p1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1 = new Button("Pencil");
		b2 = new Button("Erasor");
		b3 = new Button("Ractangle");
		b4 = new Button("Oval");
		b5 = new Button("Image");
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		cv = new Canvas();
		cv.setBackground(Color.white);
		cv.addMouseListener(this);
		cv.addMouseMotionListener(this);
		f.add(cv);
		
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		f.add(p2,BorderLayout.SOUTH);
		f.add(p3,BorderLayout.NORTH);
		f.add(p1,BorderLayout.WEST);
		f.setVisible(true);
	
		g = cv.getGraphics();
	}
	
	public static void main(String args[])	{
		new DrawArt();
	}
	
	public void actionPerformed(ActionEvent e)	{
		if(e.getSource()==b1)	{
			pencil=true;
			rect=false;
			oval=false;
			erase=false;
		}
		else if(e.getSource()==b2)	{
			pencil=false;
			rect=false;
			oval=false;
			erase=true;
		}
		else if(e.getSource()==b3)	{
			pencil=false;
			rect=true;
			oval=false;
			erase=false;
		}
		else if(e.getSource()==b4)	{
			pencil=false;
			rect=false;
			oval=true;
			erase=false;
		}
		
	}
	
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {
		flag=true;
	}
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mouseDragged(MouseEvent e)	{
		if(flag)	{
		prvx=e.getX();
		prvy=e.getY();
		flag=false;
		prvg=cv.getGraphics();
		}
		else if(pencil)	{
		g.setColor(Color.black);
		x=e.getX();
		y=e.getY();
		g.drawLine(prvx,prvy,x,y);
		prvx=x;
		prvy=y;
		flag=false;
		}
		else if(erase)	{
		g.setColor(Color.white);
		x=e.getX();
		y=e.getY();
		g.fillRect(prvx-2,prvy-2,10,10);
		prvx=x;
		prvy=y;
		flag=false;
		}
		else if(rect)	{
		
		//cv.repaint();
		//cv.update(prvg);
		x=e.getX();
		y=e.getY();
		//g = cv.getGraphics();
		//Graphics g = getGraphics(); // g is the drawing agent for this canvas.
		// See comment in mouseDrag about next two statements.
		g.setColor(Color.white);
	//	g.setXORMode(penColor);
		g.drawRect(prvx,prvy,x-prvx,y-prvy);
		flag=false;
		
//g.setDrawMode();
		
		}
	}
	public void mouseMoved(MouseEvent e)	{} 
}