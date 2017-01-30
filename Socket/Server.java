import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;


class SendMsg implements Runnable 
{
	DataOutputStream os;
	Thread t;
	public SendMsg(DataOutputStream os)
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



class RecieveMsg implements Runnable 
{	
	DataInputStream is;
	Thread t;
	public RecieveMsg(DataInputStream is)
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
		System.out.print("Client : ");
		System.out.println(is.readUTF());
		} catch(IOException e) {}
	
	}
	
	
	
	}
	

}





class Server
{
	public static void main(String args[])
	{
	Console con = System.console();
	String ip = "127.0.0.1";
	int portno = 8080;
	
	
	//Socket s = new Socket();
	//SocketAddress sa = new InetSocketAddress(portno);
	//s.bind(sa);
	
	try {
	ServerSocket ss = new ServerSocket(portno);
		
	//System.out.println("Waiting for client on port " +ss.getLocalPort());
	
	Socket s = ss.accept();
	System.out.println("Connection initialized !!");
	
	OutputStream out = s.getOutputStream();
	DataOutputStream os = new DataOutputStream(out);
	
	InputStream in = s.getInputStream();
	DataInputStream is = new DataInputStream(in);
	
	SendMsg sm = new SendMsg(os);
	
	RecieveMsg rm = new RecieveMsg(is);
	
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

}