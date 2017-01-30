import java.io.*;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;


class CRecieveMsg
{	
	DataInputStream is;
	
	public CRecieveMsg(DataInputStream is) 
	{
		this.is=is;
		boolean flag=true;
		try {
		OutputStream os1 = new FileOutputStream(new File("rec.jpg"));
		DataOutputStream dos1 = new DataOutputStream(os1);
		
		int n;
		int total = 0;
		while(flag)	{
		
			byte b[] = new byte[1024000];
			n = is.read(b);
			dos1.write(b,0,n);
			dos1.flush();
			total += n;
			System.out.println("Byte recieved: "+n);
			
			//if(n <= 1) {
			//	System.out.println("Total recieved: "+ total);
			//	break;
			//}
		} 
try{
			Process p =
      Runtime.getRuntime()
        .exec("rundll32 url.dll,FileProtocolHandler rec.jpg");
    p.waitFor();
    System.out.println("Done");
			} catch(Exception e) {System.out.println("image open error!!");}
		//	CRecieveMsg(is);
		CRecieveMsg rm = new CRecieveMsg(is);
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	
	
	}
	

}


class Client
{
	public static void main(String args[]) {
	
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
	

		CRecieveMsg rm = new CRecieveMsg(is);
	
	} catch(IOException e) {
		System.out.println("input output Exception rises!!");
	} 
	
	
	}
}