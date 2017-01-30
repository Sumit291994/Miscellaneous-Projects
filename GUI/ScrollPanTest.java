import java.io.*;
import java.awt.*;
import java.awt.event.*;


class ScrollPanTest	{
	
	
	ScrollPanTest()	{
			Frame f = new Frame("scroll  ");
			f.setSize(500,500);
			
			ScrollPane sp =new ScrollPane();
			
			TextArea ta = new TextArea();
			Button b = new Button();
			Canvas cv = new Canvas();
			
			
			sp.getViewport().add(b);
			sp.getViewport().add(cv);
			sp.getViewport().add(ta);
			f.add(sp);
			f.setVisible(true);
	}
	
	public static void main(String args[])	{
		new ScrollPanTest();
	}
}