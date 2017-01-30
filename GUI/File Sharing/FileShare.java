import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class RecieveMsg implements Runnable 
{	
	DataInputStream is;
	String dir,file;
	boolean flag;
	Thread t;
	Frame fs;
	
	public RecieveMsg(DataInputStream is,Frame fs)
	{	
		//this.tas=tas;
		this.is=is;
		this.fs=fs;
		t = new Thread(this);
		try{
		if(is.readBoolean())
		t.start();}catch(Exception e){}
	}
	
	Thread getThread() {
	return t;
	}
	public void run()
	{
		flag=false;
		try{
		FileDialog fd = new FileDialog(fs,"Save",FileDialog.SAVE);
		fd.show();
		dir = fd.getDirectory();
		file = fd.getFile();
		
		FileOutputStream fos = new FileOutputStream(dir+file);
		DataOutputStream dos = new DataOutputStream(fos);
		flag=true;
		byte b1[] = new byte[1024];
		int n1;
		while(flag)	{
			n1=is.read(b1);
			dos.write(b1,0,n1);
		}
		
		
	
	
	
	}catch(Exception e){}
	}
	

}






class FileShare implements ActionListener	{

	static Frame fs;
	String dir,file;
	static DataOutputStream os;
	static DataInputStream is;
	Button ba;
	
	public void openFile() {
	
		FileDialog fd = new FileDialog(fs,"Open",FileDialog.LOAD);
		fd.setMultipleMode(false);
		fd.show();
		dir = fd.getDirectory();
		file = fd.getFile();
	//	System.out.println(dir);
	//	System.out.println(file);
		
		
				try	{
					
					FileInputStream fis = new FileInputStream(dir+file);
					DataInputStream dis = new DataInputStream(fis);
					
					byte b[] = new byte[1024];
					
					int count = 0;
					int n;
				while(dis.available() > 0)	{
					n = dis.read(b);
					os.write(b,0,n);
				}
		
				} catch(Exception e){}
		
	}
	
	
	
	public FileShare()	{
		
		fs = new Frame("server");
		fs.setSize(400,300);
		fs.setBackground(Color.gray);
		fs.setLayout(new GridLayout(3,1));
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		
		ba = new Button("Attach File");
		ba.addActionListener(this);
		
		p2.add(ba);
		fs.add(p1);
		fs.add(p2);
		fs.add(p3);
		fs.setVisible(true);
	}


	public static void main(String args[])	{
	
	
		new FileShare();
			
		String ip = "127.0.0.1";
		int portno = 8081;
			
			try {
			ServerSocket ss = new ServerSocket(portno);
				
			//System.out.println("Waiting for client on port " +ss.getLocalPort());
			
			Socket s = ss.accept();
			System.out.println("Connection initialized !!");
			
			OutputStream out = s.getOutputStream();
			//DataOutputStream os = new DataOutputStream(out);
			os = new DataOutputStream(out);
			
			InputStream in = s.getInputStream();
			is = new DataInputStream(in);
				
	//		SendMsg sm = new SendMsg(os,"");
			
			RecieveMsg rm = new RecieveMsg(is,fs);
	
		//	sm.getThread().join();
	//		rm.getThread().join();
	

						
			out.close();
			is.close();
			ss.close();
			
			} catch(IOException e) {
			System.out.println("EXception !!!");
			} 
		
		
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == ba)
		{	
			//System.out.println("open");
			openFile();
		}
	
	}
	
	
	
}