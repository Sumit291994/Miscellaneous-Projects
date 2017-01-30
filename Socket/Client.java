import java.io.*;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;



class CSendMsg implements Runnable 
{
	DataOutputStream os;
	Thread t;
	public CSendMsg(DataOutputStream os)
	{
		this.os=os;
		t = new Thread(this);
		t.start();
	}
	Thread getThread()
	{
	return t;
	}
	public void run()
	{
		Console con = System.console();
		boolean flag = true;
		while(flag)	{
		try	{
		System.out.print("Me : ");
		String rply = con.readLine();
		os.writeUTF(rply);
		
		} catch(IOException e) {
		
		}
	}
	
	
	
	}
	

}



class CRecieveMsg implements Runnable 
{	
	DataInputStream is;
	Thread t;
	public CRecieveMsg(DataInputStream is)
	{
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
		System.out.print("Server : ");
		System.out.println(is.readUTF());
		} catch(IOException e) {}
	
	}
	
	
	
	}
	

}


class Client
{
	public static void main(String args[]) {
	Console con = System.console();
	//String str = con.readLine();
	String ip = "127.0.0.1";
	int portno = 8080;
	Socket s = null;
	try {
	s = new Socket(ip,portno);
	System.out.println("Socket created !!");
	} catch(IOException obj) {
		System.out.println("Socket creation error ");
	}
	
	
	//SocketAddress sa = new InetSocketAddress(portno);
	 //s.connect(sa,3000);
	
	try {
		OutputStream out = s.getOutputStream();
		DataOutputStream os = new DataOutputStream(out);
	
		InputStream in = s.getInputStream();
		DataInputStream is = new DataInputStream(in);
	
		CSendMsg sm = new CSendMsg(os);
	
		CRecieveMsg rm = new CRecieveMsg(is);
	
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
}