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
	Image bird,pipe,pipe1,pipe2;
	Image[] dodo;
	int x,y,x1,y1,x2,y2,x3,y3;
	int index=0;


    public GamePanel() {
		 image = new BufferedImage(1400,500,BufferedImage.TYPE_3BYTE_BGR);  //////fill it
		 bird = new ImageIcon("flappy1.png").getImage();
		 pipe = new ImageIcon("pipe.png").getImage();
		 pipe1 = new ImageIcon("pipe1.png").getImage();
		 pipe2 = new ImageIcon("pipe.png").getImage();
		 dodo = loadImageCycle("dodo");
//		 drawBird();
	//	drawPipe();
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
	
	public Image[] loadImageCycle(String folder)
	{
		File f = new File(folder);
		File[] files = f.listFiles();
		Image[] images = new Image[files.length];
		
		for(int i=0;i<files.length;i++) {
			//System.out.println(files[i].getPath());	
			//images[i] = new ImageIcon(files[i].getPath()).getImage();
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
		this.y = y; 
		x1 = 500;
		y1 = 0;
		x2 = 900;
		y2 = 280;
		x3 = 1100;
		y3 = 0;
	}
	
	
	
	private void drawBird() {
	    System.out.println("Inside");
		Graphics g = image.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,1400,500);
		g.drawImage(dodo[index],x,y,null);
		index = (++index)%(dodo.length);
		System.out.println(index);
		
		
		g.dispose();
	    drawPipe();
		repaint();
		
	}
	private void drawPipe() {
		Graphics g = image.getGraphics();
		g.setColor(Color.black);
		//g.fillRect(0,0,1400,500);
		g.drawImage(pipe,x1,y1,null);
		g.drawImage(pipe1,x2,y2,null);
		g.drawImage(pipe2,x3,y3,null);
		
		if(x1<=0)
		x1=1350;
		if(x2<=0)
		x2=1350;
		if(x3<=0)
		x3=1350;
		g.dispose();
		
		repaint();
		
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
		if(image != null) g.drawImage(image,0,0,null);
    }

    void moveUp() {
	int t = 4;
	while(t>0)	{
		y -= 35;
		t--;
		System.out.println("Hit");
		drawBird();
	/*	try	{
		Thread.sleep(400);
		}
		catch(Exception e)	{}
		*/
		}
	//	moveDown(0);
	}
	 void moveDown(int time) {
		while(y!=340)	{
		y += 20*time*time;
		if(y>=340)
		y=340;
		drawBird();	
		try	{
		Thread.sleep(200);
		}
		catch(Exception e)	{}
		time+=2;
		}
		
	}
	 void moveLeft() {
		//x -= 50;
		x1+=10;
		x2+=10;
		x3+=10;
		drawBird();	
	}
	 void moveRight() {
		//x += 50;
		x1-=10;
		x2-=10;
		x3-=10;
		drawBird();	
	}
	
	
}


