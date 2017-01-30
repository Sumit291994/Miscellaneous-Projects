import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;



class CRecieveMsg implements Runnable 
{	
	DataInputStream is;
	Thread t;
	//String rcv;
	Frame fs;
	String dir,file;
	
	public CRecieveMsg(DataInputStream is,Frame fs)
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
		boolean flag=false;
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







class FileClient implements ActionListener 	{

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
		//System.out.println(dir);
		//System.out.println(file);
		
		try	{
					
					FileInputStream fis = new FileInputStream(dir+file);
					DataInputStream dis = new DataInputStream(fis);
					
					byte b[] = new byte[1024];
					os.writeBoolean(true);
					int count = 0;
					int n;
				while(dis.available() > 0)	{
					n = dis.read(b);
					os.write(b,0,n);
				}
		
				} catch(Exception e){}
	}
	
	
	public FileClient()	{
		
		fs = new Frame("client");
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
	
	
		new FileClient();
			
		String ip = "127.0.0.1";
		int portno = 8081;
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
		//os = new DataOutputStream(out);
		
		InputStream in = s.getInputStream();
		DataInputStream is = new DataInputStream(in);
	
	
		CRecieveMsg rm = new CRecieveMsg(is,fs);
		
	
		is.close();
		out.close();
		s.close();
		} catch(IOException e) {
		System.out.println("input output Exception rises!!");
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