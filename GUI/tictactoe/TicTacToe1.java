import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

class TicTacToe1 implements ActionListener,MouseListener,MouseMotionListener	{
	
	boolean flag=true;
	static Graphics g;
	static int i,check[] = {0,0,0,0,0,0,0,0,0,0};
	static DataOutputStream os;
	static DataInputStream is;
	static Canvas cv;
	
	TicTacToe1()	{
		
		Frame f = new Frame("Tic Tac TOe 1"); 
		f.setSize(390,390);
		f.setBackground(Color.lightGray);
		f.setLayout(new BorderLayout());
		f.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		cv = new Canvas();
		cv.setBackground(Color.white);
		f.add(cv);
		
		cv.addMouseListener(this);
		cv.addMouseMotionListener(this);
		
		f.setVisible(true);
		
		
		
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
		
		g = e.getComponent().getGraphics();
		g.drawLine(125,0,125,390);
		g.drawLine(250,0,250,390);
		g.drawLine(0,125,390,125);
		g.drawLine(0,250,390,250);
		g.setColor(Color.red);
		int x = e.getX();
		int y = e.getY();
		
	if(flag==true)	{
		
		if(x<125&&y<125&&check[1]!=1)	{
		g.drawOval(3,3,112,112);
		check[1]=1;
		}
		else if(x<250&&y<125&&check[2]!=1)	{
		g.drawOval(128,3,112,112);
		check[2]=1;
		}
		else if(x<390&&y<125&&check[3]!=1)	{
		g.drawOval(253,3,112,112);
		check[3]=1;
		}
		else if(x<125&&y<250&&check[4]!=1)	{
		g.drawOval(3,128,112,112);
		check[4]=1;
		}
		else if(x<250&&y<250&&check[5]!=1)	{
		g.drawOval(128,128,112,112);
		check[5]=1;
		}
		else if(x<390&&y<250&&check[6]!=1)	{
		g.drawOval(253,128,112,112);
		check[6]=1;
		}
		else if(x<125&&y<390&&check[7]!=1)	{
		g.drawOval(3,253,112,112);
		check[7]=1;
		}
		else if(x<250&&y<390&&check[8]!=1)	{
		g.drawOval(128,253,112,112);
		check[8]=1;
		}
		else if(x<390&&y<390&&check[9]!=1)	{
		g.drawOval(253,253,112,112);
		check[9]=1;
		}
	//	flag=false;
				
		try	{
		os.writeUTF(""+x);
		os.writeUTF(""+y);
		} catch(IOException ex) {}
		
	winCheck();
	cv.setEnabled(false);
		try {
		System.out.println(is.readUTF());
		x=Integer.parseInt(is.readUTF());
		System.out.println(is.readUTF());
		y=Integer.parseInt(is.readUTF());
		
		
		if(x<125&&y<125&&check[1]!=2)	{
		g.drawLine(0,0,125,125);
		g.drawLine(125,0,0,125);
		check[1]=2;
		}
		else if(x<250&&y<125&&check[2]!=2)	{
		g.drawLine(250,0,125,125);
		g.drawLine(125,0,250,125);
		check[2]=2;
		}
		else if(x<390&&y<125&&check[3]!=2)	{
		g.drawLine(250,0,390,125);
		g.drawLine(250,125,390,0);
		check[3]=2;
		}
		else if(x<125&&y<250&&check[4]!=2)	{
		g.drawLine(0,125,125,250);
		g.drawLine(125,125,0,250);
		check[4]=2;
		}
		else if(x<250&&y<250&&check[5]!=2)	{
		g.drawLine(125,250,250,125);
		g.drawLine(125,125,250,250);
		check[5]=2;
		}
		else if(x<390&&y<250&&check[6]!=2)	{
		g.drawLine(250,125,390,250);
		g.drawLine(390,125,250,250);
		check[6]=2;
		}
		else if(x<125&&y<390&&check[7]!=2)	{
		g.drawLine(0,250,125,390);
		g.drawLine(125,250,0,390);
		check[7]=2;
		}
		else if(x<250&&y<390&&check[8]!=2)	{
		g.drawLine(125,250,250,390);
		g.drawLine(125,390,250,250);
		check[8]=2;
		}
		else if(x<390&&y<390&&check[9]!=2)	{
		g.drawLine(250,250,390,390);
		g.drawLine(390,250,250,390);
		check[9]=2;
		}
		
		
		
		
		} catch(IOException ex) {}	
	}	
		cv.setEnabled(true);
		winCheck();
	}
	
	public void actionPerformed(ActionEvent e)	{}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
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