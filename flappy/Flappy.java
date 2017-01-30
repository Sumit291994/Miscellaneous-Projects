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
import java.awt.event.*;


class Flappy extends JPanel implements KeyListener
{
	JFrame f;
	Image bird;
	int x,y;
		int count = 2;
	GamePanel panel;
	
	public Flappy()
	{
			f = buildFrame();
			f.setSize(1400,500);
			f.setLayout(new BorderLayout());
			f.setBackground(Color.lightGray);		
			panel = new GamePanel();
			f.add(panel);
			x=100;
			y=340;
			panel.initGame(x,y);
			f.addKeyListener(this);
			
			f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
			f.setVisible(true);
		panel.moveDown(0);
		
	}

	private static JFrame buildFrame() {
        JFrame frame = new JFrame("Flappy Bird");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return frame;
    }


	
	public static void main(String args[])
	{
		new Flappy();
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT)	panel.moveLeft();
		else if (key == KeyEvent.VK_RIGHT) panel.moveRight();
		else if (key == KeyEvent.VK_UP) panel.moveUp();
		//else if (key == KeyEvent.VK_DOWN) 	panel.moveDown();
		count=0;
		//panel.moveUp();
		
		}
	public void keyReleased(KeyEvent e) {
		
	}
	public void keyTyped(KeyEvent e)	{}
}