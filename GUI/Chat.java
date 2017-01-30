import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





class Chat implements ActionListener	{
	
	Frame frm;
	Button b1,b2;
	public Chat()	{
		frm = new Frame("CHIT-CHAT");
		frm.setSize(400,250);
		frm.setBackground(Color.darkGray);
		
		frm.setLayout(new GridLayout(4,1));
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		
		b1 = new Button("Create Server");
		b1.addActionListener(this);
		b2 = new Button("Connet to server");
		b2.addActionListener(this);
		p2.setLayout(new FlowLayout(3));
		p3.setLayout(new FlowLayout(3));
		p2.add(b1);
		p3.add(b2);
		
		frm.add(p1);
		frm.add(p2);
		frm.add(p3);
		frm.add(p4);
		frm.setVisible(true);
		
	}
	public static void main(String args[])	{
		
		new	Chat();
	}
	
	public void actionPerformed(ActionEvent e)	{
		
		if(e.getSource() == b1)	{
		//	frm.setVisible(false);
			
			
		}
		else if(e.getSource() == b2)	{
		//	frm.setVisible(false);
			
		}
	
	}

}