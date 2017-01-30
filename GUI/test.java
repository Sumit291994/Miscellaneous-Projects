import java.io.*;
import java.awt.*;
import java.awt.event.*;


class test extends ScrollPane implements ActionListener{
	
	Button bt1,bt2;	
	Panel cPanel;

	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == bt1) {
			cPanel.add(new TextArea("I am TextArea !!"));
		}
		else if(e.getSource() == bt2) {
			cPanel.add(new Button("I am Button !!"));
		}
		
	}
	
	test()	{
			Frame f = new Frame("");
			f.setSize(500,500);
			
			Panel topPanel = new Panel();
			bt1 = new Button("Add TextArea");
			bt1.addActionListener(this);
			bt2 = new Button("Add Button");
			bt2.addActionListener(this);
			topPanel.add(bt1);
			topPanel.add(bt2);
			
			ScrollPane sp = new ScrollPane();
			Panel cPanel = new Panel();
			sp.add(cPanel);
			
			f.add(topPanel,BorderLayout.NORTH);
			f.add(sp);
			f.setVisible(true);
	}
	
	public static void main(String args[])	{
		new test();
	}
}