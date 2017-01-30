import java.io.*;

class ShareTest	{
	
	ShareTest()	{
		try{
		InputStream is = new FileInputStream(new File("C:/Users/SumZz/Desktop/test1.txt"));
		DataInputStream dis = new DataInputStream(is);
		
		OutputStream os = new FileOutputStream(new File("C:/Users/SumZz/Desktop/test2.jpg"));
		DataOutputStream dos = new DataOutputStream(os);
		
		byte b[] = new byte[1024];
		int n;
		
		while(dis.available() > 0)	{
			n = dis.read(b);
			dos.write(b,0,n);
		}
		} catch(Exception e){}
		
	}

	public static void main(String args[])	{
		new ShareTest();
	}
}