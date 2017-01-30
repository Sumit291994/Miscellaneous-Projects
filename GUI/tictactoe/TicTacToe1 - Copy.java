import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

class TicTacToe1 implements ActionListener,MouseListener,MouseMotionListener	{
	
	boolean flag=true;
	Graphics g;
	Panel p1,p2,p3,p4,p5,p6,p7,p8,p9;
	static int i,check[] = {0,0,0,0,0,0,0,0,0,0};
	static DataOutputStream os;
	static DataInputStream is;
	
	TicTacToe1()	{
		
		Frame f = new Frame("Tic Tac TOe 1"); 
		f.setSize(390,390);
		f.setBackground(Color.lightGray);
		f.setLayout(new GridLayout(3,3));
		f.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		p5 = new Panel();
		p6 = new Panel();
		p7 = new Panel();
		p8 = new Panel();
		p9 = new Panel();
		p1.setBackground(Color.lightGray);
		p3.setBackground(Color.lightGray);
		p5.setBackground(Color.lightGray);
		p7.setBackground(Color.lightGray);
		p9.setBackground(Color.lightGray);
		
		p2.setBackground(Color.cyan);
		p4.setBackground(Color.cyan);
		p6.setBackground(Color.cyan);
		p8.setBackground(Color.cyan);
		
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		f.add(p5);
		f.add(p6);
		f.add(p7);
		f.add(p8);
		f.add(p9);
		
		//p5.setLayout(new BorderLayout());
		//Canvas c1 = new Canvas();
		//c1.setBackground(Color.white);
		//p5.add(c1);
		p1.addMouseListener(this);
		p1.addMouseMotionListener(this);
		p2.addMouseListener(this);
		p2.addMouseMotionListener(this);
		p3.addMouseListener(this);
		p3.addMouseMotionListener(this);
		p4.addMouseListener(this);
		p4.addMouseMotionListener(this);
		p5.addMouseListener(this);
		p5.addMouseMotionListener(this);
		p6.addMouseListener(this);
		p6.addMouseMotionListener(this);
		p7.addMouseListener(this);
		p7.addMouseMotionListener(this);
		p8.addMouseListener(this);
		p8.addMouseMotionListener(this);
		p9.addMouseListener(this);
		p9.addMouseMotionListener(this);
		
		f.setVisible(true);
		
		
		
		//g = c1.getGraphics();
		
	
		
	}

	public static void main(String args[])	{
		
		Console con = System.console();
		String ip = "127.0.0.1";
		int portno = 8080;
		
		try {
	ServerSocket ss = new ServerSocket(portno);
		
	//System.out.println("Waiting for client on port " +ss.getLocalPort());
	
	Socket s = ss.accept();
	System.out.println("Connection initialized !!");
	
	
	OutputStream out = s.getOutputStream();
	os = new DataOutputStream(out);
	
	InputStream in = s.getInputStream();
	is = new DataInputStream(in);
	
	} catch(IOException e) {
		System.out.println("EXception !!!");
	} 
	
	new TicTacToe1();
		
		
	
			
	}

	
	public void mouseClicked(MouseEvent e) {
		
		if(e.getComponent()==p1)i=1;
		else if(e.getComponent()==p2)i=2;
		else if(e.getComponent()==p3)i=3;
		else if(e.getComponent()==p4)i=4;
		else if(e.getComponent()==p5)i=5;
		else if(e.getComponent()==p6)i=6;
		else if(e.getComponent()==p7)i=7;
		else if(e.getComponent()==p8)i=8;
		else if(e.getComponent()==p9)i=9;
		
		g = e.getComponent().getGraphics();
		int x = e.getX();
		int y = e.getY();
		
		if(flag==true&&check[i]==0)	{
			g.setColor(Color.red);
			g.drawOval(3,3,114,114);
			flag=false;
			check[i]=1;
			
			try	{
		os.writeUTF(""+i);
		
		} catch(IOException ex) {
		
		}
			
	
			try {

		System.out.println(is.readUTF());
		i=Integer.parseInt(is.readUTF());
		} catch(IOException ex) {}	
			
			
			
			}
		else if(flag==false)	{
		
			g.setColor(Color.yellow);
			g.drawLine(0,0,130,130);
			g.drawLine(130,0,0,130);
			flag=true;
			check[i]=2;
		}
		winCheck();
	}
	public void actionPerformed(ActionEvent e)	{}
	public void mouseEntered(MouseEvent e) {
		//e.getComponent().setBackground(Color.black);
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseDragged(MouseEvent e)	{}
	public void mouseMoved(MouseEvent e)	{}
	
	void winCheck()	{
		if((check[1]==check[2]&&check[2]==check[3]&&check[1]!=0)||(check[4]==check[5]&&check[5]==check[6]&&check[4]!=0)||(check[7]==check[8]&&check[8]==check[9]&&check[7]!=0)||(check[1]==check[4]&&check[4]==check[7]&&check[1]!=0)||(check[2]==check[5]&&check[5]==check[8]&&check[2]!=0)||(check[3]==check[6]&&check[6]==check[9]&&check[3]!=0)||(check[1]==check[5]&&check[5]==check[9]&&check[1]!=0)||(check[3]==check[5]&&check[5]==check[7]&&check[3]!=0))
		{
			System.out.println("player "+check[i]+" wins");
			try{
			wait(100000);
			} catch(Exception e){}
			System.exit(0);
		}
	}
}