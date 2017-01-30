import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



class GamePanel extends JPanel {

	BufferedImage image;   //main image
	BufferedImage bird;
	BufferedImage[] dodo;
	int x,y,x1,y1,x2,y2,x3,y3;
	int index=0;


    public GamePanel() {
		 image = new BufferedImage(1400,500,BufferedImage.TYPE_3BYTE_BGR);  //////fill it
		 dodo = loadImageCycle("images");
	}	
	
		/*method: resizeImage() */
	public BufferedImage resizeImage(BufferedImage img,int w,int h) {
		
		Image tmp = img.getScaledInstance(w, h, Image.SCALE_FAST);
		BufferedImage resized = new BufferedImage(tmp.getWidth(null),tmp.getHeight(null),BufferedImage.TYPE_3BYTE_BGR);
		resized.getGraphics().drawImage(tmp, 0, 0, null);
		return resized;
		
	}
	
	public Image loadSingleImage(String imgpath) {
		Image img=null;
		
		try {
			img = ImageIO.read(new File(imgpath));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return img;
		
	}
	
	public BufferedImage[] loadImageCycle(String folder)
	{
		File f = new File(folder);
		File[] files = f.listFiles();
		BufferedImage[] images = new BufferedImage[files.length];
		
		for(int i=0;i<files.length;i++) {
			try {
				images[i] = ImageIO.read(files[i]);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return images;
	}

	public void initGame(int x,int y) {
		this.x =x;
		this.y = y-100; 
		x1 = 500;
		y1 = 0;
		x2 = 900;
		y2 = 280;
		x3 = 1100;
		y3 = 0;
	}
	
	
	
	private void drawBird() {
	
		Graphics g = image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0,0,1400,500);
		dodo[index] = resizeImage(dodo[index],200,200);
		g.drawImage(dodo[index],x,y,null);
		index = (++index)%(dodo.length);
	
		g.dispose();
	 	repaint();
		
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
		if(image != null) g.drawImage(image,0,0,null);
    }

	void moveLeft() {
		x-=10;
		drawBird();	
	}
	 void moveRight() {
		x+=10;
		drawBird();	
	}
	
	void moveLeft(int z) {
		if(x<z)
		{
		while(true)
		{
		moveRight();
		try{
		Thread.sleep(100);
		} catch(Exception e){}
		if(x>z)
		break;
		}
		}
		else
		{
		while(true)
		{
		moveLeft();
		try{
		Thread.sleep(100);
		} catch(Exception e){}
		if(x<z)
		break;
		}
		
		}
	}
	
}


