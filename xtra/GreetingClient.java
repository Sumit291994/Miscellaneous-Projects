import java.net.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class GreetingClient
{
    Image newimg;
    static BufferedImage bimg;
    byte[] bytes;
	static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
	  public void robo() throws Exception
    {
        Calendar now = Calendar.getInstance();
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(screenShot, "JPG", new File(formatter.format(now.getTime())+".jpg"));
     //   System.out.println(formatter.format(now.getTime()));
    }

   public static void main(String [] args) throws Exception
   {
      String serverName = "localhost";
      int port = 6066;
      try
      {

 while(1==1)
        {
	  System.out.println("Connecting to " + serverName
                             + " on port " + port);
         Socket client = new Socket(serverName, port);

         System.out.println("Just connected to "
                      + client.getRemoteSocketAddress());

        DataInputStream in=new DataInputStream(client.getInputStream());
        System.out.println(in.readUTF());
        System.out.println(in.readUTF());

         DataOutputStream out =
                       new DataOutputStream(client.getOutputStream());

         out.writeUTF("Hello from "
                      + client.getLocalSocketAddress());
         out.writeUTF("client: hello to server");
  
       GreetingClient s2i = new GreetingClient();
       
         //   s2i.robo();
            //Thread.sleep(10000);
			
			 Calendar now = Calendar.getInstance();
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(screenShot, "JPG", new File(formatter.format(now.getTime())+".jpg"));
			
         bimg = ImageIO.read(new File("test.JPG"));
		  ImageIO.write(bimg,"JPG",client.getOutputStream());
         System.out.println("Image sent!!!!");
		 Thread.sleep(2000);
		}

        // client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
