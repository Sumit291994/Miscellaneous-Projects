import java.io.*;
import java.awt.Frame;
import java.awt.Color;
import java.awt.TextField;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.Rectangle;
import java.awt.Dimension;

//import java.awt.Component;


class GUIDemoCal  {

	public static void main(String args[])	{
	
		// frame create
	Frame frame = new Frame("GUI Demo Calculator");
	frame.setSize(300,300);
	frame.setBackground(Color.darkGray);
	//frame.setBackground(new Color(5));
	frame.setLayout(new BorderLayout());
	
	
	TextField tf1 = new TextField("");
	tf1.setBackground(Color.white);
	tf1.setPreferredSize(new Dimension(300,50));
	tf1.setFont(new Font("Bernard MT",Font.BOLD,15));
	frame.add(tf1,BorderLayout.NORTH);
	
	Panel p1 = new Panel();
	p1.setBackground(Color.lightGray);
	p1.setLayout(new GridLayout(4,4,3,3));
	frame.add(p1);
	
	
//	Rectangle rect = new Rectangle(0,0,10,10);
//	frame.add(rect);
	
	
	
	Button btn[] = new Button[20];
	String bn[] = {"7","8","9","DEL","AC","4","5","6","*","/","1","2","3","+","-","0",".","EXP","ANS","="};
	for(int i=0;i<20;i++)	{
		
		btn[i] = new Button(""+bn[i]);
		p1.add(btn[i]);
	}
	
	
	
	frame.setVisible(true);
	}

}


