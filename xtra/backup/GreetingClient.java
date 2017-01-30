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
	
	  public void robo() throws Exception
    {
     //   Calendar now = Calendar.getInstance();
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(screenShot, "JPG", new File("test.jpg"));
     //   System.out.println(formatter.format(now.getTime()));
    }

   public static void main(String [] args)
   {
      String serverName = "localhost";
      int port = 6066;
      try
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
  
        /* ImageIcon img1=new ImageIcon("test.jpg");
         Image img = img1.getImage();
         Image newimg = img.getScaledInstance(100, 120,  java.awt.Image.SCALE_SMOOTH);
         ImageIcon newIcon = new ImageIcon(newimg);*/

         bimg = ImageIO.read(new File("C:/Users/SumZz/Desktop/snap/test.JPG"));

         ImageIO.write(bimg,"JPG",client.getOutputStream());
         System.out.println("Image sent!!!!");
		 
		 
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
