import java.awt.*;
import java.awt.event.*;

class GUIComponent implements ItemListener,AdjustmentListener {

	int dis = 0;
	int total;
	Dialog dg;
	Label pay;
	
	public void adjustmentValueChanged(AdjustmentEvent e) {
		
		int val = e.getValue();
		pay.setText("You have to pay :  "+val+" Rs/-");
	}
	
	public void itemStateChanged(ItemEvent e) {
		//System.out.println("Item state has been changed !!");
		
		if(e.getStateChange() == ItemEvent.SELECTED) {
			dg.show();
		}
		else
			System.out.println("Item state deselected !!");
	}
	
	
	public GUIComponent() {
		Frame f = new Frame("GUI Other components");
		f.setSize(500,700);
		f.setLayout(new FlowLayout());
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font fontArray[] = ge.getAllFonts();
		System.out.println(fontArray.length);
		//for(int i=0;i<fontArray.length;i++) {
		//	System.out.println(fontArray[i].getFontName());
		//}
		
		
		MenuBar mb = new MenuBar();
		Menu menu1 = new Menu("File");
		MenuItem itm1 = new MenuItem("New");
		MenuItem itm2 = new MenuItem("Open");
		MenuItem sep = new MenuItem("-");
		CheckboxMenuItem itm3 = new CheckboxMenuItem("Save As");
		Menu submenu = new Menu("Font");
		
		menu1.add(itm1);
		menu1.add(itm2);
		menu1.add(sep);
		menu1.add(itm3);
		menu1.add(submenu);
		
		Menu menu2 = new Menu("Edit");
		Menu menu3 = new Menu("Search");
		Menu menu4 = new Menu("View");
		mb.add(menu1);
		mb.add(menu2);
		mb.add(menu3);
		mb.add(menu4);
		f.setMenuBar(mb);
		
		
		
		dg = new Dialog(f, "Error aa gyi !!") ;
		
		Label lb = new Label("Welcome to Reliance mega mart !!");
		f.add(lb);
		
		Panel p = new Panel();
		p.setLayout(new GridLayout(5,4));
		
		Label h1 = new Label("Item name");
		Label h2 = new Label("Price");
		Label h3 = new Label("Quantity");
		Label h4 = new Label("if want");
		p.add(h1);
		p.add(h2);
		p.add(h3);
		p.add(h4);
		
		Label item1 = new Label("Meggi");
		Label price1 = new Label("15 rs/-");
		TextField tf1 = new TextField();
		Checkbox cb1 = new Checkbox("",false);
		cb1.addItemListener(this);
		p.add(item1);
		p.add(price1);
		p.add(tf1);
		p.add(cb1);
		
		Label item2 = new Label("Soup");
		Label price2 = new Label("25 rs/-");
		TextField tf2 = new TextField();
		Checkbox cb2 = new Checkbox("",false);
		p.add(item2);
		p.add(price2);
		p.add(tf2);
		p.add(cb2);
		
		Label item3 = new Label("Sabzi");
		Label price3 = new Label("20 rs/-");
		TextField tf3 = new TextField();
		Checkbox cb3 = new Checkbox("",false);
		p.add(item3);
		p.add(price3);
		p.add(tf3);
		p.add(cb3);
		
		Label item4 = new Label("Jockey Underwear");
		Label price4 = new Label("100 rs/-");
		TextField tf4 = new TextField();
		Checkbox cb4 = new Checkbox("",false);
		p.add(item4);
		p.add(price4);
		p.add(tf4);
		p.add(cb4);
		f.add(p);
		
		
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(3,1));
		Label discount = new Label("Are you regular customer ?");
		CheckboxGroup cbg = new CheckboxGroup();
		Checkbox radio1 = new Checkbox("Yes",true,cbg);
		Checkbox radio2 = new Checkbox("No",false,cbg);
		p2.add(discount);
		p2.add(radio1);
		p2.add(radio2);
		f.add(p2);
		
		List ls = new List(3);
		
		ls.add("Student");
		ls.add("Enginner");
		ls.add("Teacher");
		ls.add("Porn-star");
		f.add(ls);
		
		pay = new Label("You have to pay :  0 Rs/-");
		f.add(pay);
		
		Scrollbar sb = new Scrollbar(Scrollbar.HORIZONTAL,25,10,0,1000);
		sb.setPreferredSize(new Dimension(250,20));
		sb.addAdjustmentListener(this);
		f.add(sb);
		
		f.setVisible(true);
		
	}
	
	public static void main(String args[]) {
	
		new GUIComponent();
	}

}