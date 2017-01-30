import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.io.*;

class Writepad	implements ItemListener,AdjustmentListener,ActionListener {
	
	int rows,cols;
	TextArea ta;
	Checkbox cb;
	List ls;
	Font fontArray[]; 
	String fontnames[];
	Scrollbar sb;
	CheckboxGroup cbg;
	HashMap<String,Color> colormap;
	MenuItem mi11,mi12,mi13,mi14,mi16;
	Frame frm;
	boolean check;
	String dir,file;
	
	public void openFile() {
	
		FileDialog fd = new FileDialog(frm,"Open",FileDialog.LOAD);
		fd.setMultipleMode(false);
		fd.show();
		dir = fd.getDirectory();
		file = fd.getFile();
		//System.out.println(dir);
		//System.out.println(file);
		
		
		if(file != null)	{
				try	{
					check = true;
					FileInputStream fis = new FileInputStream(dir+file);
					DataInputStream dis = new DataInputStream(fis);
					ta.setText("");
					frm.setTitle("Wordpad++     "+dir+file);
					int l = dis.available();
					for(int i=0;i<l;i++)	{
						char c = (char)dis.readByte();
						ta.append(""+c);
					}
					dis.close();
					fis.close();
				}	catch(IOException e)	{
					e.printStackTrace();
				}
		}		
		
	}
	
	public void saveFile()	{
		if(!check)
			saveAsFile();
		else 	{
			try	{
					check = true;
					FileOutputStream fos = new FileOutputStream(dir+file);
					DataOutputStream dos = new DataOutputStream(fos);
					
					frm.setTitle("Wordpad++     "+dir+file);
					String str = ta.getText();
					dos.writeBytes(str);
					dos.close();
					fos.close();
				}	catch(IOException e)	{
					e.printStackTrace();
				}
		}
	}
	
	public void saveAsFile() {
		
		FileDialog fd = new FileDialog(frm,"Save As",FileDialog.SAVE);
		fd.show();
		dir = fd.getDirectory();
		file = fd.getFile();
	//	System.out.println(dir);
	//	System.out.println(file);
		if(file != null)	{
				try	{
					check = true;
					FileOutputStream fos = new FileOutputStream(dir+file);
					DataOutputStream dos = new DataOutputStream(fos);
					
					frm.setTitle("Wordpad++     "+dir+file);
					String str = ta.getText();
					dos.writeBytes(str);
					dos.close();
					fos.close();
				}	catch(IOException e)	{
					e.printStackTrace();
				}
		
		}		
	
	
	}
	
	
	
	
	public Writepad()	{
	
	frm = new Frame("Writepad++                      Untitled File         ");
	check = false;
	frm.setBackground(Color.lightGray);
	frm.setSize(600,650);
	frm.setCursor(Cursor.HAND_CURSOR);
	ta = new TextArea();
	//ta.setForeground(Color.white);
	Panel p1 = new Panel();
	//ScrollPane sp1 = new ScrollPane();
	Panel sp1 = new Panel();
	
	//rows = ta.getRows();
	//cols = ta.getColumns();
	//Label lab1 = new Label("lines : "+rows);
	//Label lab2 = new Label("    columns : "+cols);
	
	//p1.add(lab1);
	//p1.add(lab2);
	//p1.add(lab1);
	//p1.add(lab1);
	
	MenuBar mb = new MenuBar();
	frm.setMenuBar(mb);
	Menu menu1 = new Menu("File");
	Menu menu2 = new Menu("Edit");
	Menu menu3 = new Menu("Format");
	Menu menu4 = new Menu("View");
	Menu menu5 = new Menu("Help");
	
	mi11 = new MenuItem("New             Ctrl+N");
	mi12 = new MenuItem("Open...         Ctrl+O");
	mi13 = new MenuItem("Save             Ctrl+S");
	mi14 = new MenuItem("Save as...");
	MenuItem mi15 = new MenuItem("-");
	mi16 = new MenuItem("Exit");
	
	MenuItem mi51 = new MenuItem("View Help");
	MenuItem mi52 = new MenuItem("About Writepad");
	
	
	
	mi11.addActionListener(this); 
	mi12.addActionListener(this);
	mi13.addActionListener(this);
	mi14.addActionListener(this);
	mi16.addActionListener(this);
	
	
	
	menu5.add(mi51);
	menu5.add(mi52);
	menu1.add(mi11);
	menu1.add(mi12);
	menu1.add(mi13);
	menu1.add(mi14);
	menu1.add(mi15);
	menu1.add(mi16);
	
	mb.add(menu1);
	mb.add(menu2);
	mb.add(menu3);
	mb.add(menu4);
	mb.add(menu5);
	
	//mb.setHelpMenu(menu5);
	
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	fontArray = ge.getAllFonts();
	fontnames = ge.getAvailableFontFamilyNames();
		
	
	ls = new List(3);
	ls.addItemListener(this); 
	Panel pp = new Panel();
	Label lf = new Label("  Font:");
	pp.setLayout(new BorderLayout());
	pp.setPreferredSize(new Dimension(200,22));
//	for(int i=0 ; i<fontArray.length;i++)	{
		//ls.add(fontArray[i].getFontName());
	//}
	pp.add(lf,BorderLayout.WEST);
	pp.add(ls);
	ls.add("DIALOG");
	ls.add("DIALOG_INPUT");
	ls.add("MONOSPACED");
	ls.add("SANS_SERIF");
	ls.add("SERIF");
	
	ls.select(0);
	
	Label l3 = new Label("TextArea Disable:");
	cb = new Checkbox("",false);
	cb.addItemListener(this);
//	Label l = new Label("  Font:");
	sp1.setLayout(new FlowLayout(FlowLayout.LEFT));
	sp1.add(l3);
	sp1.add(cb);
//	sp1.add(l);
	sp1.add(pp);
	Label l2 = new Label("   Size:");
	
	sb = new Scrollbar(Scrollbar.HORIZONTAL,15,1,0,150);
	sb.addAdjustmentListener(this);
	
	sb.setPreferredSize(new Dimension(150,20));
	sb.setBackground(Color.white);
	
	sp1.add(l2);
	sp1.add(sb);
	
//	TextField tf = new TextField();
//	tf.disable();
	
	PopupMenu pop = new PopupMenu();
	//pop.show(ta,50,50);
	
	Panel p3 = new Panel();
	p3.setLayout(new GridLayout(13,1));
	cbg = new CheckboxGroup();
	Checkbox radio1 = new Checkbox("white",true,cbg);
	Checkbox radio2 = new Checkbox("black",false,cbg);
	Checkbox radio3 = new Checkbox("blue",false,cbg);
	Checkbox radio4 = new Checkbox("cyan",false,cbg);
	Checkbox radio5 = new Checkbox("pink",false,cbg);
	Checkbox radio6 = new Checkbox("gray",false,cbg);
	Checkbox radio7 = new Checkbox("lightGray",false,cbg);
	Checkbox radio8 = new Checkbox("darkGray",false,cbg);
	Checkbox radio9 = new Checkbox("yellow",false,cbg);
	Checkbox radio10 = new Checkbox("red",false,cbg);
	Checkbox radio11 = new Checkbox("magenta",false,cbg);
	Checkbox radio12 = new Checkbox("green",false,cbg);
	Checkbox radio13 = new Checkbox("orange",false,cbg);
	p3.add(radio1);
	p3.add(radio2);
	p3.add(radio3);
	p3.add(radio4);
	p3.add(radio5);
	p3.add(radio6);
	p3.add(radio7);
	p3.add(radio8);
	p3.add(radio9);
	p3.add(radio10);
	p3.add(radio11);
	p3.add(radio12);
	p3.add(radio13);
	radio1.addItemListener(this); 
	radio2.addItemListener(this);
	radio3.addItemListener(this);
	radio4.addItemListener(this);
	radio5.addItemListener(this);
	radio6.addItemListener(this);
	radio7.addItemListener(this);
	radio8.addItemListener(this);
	radio9.addItemListener(this);
	radio10.addItemListener(this);
	radio11.addItemListener(this);
	radio12.addItemListener(this);
	radio13.addItemListener(this);
	
	//mapping color-string to Color object : Using HashMap
	colormap = new HashMap<String,Color>();
	colormap.put("black",Color.BLACK);
	colormap.put("blue",Color.BLUE);
	colormap.put("white",Color.white);
	colormap.put("red",Color.red);
	colormap.put("magenta",Color.magenta);
	colormap.put("pink",Color.pink);
	colormap.put("green",Color.green);
	colormap.put("gray",Color.gray);
	colormap.put("lightGray",Color.lightGray);
	colormap.put("darkGray",Color.darkGray);
	colormap.put("cyan",Color.cyan);
	colormap.put("yellow",Color.yellow);
	colormap.put("orange",Color.orange);
	
	
	frm.add(p3,BorderLayout.EAST);
//	frm.add(ls,BorderLayout.WEST);
	frm.add(p1,BorderLayout.SOUTH);
	frm.add(sp1,BorderLayout.NORTH);
	frm.add(ta);
	frm.setVisible(true);
	
	}
	
	public static void main(String args[])	{
	
		new Writepad();
	}
	
//-------------------------------------------------------------- Implementation of ItemListener ------------------------------------------------	
	public void itemStateChanged(ItemEvent e)	{
		if(e.getSource() == cb)	{
			if(cb.getState())	{
				ta.setEnabled(false);
			}
			else
				ta.setEnabled(true);
		}
		else if(e.getSource() == ls)	{
			int i = ls.getSelectedIndex();
			int j = sb.getValue();
			//System.out.println(i);
			//Font newfont = fontArray[i].deriveFont(Font.PLAIN,28);
			ta.setFont(new Font(ls.getItem(i),Font.PLAIN,j));
		}
		else {
			
			Checkbox temp = cbg.getCurrent();
			String key = temp.getLabel();
			Color col = colormap.get(key);
			ta.setBackground(col);
		}
	} 
	
	
	public void adjustmentValueChanged(AdjustmentEvent e)	{
		if(e.getSource() == sb)	{
			//System.out.println(sb.getValue());
			int i = ls.getSelectedIndex();
			int j = sb.getValue();
			ta.setFont(new Font(ls.getItem(i),Font.PLAIN,j));
		}
		
	}
	
	public void actionPerformed(ActionEvent e)	{
		if(e.getSource() == mi11)	{
			
			DialogBox db = new DialogBox(frm,"Wordpad++",ta);
			db.show();
			check = false;
			if(db.status)	{
				saveAsFile();
			}
			
		}
		else if(e.getSource() == mi12)	{
		
			openFile();
			
		}
		else if(e.getSource() == mi13)	{
			
			saveFile();
		}
		else if(e.getSource() == mi14)	{
		
			saveAsFile();
		}
		else if(e.getSource() == mi16)	{
			System.exit(0);
		}
	
	
	}
	
	
	
	
	
}