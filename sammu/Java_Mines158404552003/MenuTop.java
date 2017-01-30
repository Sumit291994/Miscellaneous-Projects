import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuTop extends JPanel implements ActionListener {

	private JButton startbut, helpbut; // control buttons
	private Bombs bombsObj;
	private int Resize=0;  // if window to be resized

	public MenuTop(Bombs b) {

	  bombsObj = b; // pointer to parent

		setLayout(new FlowLayout());

    // create the restart button
		startbut = new JButton("Restart");
		startbut.addActionListener(this);
		add(startbut);

		// create the instuctions button
		helpbut = new JButton("Instructions");
		helpbut.addActionListener(this);
		add(helpbut);
  }

	public void actionPerformed( ActionEvent e ) {
	  // start game button:
		if(e.getSource() == startbut) {
			if (Resize == 1) {      // resize the board
				RestartGame( );
			}
			else { ResetGame( ); }  // reset the board
			Resize = 0;
		}

		// instructions button:
		else if(e.getSource() == helpbut) {
			JOptionPane.showMessageDialog(null,
			"Instructions: \n\n* The object is to clear all squares that do not have bombs in them." +
			"\n* If a cleared square has a number in it, that many bombs are around it." +
			"\n* You may right click on a square to mark that you think it has a bomb." +
			"\n* Right click again to unmark the square." +
			"\n* Clicking on a bomb ends the game." +
			"\n* Click Restart to start over at any point." +
			"\n* To change difficult, adjust the rows, columns, or bombs and click Restart." +
			"\n* Thanks for Playing and Have Fun!","Welcome To Minesweeper",1);
	  }
	}

  //************************ Accessors: *************************

  // return Resize element
  public int getResize() { return Resize; }



  //************************ Mutators: *************************

  // set Resize element
  public void setResize(int resizeint) { Resize = resizeint; }



  //************************ Helpers: *************************

	//start new game with current settings
	public void ResetGame( ) { bombsObj.ResetGame(); }

	//start new game with different board
	public void RestartGame( ) { bombsObj.RestartGame(); }

}



