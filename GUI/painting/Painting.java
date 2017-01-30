import java.awt.*;
import java.awt.event.*;

class Painting implements ActionListener{

	CardLayout cl;
	Panel toppanel;
	
	public void actionPerformed(ActionEvent e) {
		cl.next(toppanel);
		//cl.show(toppanel,"greencard");
	}
	
	public Painting() {
	
		Frame f = new Frame("Painting Demo");
		f.setSize(400,400);
		f.setBackground(Color.lightGray);
		f.setLayout(new BorderLayout());
		
		toppanel = new Panel();
		cl = new CardLayout();
		toppanel.setLayout(cl);
		
		Panel redpanel = new Panel();
		redpanel.setBackground(Color.red);
		
		Panel bluepanel = new Panel();
		bluepanel.setBackground(Color.blue);
		
		Panel blackpanel = new Panel();
		blackpanel.setBackground(Color.black);
		
		Panel greenpanel = new Panel();
		greenpanel.setBackground(Color.green);
		
		Panel pinkpanel = new Panel();
		pinkpanel.setBackground(Color.pink);
		
		toppanel.add(redpanel,"redcard");
		toppanel.add(bluepanel,"bluecard");
		toppanel.add(blackpanel,"blackcard");
		toppanel.add(greenpanel,"greencard");
		toppanel.add(pinkpanel,"pinkcard");
		f.add(toppanel);
		
		Button btn = new Button("Change panel !!");
		btn.addActionListener(this);
		f.add(btn,BorderLayout.SOUTH);
		f.setVisible(true);
	}
	
	
	public static void main(String args[]) {
		new Painting();	
	}

}