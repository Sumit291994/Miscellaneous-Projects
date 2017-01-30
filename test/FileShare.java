import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;



class FileShare {

	String dir,file;
	static DataOutputStream os;
	static DataInputStream is;

	static public void openFile() {
		
				try	{
					
					FileInputStream fis = new FileInputStream(new File("test2.mp4"));
					DataInputStream dis = new DataInputStream(fis);
					
					byte b[] = new byte[1024];
					int n;
				while(dis.available() > 0)	{
					n = dis.read(b);
					os.write(b,0,n);
					Console con = System.console();
					con.readLine();
				}
		
				} catch(Exception e){}
		
	}
	

	public static void main(String args[])	{
		
		String ip = "127.0.0.1";
		int portno = 8081;
			
			try {
			ServerSocket ss = new ServerSocket(portno);
			Socket s = ss.accept();
			System.out.println("Connection initialized !!");
			
			OutputStream out = s.getOutputStream();
			os = new DataOutputStream(out);
			
			InputStream in = s.getInputStream();
			is = new DataInputStream(in);
				
				openFile();
				
			} catch(IOException e) {
			System.out.println("EXception !!!");
			} 
		
		
	}

	

	
}