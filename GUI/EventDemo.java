import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


class EventDemo implements ActionListener,MouseListener{

	TextField op1,op2,res;
	Button btn1,btn2;
	
	public EventDemo() {
		Frame frm = new Frame("Event Demo");
		frm.setBackground(Color.lightGray);
		frm.setSize(250,200);
		frm.setLayout(new GridLayout(5,1));
		frm.addMouseListener(this);
		
		/*Panel p1 = new Panel(new GridLayout(1,2));
		Label lb1 = new Label("Value1:  ");
		op1 = new TextField();
		p1.add(lb1);
		p1.add(op1);
		
		Panel p2 = new Panel(new GridLayout(1,2));
		Label lb2 = new Label("Value2:  ");
		op2 = new TextField();
		p2.add(lb2);
		p2.add(op2);
		
		Panel p3 = new Panel(new GridLayout(1,2));
		Label lb3 = new Label("Result:  ");
		res = new TextField();
		p3.add(lb3);
		p3.add(res);
		
		btn1 = new Button("Add");
		btn1.addActionListener(this);
		
		btn2 = new Button("Multiply");
		btn2.addActionListener(this);
		
		
		frm.add(p1);
		frm.add(p2);
		frm.add(p3);
		frm.add(btn1);
		frm.add(btn2);
		*/
		frm.setVisible(true);
	}
	
	public static void main(String args[]) {
		
		new EventDemo();
	}

	//method from ActionListener Interface
	public void actionPerformed(ActionEvent e) {
		String str;
		str = op1.getText();
		int num1 = Integer.parseInt(str);
		str = op2.getText();
		int num2 = Integer.parseInt(str);
		
		int num3 = 0;
		if(e.getSource() == btn1)
			num3 = num1+num2;
		else if(e.getSource() == btn2)
			num3 = num1*num2;
			
		res.setText(""+num3);
	}
	
	
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse pressed at X="+e.getX()+ " and Y="+e.getY());
	}
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse released !!");
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked !!");
	}
	public void mouseEntered(MouseEvent e){
		System.out.println("Mouse Entered !!");
	}
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse exited !!");
	}
	
	
	
	
	

}
