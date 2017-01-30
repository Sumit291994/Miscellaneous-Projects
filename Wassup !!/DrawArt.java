import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


class DrawArt implements ActionListener,MouseListener,MouseMotionListener,WindowListener {
	
	int x,y,prvx,prvy;
	Canvas cv;
	Graphics g,prvg;
	Graphics2D g2;
	Button b1,b2,b5,send;
	Frame f;
	Server obj;
	static BufferedImage image;
	boolean flag = true,pencil=false,erase=false;
	
	public DrawArt(Server obj)	{
		this.obj=obj;
		f = new Frame("DrawART- (Draw Anything)");
		f.setBackground(Color.gray);
		f.setSize(500,600);
		f.setLayout(new BorderLayout());
		f.addWindowListener(this);
		
		Panel p1 = new Panel();
		p1.setBackground(Color.lightGray);
		Panel p2 = new Panel();
		p2.setBackground(Color.gray);
		p1.setLayout(new GridLayout(12,1));
		
		Panel p3 = new Panel();
		p1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1 = new Button("Pencil");
		b2 = new Button("Erasor");
		b5 = new Button("Image");
		send = new Button("SEND");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b5.addActionListener(this);
		send.addActionListener(this);
		
		cv = new Canvas();
		cv.setBackground(Color.white);
		cv.addMouseListener(this);
		cv.addMouseMotionListener(this);
		f.add(cv);
		image = new BufferedImage(500, 600,BufferedImage.TYPE_INT_RGB);
		g2 =(Graphics2D)image.getGraphics();
		g2.setColor(Color.white);
		g2.fillRect(0,0,500,600);
		
		p1.add(b1);
		p1.add(b2);
		p1.add(b5);
		p2.add(send);
		f.add(p2,BorderLayout.SOUTH);
		f.add(p3,BorderLayout.NORTH);
		f.add(p1,BorderLayout.WEST);
		f.setVisible(true);
	
		g = cv.getGraphics();
	}
	
	public static void main(String args[])	{
	//	new DrawArt();
	}
	
	public void actionPerformed(ActionEvent e)	{
		if(e.getSource()==b1)	{
			pencil=true;
			erase=false;
		}
		else if(e.getSource()==b2)	{
			pencil=false;
			erase=true;
		}
		else if(e.getSource()==send)	{
				saveCanvas(cv);
				f.setVisible(false);
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
		g2.setColor(Color.black);
		x=e.getX();
		y=e.getY();
		g.drawLine(prvx,prvy,x,y);
		g2.drawLine(prvx,prvy,x,y);
		prvx=x;
		prvy=y;
		flag=false;
		}
		else if(erase)	{
		g.setColor(Color.white);
		g2.setColor(Color.white);
		x=e.getX();
		y=e.getY();
		g.fillRect(prvx-2,prvy-2,10,10);
		g2.fillRect(prvx-2,prvy-2,10,10);
		prvx=x;
		prvy=y;
		flag=false;
		}
		
	}
	public void mouseMoved(MouseEvent e)	{} 
	
	public void windowClosing(WindowEvent e)
	{
	f.setVisible(false);
	}
	public void windowDeactivated(WindowEvent e)	{}
	public void windowActivated(WindowEvent e)	{}
	public void windowDeiconified(WindowEvent e)	{}
	public void windowIconified(WindowEvent e)	{}
	public void windowClosed(WindowEvent e)	{}
	public void windowOpened(WindowEvent e)	{}
	

	public void saveCanvas(Canvas canvas) {
		
		try {
			ImageIO.write(image, "png", new File("canvas.png"));
		} catch (Exception e) {
			
		}
	}
	
	
	
}