import java.awt.Frame;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.Dimension;

class Random
{
	public static void main(String args[])	{
	
	Frame frm = new Frame();
	frm.setSize(300,300);
	frm.setBackground(Color.lightGray);
	frm.setLayout(new GridLayout(2,1));
	
	Button b1 = new Button("1");
	Button b2 = new Button("2");
	b2.setPreferredSize(new Dimension(40,150));
	Button b3 = new Button("3");
	Button b4 = new Button("4");
	Button b5 = new Button("5");
	Button b6 = new Button("6");
	Button b7 = new Button("7");
	Button b8 = new Button("8");
	Button b9 = new Button("9");
	Button b10 = new Button("10");
	Button b11 = new Button("11");
	Button b12 = new Button("12");
	b12.setPreferredSize(new Dimension(40,150));
	
	//top panel: P1
	Panel p1 = new Panel();
	p1.setBackground(Color.lightGray);
	//p1.setLayout(new BorderLayout());
	p1.setLayout(new GridLayout(1,2));
	
	//sub-panel: P3
	Panel p3 = new Panel();
	p3.setLayout(new GridLayout(2,1));
	Panel p331 = new Panel(new GridLayout(1,2));
	p331.add(b3);
	p331.add(b4);
	p3.add(b1);
	p3.add(p331);
	
	//sub-panel: P4
	Panel p4 = new Panel();
	p4.setLayout(new BorderLayout());
	p4.add(b2,BorderLayout.WEST);
	Panel p44 = new Panel();
	p44.setLayout(new GridLayout(2,1));
	p44.add(b5);
	Panel p441 = new Panel();
	p441.setLayout(new GridLayout(1,2));
	p441.add(b6);
	p441.add(b7);
	p44.add(p441);
	p4.add(p44);
	
	//p1.add(p3,BorderLayout.WEST);
	p1.add(p3);
	p1.add(p4);
	
	//bottom panel: p2
	Panel p2 = new Panel();
	p2.setBackground(Color.lightGray);
	//p2.setLayout(new BorderLayout());
	p2.setLayout(new GridLayout(1,2));
	
	//sub-panel: p5
	Panel p5 = new Panel();
	p5.setLayout(new GridLayout(1,2));
	p5.add(b8);
	p5.add(b9);
	
	//sub-panel: p6
	Panel p6 = new Panel();
	p6.setLayout(new BorderLayout());
	Panel p661 = new Panel();
	p661.setLayout(new GridLayout(2,1));
	p661.add(b10);
	p661.add(b11);
	p6.add(p661);
	p6.add(b12,BorderLayout.EAST);
	
	//p2.add(p5,BorderLayout.WEST);
	p2.add(p5);
	p2.add(p6);
	
	frm.add(p1);
	frm.add(p2);
	frm.setVisible(true);
	
	}

}