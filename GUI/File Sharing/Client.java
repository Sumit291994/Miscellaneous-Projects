import java.io.*;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class CSendMsg implements Runnable 
{
	DataOutputStream os;
	Thread t;
	String rply;
	TextArea tas;
	
	public CSendMsg(DataOutputStream os,TextArea tas,String rply)
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
	//	System.out.print("Me : ");
	//	String rply = con.readLine();
		os.writeUTF(rply);
		
		} catch(IOException e) {
		
		}
	//}
	
	
	
	}
	

}



class CRecieveMsg implements Runnable 
{	
	DataInputStream is;
	Thread t;
	String rcv;
	TextArea tas;
	
	public CRecieveMsg(DataInputStream is,TextArea tas)
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
		rcv = "Server : "+is.readUTF()+"\n";
		tas.appendText(rcv);
		} catch(IOException e) {}
	
	}
	
	
	}
	

}


class Client implements ActionListener
{	
	static Socket s = null;
	Frame fip;
	Button bs,bs1,bs2,bs3,bs4,bs5,log;
	TextField tfs,t1,t2,t3,t4;
	static TextArea tas;
	static DataOutputStream os;
	static String ip;
	
	public Client(int dummy)
	{
	fip = new Frame();
	fip.setSize(400,200);
	fip.setBackground(Color.gray);
	fip.setLayout(new GridLayout(4,1));
	Panel pc1 = new Panel();
	Panel pc2 = new Panel(new FlowLayout(3));
	Panel pc3 = new Panel();
	Panel pc4 = new Panel();
	
	pc2.add(new Label("IP Address of Server:  "));
	
	t1 = new TextField(3);
	t2 = new TextField(3);
	t3 = new TextField(3);
	t4 = new TextField(3);
	log = new Button("Connect");
	log.addActionListener(this);
	
	
	
	pc2.add(t1);
	pc2.add(t2);
	pc2.add(t3);
	pc2.add(t4);
	
	pc3.add(log);
	
	fip.add(pc1);
	fip.add(pc2);
	fip.add(pc3);
	fip.add(pc4);
	fip.setVisible(true);
	}
	
	public Client()
	{
	Frame fs = new Frame("Client-chat");
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


	public static void main(String args[]) {
	
		new Client(1);
		
		//connection();
	}
	
	public static void connection()
	{
		//Console con = System.console();
	//String str = con.readLine();

	//ip = "127.0.0.1";
	int portno = 8080;
	
	try {
	s = new Socket(ip,portno);
	System.out.println("Socket created !!");
	} catch(IOException obj) {
		System.out.println("Socket creation error ");
	}
	
	if(s.isConnected())	{
		
	}	
	else	{
		System.exit(0);
	}
	new Client();
	
	//SocketAddress sa = new InetSocketAddress(portno);
	 //s.connect(sa,3000);
	
	try {
		OutputStream out = s.getOutputStream();
		//DataOutputStream os = new DataOutputStream(out);
		os = new DataOutputStream(out);
		
		InputStream in = s.getInputStream();
		DataInputStream is = new DataInputStream(in);
	
		CSendMsg sm = new CSendMsg(os,tas,"");
	
		CRecieveMsg rm = new CRecieveMsg(is,tas);
	
		sm.getThread().join();
		rm.getThread().join();
	
	
		is.close();
		out.close();
		s.close();
		} catch(IOException e) {
		System.out.println("input output Exception rises!!");
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
		new CSendMsg(os,tas,str);
		}
		else if(e.getSource() == bs1)
		{
			tas.setText("");
		}
		else if(e.getSource() == bs2)
		{	
			String str ="Leave the Room\n";
			new CSendMsg(os,tas,str);
			System.exit(0);
		}
		else if(e.getSource() == log)
		{
			ip=t1.getText()+"."+t2.getText()+"."+t3.getText()+"."+t4.getText();
			fip.setVisible(false);
			//System.out.println(ip);
			connection();
		}
	}
}