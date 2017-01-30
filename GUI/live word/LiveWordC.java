import java.awt.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;




class LiveWordC	{

	Frame f;
	static TextArea ta;
	static Socket s = null;
	static DataInputStream is;
	
	LiveWordC()	{
		
		f = new Frame("LiveWord");
		f.setSize(500,600);
		f.setBackground(Color.gray);
		f.setLayout(new BorderLayout());
		
		ta = new TextArea();
		f.add(ta);
		ta.setEnabled(false);
		
		
		f.setVisible(true);
	
	}
	
	
	public static void main(String args[])	{
	
	String ip = "127.0.0.1";
	int portno = 8080;
	
	try {
	s = new Socket(ip,portno);
	System.out.println("Socket created !!");
	} catch(IOException obj) {
		System.out.println("Socket creation error ");
	}
	
	try {	
		InputStream in = s.getInputStream();
		is = new DataInputStream(in);
	
		} catch(IOException e) {
		System.out.println("input output Exception rises!!");
		} 

		new LiveWordC();
	
		boolean flag=true;
		String str;
		while(flag)	{
		try {
		str = is.readUTF();
		ta.setText(str);
		} catch(IOException e) {}
	
	}
	
	}
	
	
}