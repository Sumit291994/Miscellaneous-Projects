import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.awt.event.*;
import java.lang.Math; 

class Dupli implements KeyListener
{
BufferedImage img1,img2,img3,img4,img5,img6,img7,img8,img9;
JPanel p0,p1,p2,p3,p4,p5,p6,p7,p8,p9;
Frame f ;
int a[][] = new int[4][4];
int i,j,k,start=0;
public Dupli()
{


for(i=1;i<4;i++)
for(j=1;j<4;j++)
a[i][j]=0;

rand_value();
draw();

}

void draw()
{
f= new Frame("2048 Game ");
f.setSize(375,387);
f.setBackground(Color.lightGray);
f.setLayout(new GridLayout(3,3));
f.setResizable(false) ;
f.setLocation(450, 150);
try{
	img1 = ImageIO.read(new File(a[1][1]+".jpg"));
	img2 = ImageIO.read(new File(a[1][2]+".jpg"));
	img3 = ImageIO.read(new File(a[1][3]+".jpg"));
	img4 = ImageIO.read(new File(a[2][1]+".jpg"));
	img5 = ImageIO.read(new File(a[2][2]+".jpg"));
	img6 = ImageIO.read(new File(a[2][3]+".jpg"));
	img7 = ImageIO.read(new File(a[3][1]+".jpg"));
	img8 = ImageIO.read(new File(a[3][2]+".jpg"));
	img9 = ImageIO.read(new File(a[3][3]+".jpg"));
	
	
		p1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img1, 0, 0, null);
				
            }
        };
		p2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img2, 0, 0, null);
				
            }
        };
		
		p3 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img3, 0, 0, null);
				
            }
        };
		
		p4 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img4, 0, 0, null);
				
            }
        };
		
		p5 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img5, 0, 0, null);
				
            }
        };
		
		p6 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img6, 0, 0, null);
				
            }
        };
		
		p7 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img7, 0, 0, null);
				
            }
        };
		
		p8 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img8, 0, 0, null);
				
            }
        };
		
		p9 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img9, 0, 0, null);
				
            }
        };
				f.add(p1);
				f.add(p2);
				f.add(p3);
				f.add(p4);
				f.add(p5);
				f.add(p6);
				f.add(p7);
				f.add(p8);
				f.add(p9);
		}catch( Exception e){}
f.addKeyListener(this);
f.setVisible(true);
}


void rand_value()
{
if(start==0)
{
start=1;
int x = (int)(Math.random()*10);
int y = (int)(Math.random()*10);
System.out.println(x+"  "+y);
if(x==0)
x++;
if(y==0)
y++;
if(x>8)
x-=2;
if(y>8)
y-=2;
if(x==y)
x++;
a[x/3 +1][x%3 +1]=2;
a[y/3 +1][y%3 +1]=2;
}
else
{
int x = (int)(Math.random()*10);
if(x==10)
x--;
if(x==0)
x++;

boolean flag = true;
while(flag)	{
for(i=1;i<4;i++)
{
for(j=1;j<4;j++)
{
if(a[i][j]==0)
{
x--;
if(x==0)
a[i][j]=2;
flag=false;
}
}
}
}

}
}


public static void main(String args[])
{
new Dupli();
}

public void keyTyped(KeyEvent e)	{}
	
	public void keyPressed(KeyEvent e)		{
	System.out.println(e.getKeyChar());
	f.setVisible(false);
	
		if(e.getKeyChar()=='a')
		{
		for(i=1;i<4;i++)	{
			if(a[i][1]==a[i][2])
			{
				a[i][1]=2*a[i][1];
				a[i][2]=0;
				
			}
			else if (a[i][2]==a[i][3])
			{
				a[i][2]=2*a[i][2];
				a[i][3]=0;
			}
			if(a[i][1]==0)	{
			a[i][1]=a[i][2];
			a[i][2]=0;
			}
			if(a[i][2]==0)	{
			a[i][2]=a[i][3];
			a[i][3]=0;
			}
			if(a[i][1]==0)	{
			a[i][1]=a[i][2];
			a[i][2]=0;
			}
			if(a[i][1]==a[i][2])
			{
			a[i][1]=2*a[i][1];
			a[i][2]=0;
			}
			}
		}
		else if(e.getKeyChar()=='w')
		{
			for(i=1;i<4;i++)	{
			if(a[1][i]==a[2][i])
			{
				a[1][i]=2*a[1][i];
				a[2][i]=0;
				
			}
			else if (a[2][i]==a[3][i])
			{
				a[2][i]=2*a[2][i];
				a[3][i]=0;
			}
			if(a[1][i]==0)	{
			a[1][i]=a[2][i];
			a[2][i]=0;
			}
			if(a[2][i]==0)	{
			a[2][i]=a[3][i];
			a[3][i]=0;
			}
			if(a[1][i]==0)	{
			a[1][i]=a[2][i];
			a[2][i]=0;
			}
			if(a[1][i]==a[2][i])
			{
			a[1][i]=2*a[1][i];
			a[2][i]=0;
			}
			}
		}
		else if(e.getKeyChar()=='s')
		{
		for(i=1;i<4;i++)	{
			if(a[3][i]==a[2][i])
			{
				a[3][i]=2*a[3][i];
				a[2][i]=0;
				
			}
			else if (a[2][i]==a[1][i])
			{
				a[2][i]=2*a[2][i];
				a[1][i]=0;
			}
			if(a[3][i]==0)	{
			a[3][i]=a[2][i];
			a[2][i]=0;
			}
			if(a[2][i]==0)	{
			a[2][i]=a[1][i];
			a[1][i]=0;
			}
			if(a[3][i]==0)	{
			a[3][i]=a[2][i];
			a[2][i]=0;
			}
			if(a[3][i]==a[2][i])
			{
			a[3][i]=2*a[3][i];
			a[2][i]=0;
			}
			}
		
		}
		else if(e.getKeyChar()=='d')
		{
		for(i=1;i<4;i++)	{
			if(a[i][3]==a[i][2])
			{
				a[i][3]=2*a[i][3];
				a[i][2]=0;
				
			}
			else if (a[i][2]==a[i][1])
			{
				a[i][2]=2*a[i][2];
				a[i][1]=0;
			}
			if(a[i][3]==0)	{
			a[i][3]=a[i][2];
			a[i][2]=0;
			}
			if(a[i][2]==0)	{
			a[i][2]=a[i][1];
			a[i][1]=0;
			}
			if(a[i][3]==0)	{
			a[i][3]=a[i][2];
			a[i][2]=0;
			}
			if(a[i][3]==a[i][2])
			{
			a[i][3]=2*a[i][3];
			a[i][2]=0;
			}
			}
		
		}

	rand_value();
	draw();
	}
	public void keyReleased(KeyEvent e)	{}
	


}