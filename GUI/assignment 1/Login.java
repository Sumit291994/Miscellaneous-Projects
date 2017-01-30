import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Login implements ActionListener
{
	Button b1,b2;
	TextField tf1,tf2,tf3;
	Panel p1,p2,p3,p4,p5;
	Frame frm;
	Label l1,l2;
	
	public Login()	{
	
		frm = new Frame("Login");
		frm.setSize(350,250);
		frm.setBackground(Color.gray);
		
		frm.setLayout(new GridLayout(5,1));
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		p5 = new Panel();
		
		
		p1.setBackground(Color.lightGray);
		p2.setBackground(Color.lightGray);
		p3.setBackground(Color.lightGray);
		p4.setBackground(Color.lightGray);
		p5.setBackground(Color.lightGray);
		
		
		p2.setLayout(new FlowLayout());
		p3.setLayout(new FlowLayout());
		p4.setLayout(new FlowLayout());
		
		p2.add(new Label("User Name : "));
		tf1 = new TextField(12);
		p2.add(tf1);
		
		p3.add(new Label("Password :   "));
		tf2 = new TextField(12);
		p3.add(tf2);
		
		b1 = new Button("  OK  ");
		b1.addActionListener(this);
		b2 = new Button(" Cancel ");
		b2.addActionListener(this);
		
		tf3 = new TextField(15);
		tf3.setBackground(Color.lightGray);
		tf3.setEnabled(false);
		
		p5.add(tf3);
		p4.add(b1);
		p4.add(b2);
		
		
		frm.add(p1);
		frm.add(p2);
		frm.add(p3);
		frm.add(p4);
		frm.add(p5);
		
	/*	l1 = new Label("Login Successfully...",Label.CENTER);
		l1.setForeground (Color.green);
		
		l2 = new Label("Login Failed...",Label.CENTER);
		l2.setForeground (Color.red);
		
		l1.setVisible(false);
		l2.setVisible(false);
		
		p5.add(l1);
		p5.add(l2);
			*/
			
		frm.setVisible(true);
	
	}

	public static void main(String args[])	{
		
		new Login();

	}

	
	public void actionPerformed(ActionEvent e)	{
	
	String str1 = tf1.getText();
	String str2 = tf2.getText();
	String rev = new StringBuffer(str1).reverse().toString();
	
	if(e.getSource() == b1)	{
	
		if(str2.equals(rev))	{
		//	l1.setVisible(true);
			//l2.setVisible(false);
			
			tf3.setText("Login Successfully...");
			tf3.setForeground (Color.green);
		}
		else	{
		//	l1.setVisible(false);
		//	l2.setVisible(true);
		
			tf3.setText("Login failed...");
			tf3.setForeground (Color.red);
		}
	}
	
	else if(e.getSource() == b2)	{
		System.exit(0);
	}
	
	}
	
	
}