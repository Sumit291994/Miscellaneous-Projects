import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;


class GraphPlotter implements MouseListener,ActionListener
{
	TextField  tf;
	Graphics g;
	Button b;
	Canvas cv;
	int x,y,prvx,prvy;
	
	public GraphPlotter()
	{
	Frame f = new Frame ("Graph Plot");
	f.setSize(700,700);
	f.setBackground(Color.lightGray);
	f.setLayout(new BorderLayout());
	cv = new Canvas();
	cv.setBackground(Color.white);
	
	cv.addMouseListener(this);
	
	Panel p = new Panel();
	f.add(p,BorderLayout.SOUTH);
	tf = new TextField(50);
	p.add(tf);
	b = new Button("    Plot    ");
	b.addActionListener(this);
	p.add(b);
	
	f.add(cv);
	f.setVisible(true);
	g = cv.getGraphics();
	
	}
	
	public static void main(String args[])
	{
	GraphPlotter gp = new GraphPlotter();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b)	{
			String foo = tf.getText();
		//	String foo = "0.01+2+0.5-0.1";
			int flag=0;
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			System.out.println(foo);
			for(int j=-320;j<=320;j++)	{
			StringBuffer str = new StringBuffer();
			for(int i=0;i<foo.length();i++)
			{
				if(foo.charAt(i)=='x')
					str.append(j);
				else
				str.append(foo.charAt(i));
			}
			//System.out.println(str);
			try{
			//System.out.println(engine.eval(str.toString()));
			String xx = engine.eval(str.toString()).toString() ;
			int f = Integer.parseInt(xx);
			//System.out.println(f);
			if(flag==0)
			{
			prvx=j;
			prvy=f;
			flag=1;
			}
			else
			{
			g.drawLine(320+prvx,320+prvy,320+j,320+f);
			System.out.println(f);
			prvx=j;
			prvy=f;
			}
			
			} catch(Exception f){}
			}
		}
	}
	
	
	
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
		int x,y;
		x=e.getX();
		y=e.getY();
		g.setColor(Color.black);
		g.drawLine(320,0,320,700);
		g.drawLine(0,320,700,320);
		
	}

	
}