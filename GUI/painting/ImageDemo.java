import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;

class ImageDemo {

	public ImageDemo()	{
		Frame f = new Frame();
		f.setSize(400,400);
		f.setBackground(Color.gray);
		f.setVisible(true);
		
		Graphics g  = f.getGraphics();
		try	{
		Image img = ImageIO.read(new File("dodo0.bmp"));
		//Image img = ImageIO.read(getClass().getResource("dodo0.bmp"));
		//System.out.println(img);
		//g.drawLine(0,100,100,0);
		g.drawImage(img,0,0,null);
		} catch(IOException e)	{
		System.out.println("Exception !!!");
		}
		
	}
	
	public static void main(String args[])	{
		new ImageDemo();
		
	}
}
