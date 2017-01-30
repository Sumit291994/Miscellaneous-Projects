import java.awt.*;
import java.awt.event.*;

public class DialogBox implements ActionListener {
	TextArea ta;
	Dialog dg;
	Button save,dsav,can;
	boolean status;
	Frame frm;
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == save) {
			status = true;
			dg.hide();
			//dg.setVisible(false);
			
		}
		else if(e.getSource() == dsav) {
			ta.setText("");
			frm.setTitle("Writepad++                      Untitled File         ");
			dg.hide();
			//dg.setVisible(false);
		
		}
		else if(e.getSource() == can)	{
			dg.hide();
		}
		
	}
	
	public DialogBox(Frame frm,String msgg,TextArea ta) {
		this.ta=ta;
		this.frm=frm;
		status = false;
		dg = new Dialog(frm,msgg,true);
		dg.setSize(300,100);
		dg.setResizable(false);
		dg.setLocationRelativeTo(frm);
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		Label msg = new Label("Are You Sure  ??");
		p.add(msg);
		Panel btmPanel = new Panel();
		btmPanel.setLayout(new FlowLayout());
		save = new Button("Save");
		save.addActionListener(this);
		dsav= new Button("Don't Save");
		dsav.addActionListener(this);
		can= new Button("Cancel");
		can.addActionListener(this);
		
		btmPanel.add(save);
		btmPanel.add(dsav);
		btmPanel.add(can);
		dg.add(btmPanel,BorderLayout.SOUTH);
		dg.add(p);
		//dg.show();
	}
	
	public void show() {
		dg.show();
	}

}