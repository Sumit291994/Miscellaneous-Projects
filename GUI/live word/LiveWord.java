import java.awt.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;



class LiveWord implements KeyListener	{

	Frame f;
	static TextArea tas;
	static DataOutputStream os;
	static String str;
	
	LiveWord()	{
		
		f = new Frame("LiveWord");
		f.setSize(500,600);
		f.setBackground(Color.gray);
		f.setLayout(new BorderLayout());
		
		tas = new TextArea();
		f.add(tas);
		tas.addKeyListener(this);
		
		
		f.setVisible(true);
	
	}
	
	
	public static void main(String args[])	{
			
	
		//Socket s = new Socket();
	//SocketAddress sa = new InetSocketAddress(portno);
	//s.bind(sa);
	String ip = "127.0.0.1";
	int portno = 8080;
	new LiveWord();
	try {
	ServerSocket ss = new ServerSocket(portno);
		
	//System.out.println("Waiting for client on port " +ss.getLocalPort());
	
	Socket s = ss.accept();
	System.out.println("Connection initialized !!");
	
	OutputStream out = s.getOutputStream();
	//DataOutputStream os = new DataOutputStream(out);
	os = new DataOutputStream(out);
	
		
	} catch(IOException e) {
		System.out.println("EXception !!!");
	} 
		

		
	}
	
	
	
	public void keyTyped(KeyEvent e)	{}
	
	public void keyPressed(KeyEvent e)		{}
	public void keyReleased(KeyEvent e)	{
	
		try	{
		str = tas.getText();
		os.writeUTF(str);
		}
		catch (IOException exp)	{}
	}
	
	
}