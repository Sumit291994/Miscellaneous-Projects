import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class SendMsg implements Runnable 
{
	DataOutputStream os;
	Thread t;
	String rply;
	TextArea tas;
	public SendMsg(DataOutputStream os,TextArea tas,String rply)
	{
		this.os=os;
		t = new Thread(this);
		this.rply=rply;
		this.tas=tas;
		t.start();
	}
	
	Thread getThread()
	{
	return t;
	}
	public void run()
	{
	//	Console con = System.console();
	//	boolean flag = true;
	//	while(flag)	{
		try	{
		//System.out.print("Me : ");
		//rply = con.readLine();
		os.writeUTF(rply);
		
		} catch(IOException e) {
		
		}
	//}
	
	
	
	}
	

}



class RecieveMsg implements Runnable 
{	
	DataInputStream is;
	Thread t;
	String rcv;
	TextArea tas;
	
	public RecieveMsg(DataInputStream is,TextArea tas)
	{	
		this.tas=tas;
		this.is=is;
		t = new Thread(this);
		t.start();
	}
	
	Thread getThread() {
	return t;
	}
	public void run()
	{
		boolean flag=true;
		
		while(flag)	{
		try {
		rcv = "Client : "+is.readUTF()+"\n";
		tas.appendText(rcv);
		} catch(IOException e) {}
	
	}
	
	
	
	}
	

}





class Server implements ActionListener
{
	Button bs,bs1,bs2,bs3,bs4,bs5;
	TextField tfs;
	static TextArea tas;
	static DataOutputStream os;
	
	public Server()
	{
	
	Frame fs = new Frame("SERVER-chat");
	fs.setSize(300,400);
	fs.setBackground(Color.darkGray);
	
	tas = new TextArea();
	tas.disable();
	tfs = new TextField(27);
	
	Panel p = new Panel();
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	bs = new Button("Send");
	bs3 = new Button();
	bs4 = new Button();
	bs5 = new Button();
	bs1 = new Button("Clear Window");
	bs2 = new Button("Logout");
	bs.addActionListener(this);
	bs1.addActionListener(this);
	bs2.addActionListener(this);
	
	fs.add(tas);
	fs.add(bs3,BorderLayout.EAST);
	fs.add(bs4,BorderLayout.WEST);
	//fs.add(bs5,BorderLayout.NORTH);
	fs.add(p,BorderLayout.SOUTH);
	//p.setLayout(new GridLayout(2,1));
	p.add(p1);
	fs.add(p2,BorderLayout.NORTH);
	p2.setBackground(Color.lightGray);
	p2.setLayout(new FlowLayout(1,45,5));
	p1.add(tfs);
	p1.add(bs);
	p2.add(bs1);
	p2.add(bs2);
	
	fs.setVisible(true);
	
	
	}
	
	public static void main(String args[])
	{
		new Server();
		//Socket s = new Socket();
	//SocketAddress sa = new InetSocketAddress(portno);
	//s.bind(sa);
	String ip = "127.0.0.1";
	int portno = 8080;
	
	try {
	ServerSocket ss = new ServerSocket(portno);
		
	//System.out.println("Waiting for client on port " +ss.getLocalPort());
	
	Socket s = ss.accept();
	System.out.println("Connection initialized !!");
	
	OutputStream out = s.getOutputStream();
	//DataOutputStream os = new DataOutputStream(out);
	os = new DataOutputStream(out);
	
	InputStream in = s.getInputStream();
	DataInputStream is = new DataInputStream(in);
	
	SendMsg sm = new SendMsg(os,tas,"");
	
	RecieveMsg rm = new RecieveMsg(is,tas);
	
	sm.getThread().join();
	rm.getThread().join();
	
	out.close();
	is.close();
	ss.close();
	
	} catch(IOException e) {
		System.out.println("EXception !!!");
	} catch(InterruptedException f)	{
			System.out.println("InterruptedException rises!!");
	}
	
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == bs)
		{
		String str = tfs.getText();
		tas.appendText("Me: "+str+"\n");
		tfs.setText("");
		new SendMsg(os,tas,str);
		}
		else if(e.getSource() == bs1)
		{
			tas.setText("");
		}
		else if(e.getSource() == bs2)
		{	
			String str ="Leave the Room\n";
			new SendMsg(os,tas,str);
			System.exit(0);
		}
	}
}