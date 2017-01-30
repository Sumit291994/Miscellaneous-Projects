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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



//import java.awt.Component;


class Calculator implements ActionListener {
	
	Button btn[] = new Button[20];
	String bn[] = {"7","8","9","DEL","AC","4","5","6","*","/","1","2","3","+","-","0",".","EXP","ANS","="};
	TextField tf1;
	int a[] = {0,1,2,5,6,7,10,11,12,15,16};
	String s,sym;
	float num1=0,num2=0,ans=0;
	
	Calculator()	{
	
			// frame create
	Frame frame = new Frame("Calculator");
	frame.setSize(300,300);
	frame.setBackground(Color.darkGray);
	//frame.setBackground(new Color(5));
	frame.setLayout(new BorderLayout());
	
	
	tf1 = new TextField("");
	tf1.setEnabled(false);
	s = tf1.getText();
	tf1.setBackground(Color.white);
	tf1.setPreferredSize(new Dimension(300,50));
	tf1.setFont(new Font("Bernard MT",Font.BOLD,15));
	frame.add(tf1,BorderLayout.NORTH);
	
	Panel p1 = new Panel();
	p1.setBackground(Color.lightGray);
	p1.setLayout(new GridLayout(4,4,3,3));
	frame.add(p1);	
	
	for(int i=0;i<20;i++)	{
		
		btn[i] = new Button(""+bn[i]);
		btn[i].addActionListener(this);
		p1.add(btn[i]);
	//	System.out.println(btn[i].getLabel());
	}
	
	frame.setVisible(true);
	}

	public static void main(String args[])	{
			new Calculator();
	}


	public void actionPerformed(ActionEvent e)	{
			
		for(int i=0;i<11;i++)	{
			if(e.getSource() == btn[a[i]])	{
				tf1.setText(s+btn[a[i]].getLabel());
				s = tf1.getText();
			}
		}
		
		if(e.getSource() == btn[3])	{
			s = s.substring(0,s.length()-1);
			tf1.setText(s);
		}
		else if(e.getSource() == btn[4])	{
			s = "";
			tf1.setText(s);
			num1=0;
			num2=0;
			ans=0;
			sym="";
		}
		else if(e.getSource() == btn[8])	{
			num1=Float.parseFloat(s);
			s = "";
			tf1.setText(s);
			sym="*";
		}
		else if(e.getSource() == btn[9])	{
			num1=Float.parseFloat(s);
			s = "";
			tf1.setText(s);
			sym="/";
		}
		else if(e.getSource() == btn[13])	{
			num1=Float.parseFloat(s);
			s = "";
			tf1.setText(s);
			sym="+";
		}
		else if(e.getSource() == btn[14])	{
			num1=Float.parseFloat(s);
			s = "";
			tf1.setText(s);
			sym="-";
		}
		else if(e.getSource() == btn[19])	{
			num2=Float.parseFloat(s);
			if(sym.equals("+"))	{
				ans=num1+num2;
			}
			else if(sym.equals("-"))	{
				ans=num1-num2;
			}
			else if(sym.equals("*"))	{
				ans=num1*num2;
			}
			else if(sym.equals("/"))	{
				ans=num1/num2;
			}
			tf1.setText(""+ans);
			s=tf1.getText();
			num1=ans;
		}
				
		
		
		
	}
	
	
}


