import java.net.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class GreetingServer extends Thread
{
       private ServerSocket serverSocket;
       Socket server;

       public GreetingServer(int port) throws Exception
       {
          serverSocket = new ServerSocket(port);
          serverSocket.setSoTimeout(180000);
       }

       public void run()
       {
           while(true)
          { 
               try
               {
                  server = serverSocket.accept();
                  DataInputStream din=new DataInputStream(server.getInputStream());
                  DataOutputStream dout=new DataOutputStream(server.getOutputStream());

                  dout.writeUTF("server: -i am greeting server");
                  dout.writeUTF("server:- hi! hello client");

                  System.out.println(din.readUTF());
                  System.out.println(din.readUTF());

                  BufferedImage img=ImageIO.read(ImageIO.createImageInputStream(server.getInputStream()));

				  try {
					// retrieve image
					//BufferedImage bi = getMyImage();
					File outputfile = new File("saved.jpg");
					ImageIO.write(img, "jpg", outputfile);
				} catch (IOException e) {}
				
				System.out.println("Image received!!!!"); 
                  //lblimg.setIcon(img);
              }
             catch(SocketTimeoutException st)
             {
                   System.out.println("Socket timed out!");
                  break;
             }
             catch(IOException e)
             {
                  e.printStackTrace();
                  break;
             }
             catch(Exception ex)
            {
                  System.out.println(ex);
            }
          }
       }
       
       public static void main(String [] args) throws Exception
       {
              //int port = Integer.parseInt(args[0]);
              Thread t = new GreetingServer(6066);
              t.start();
       }
}
