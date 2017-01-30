import java.io.*;
import java.net.Socket;
import java.awt.*;
import java.net.ServerSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class SendMsg
{
	DataOutputStream os;
	
	public void robo() throws Exception
    {
     //   Calendar now = Calendar.getInstance();
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(screenShot, "JPG", new File("test.jpg"));
     //   System.out.println(formatter.format(now.getTime()));
    }

	
	
	
	public SendMsg(DataOutputStream os)
	{
	try	{
		InputStream is1 = new FileInputStream(new File("test.jpg"));
		DataInputStream dis1 = new DataInputStream(is1);
		this.os=os;
		Console con = System.console();
		boolean flag = true;
		
		byte b[] = new byte[1024000];
		int n;
		int total = 0;
		
		while(dis1.available() > 0)	{
			n = dis1.read(b);
			os.write(b,0,n);
			os.flush();
			total += n;
			System.out.println("Bytes sent: "+n);
		}
		//os.write(b,0,1);
		System.out.println("total Bytes sent: "+total);
		os.close();
		
	} catch(Exception e) {
			e.printStackTrace();
	  }
		
	
	
		
	}
	
	
	
	
	}
	




class Server
{
	public static void main(String args[]) throws Exception
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
	
	screen2image s2i = new screen2image();
        while(1==1)
        {
            s2i.robo();
			SendMsg sm = new SendMsg(os);
            //Thread.sleep(10000);
        }

	
	//con.readLine();
	
//	s.close();
	//ss.close();
	} catch(IOException e) {
		System.out.println("EXception !!!");
	}
	}

}