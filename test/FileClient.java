import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


class FileClient {


	static DataOutputStream os;
	static DataInputStream is;
	
	
	static public void SaveFile()	{
	try{
		FileOutputStream fos = new FileOutputStream(new File("C:/Users/SumZz/Desktop/test2.mp4"));
		DataOutputStream dos = new DataOutputStream(fos);
		boolean flag = true;
		int n;
		byte b[] = new byte[1024];
		
		System.out.println("loop start !!");
		while(flag)	{
		System.out.println("inside ");
			n = is.read(b);
			System.out.println("sumit !!");
			dos.write(b,0,n);
			System.out.println(b+"");
		}
		} catch(Exception e){
			e.printStackTrace();
			}
	}


	public static void main(String args[])	{
	
			
		String ip = "127.0.0.1";
		int portno = 8081;
	Socket s = null;
	
	try {
	s = new Socket(ip,portno);
	System.out.println("Socket created !!");
	} catch(IOException obj) {
		System.out.println("Socket creation error ");
	}
	
	try {
		OutputStream out = s.getOutputStream();
		DataOutputStream os = new DataOutputStream(out);
		
		InputStream in = s.getInputStream();
		DataInputStream is = new DataInputStream(in);
	
		SaveFile();
	
		} catch(IOException e) {
		System.out.println("input output Exception rises!!");
		} 	
		
	
	}

}