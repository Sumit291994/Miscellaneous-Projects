import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.Panel;

class Login
{
	public static void main(String args[])	{
	
		Frame frm = new Frame("Login");
		frm.setSize(350,250);
		frm.setBackground(Color.gray);
		
		frm.setLayout(new GridLayout(4,1));
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		Panel p5 = new Panel();
		
		p1.setBackground(Color.lightGray);
		p2.setBackground(Color.lightGray);
		p3.setBackground(Color.lightGray);
		p4.setBackground(Color.lightGray);
		p5.setBackground(Color.lightGray);
		
		frm.add(p1);
		frm.add(p2);
		frm.add(p3);
		frm.add(p4);
	//	frm.add(p5);
		
		p2.setLayout(new FlowLayout());
		p3.setLayout(new FlowLayout());
		p4.setLayout(new GridLayout(2,1));
		
		p2.add(new Label("User Name : "));
		TextField tf1 = new TextField(12);
		p2.add(tf1);
		
		p3.add(new Label("Password :   "));
		TextField tf2 = new TextField(12);
		p3.add(tf2);
		
		Button b1 = new Button("  OK  ");
		Button b2 = new Button(" Cancel ");
		
		Panel p6 = new Panel();
		p6.setLayout(new FlowLayout());
		
		p4.add(p6);
		p6.add(b1);
		p6.add(b2);
		
		frm.setVisible(true);
	
	}

}