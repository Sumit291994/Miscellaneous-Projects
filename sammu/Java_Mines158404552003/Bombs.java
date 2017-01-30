import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;

public class Bombs extends JFrame implements ActionListener {

	private int BombNum,Rows,Columns;
	private Board BombBoard; // holds game play
	private MenuTop mytop;   // for start and instructions
	private MenuBottom mybottom; //JSPinners are here
	private JScrollPane myscroll; //for scroll bars
	private Container container;

  public Bombs (int R, int C, int B) {
		super("MineSweeper");
		container = getContentPane();
		NewGame(R,C,B); //setup other classes
	}

	public static void main (String args[])
	{
		//if they not numbers start with the standard size
		Integer R = new Integer(20);
		Integer C = new Integer(20);
		Integer B = new Integer(50);

		//if the user passed in two augments stick them in the rows, and cols variables
		if (args.length==3)
				{
			//check to make sure the parameters are numbers
			try	{
				R = new Integer(args[0]);
				C = new Integer(args[1]);
				B = new Integer(args[2]);
				if(B.intValue()>(R.intValue()*C.intValue())/2) { B = new Integer((R.intValue()*C.intValue())/2); }
			}
			catch (NumberFormatException nfe)	{;}
		}

	  Bombs game = new Bombs(R.intValue(),C.intValue(),B.intValue()); //make a class

		game.addWindowListener(  //add listener so program ends when exit
          new WindowAdapter() {
             public void windowClosing( WindowEvent e )
             {
                 System.exit( 0 );
             }
         }
      );
  }


  public void actionPerformed(ActionEvent event) {;}  // does nothing... dont have to declare abstact though


  //************************************************************
	// This function will 'reset' the board if the parameters have not changed
  //
  public void ResetGame ( ) {	BombBoard.ResetBoard( ); }


  //************************************************************
	// This function will tell the top menu that the board must be resized
	//  when the game is restarted.  It calls RestartGame instead of ResetGame if set
  //
  public void setResize (int resizeint) {	mytop.setResize(resizeint); }


  //************************************************************
	// This function will hid the game, resize the board, then make it visible for game play again
  //
	public void RestartGame ( ) {
		setVisible(false);
		NewGame(getCurrentRows( ),getCurrentCols( ),getCurrentBombs( ));  //create new instances

  }


  //************************************************************
	// This function is called at the start of a new game or when the board or bombs
	//  needs to be resized.  It removes old instances and makes new ones with
	//  correct parameters.
  //
  public void NewGame(int R, int C, int B) {
		BombNum = B;  //set number of bombs
		Rows = R;     //set number of rows
		Columns = C;  //set number of columns

		Remove( );    //try to remove old items

		//create all new items and add to game
		mytop = new MenuTop(this);
		container.add(mytop, BorderLayout.NORTH);
		mybottom = new MenuBottom(Rows,Columns,BombNum,this);
		container.add(mybottom, BorderLayout.SOUTH);
		BombBoard = new Board(Rows,Columns,BombNum);
		myscroll = new JScrollPane(BombBoard);
		container.add(myscroll, BorderLayout.CENTER);


		setSize(512,602);  //set default size
	  setVisible( true); //reshow game
  }


  //************************************************************
	// This function will try to remove the contents of a game is they exist.
	//  If nothing there (first time through), it will do nothing.
  //
  public void Remove( ) {
		try {
			container.remove(mytop);
			container.remove(mybottom);
			container.remove(myscroll);
		}
    catch (Throwable nfe)	{;}
	}

  //************************************************************
	//  Returns current rows from JSpinner
  public int getCurrentRows( ) { return mybottom.getRows( ); }


  //************************************************************
	//  Returns current columns from JSpinner
  public int getCurrentCols( ) { return mybottom.getCols( ); }


  //************************************************************
	//  Returns current bombs from JSpinner
  public int getCurrentBombs( ) { return mybottom.getBombs( ); }

}//end of it all






