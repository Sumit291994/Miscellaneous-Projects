import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;    // for music
import java.net.URL;     // for music path
import java.util.Stack;  // for stack

public class Board extends JPanel implements ActionListener,MouseListener {

	private int BombNum,Rows,Columns,TotBut,Correct=0;
	private ImageIcon cover,bomb,bombclicked,bombflag,badflag,empty,num[],mytemppic;   // icons
	private GridLayout grid;
	private BombButton myButtons[][],tmp; // personalized buttons
	private Randomize BombRow,BombCol;    // random arrays
	private Dimension myDim;
	private Stack myStack;    // fix recurrsion prob
	private Timer popStack;   // empties stack

	// audio declarations:
	private AudioClip winM, looseM;
	private URL winurl, looseurl;


	public Board(int R,int C, int B) {
    //Initialize elements:
    BombNum = B;
		Rows = R;
		Columns = C;
		TotBut = Rows*Columns;
		myStack = new Stack();        // make stack to put buttons in to be ran
		popStack = new Timer(1,this); // initialize timer to pop stack
		popStack.start();             // start timer
		cover = new ImageIcon("cover.gif");
		bomb =  new ImageIcon("BombReg.gif");
		bombclicked = new ImageIcon("BombError.gif");
		bombflag = new ImageIcon("BombFlag.gif");
		badflag = new ImageIcon("BombBad.gif");
		empty = new ImageIcon("empty.gif");
		num = new ImageIcon[8];
		for (int i=0; i<8; i++)
			num[i] = new ImageIcon((i+1) + ".gif");

		// for audio
		try{ winurl = new URL("file:Nelly.wav"); }
		catch (Throwable e) {;}
		try{looseurl = new URL("file:explos.wav"); }
		catch (Throwable e) {;}
		winM = Applet.newAudioClip(winurl);
		looseM = Applet.newAudioClip(looseurl);

    //set the layout of the JPanel
		setLayout(new GridLayout(Rows,Columns));
		myDim = new Dimension(cover.getIconWidth()*Rows,cover.getIconHeight()*Columns);
		setPreferredSize(myDim);
		setMaximumSize(myDim);
		setMinimumSize(myDim);

		myButtons = new BombButton[Rows][Columns]; // array of custom buttons
		BombRow = new Randomize(Rows,Columns);  // random array to put bombs (row)
		BombRow.setPointer(0);                  // move to beginning
		BombCol = new Randomize(Columns,Rows);  // random array to put bombs (column)
		BombCol.setPointer(0);                  // move to beginning

		// set defaults on buttons
		myDim = new Dimension(cover.getIconWidth(),cover.getIconHeight()); // for size of button
		for(int i=0;i<Rows;i++) {         // all rows
			for(int j=0;j<Columns;j++) {    // all columns
				myButtons[i][j] = new BombButton(i,j);    // make new
				myButtons[i][j].setIcon( cover );				  // set pic
				myButtons[i][j].setPreferredSize(myDim);  // set all sizes
				myButtons[i][j].setMaximumSize(myDim);
				myButtons[i][j].setMinimumSize(myDim);
				myButtons[i][j].addActionListener(this);  // set for click
				myButtons[i][j].addMouseListener(this);  // set for right click
				add(myButtons[i][j]);                     // add to panel
			}
		}

		for (int i=0;i<BombNum;i++) {	setBombpos( );	} //place bombs on board

		SetBombInt(); // set pic for how many bombs surround button
	}


	//************************************************************
	// This function fires when a button is click and clears cells
  //
	public void actionPerformed(ActionEvent event) {

		// timer object
		if (event.getSource() == popStack) {
			while(!(myStack.empty())) {  // empty what's in stack
				BombButton tmp = (BombButton)myStack.pop(); // set tmp button = event clicked
				ClearAlg(tmp.getRow(),tmp.getColumn());     // flip / add more if needed
		  }
		}

		// left click on cell
		else {
			BombButton tmp = (BombButton)event.getSource(); // set action to a button

			if (tmp.getFlag() == 1) {;} //flag, do nothing
			else if (tmp.getBomb() == 1) { // hit bomb, loose
				HitBomb(tmp.getRow(),tmp.getColumn());
			}
			else {  // show correct buttons
				ClearAlg(tmp.getRow(),tmp.getColumn());
			}
		}
	}


 	//************************************************************
	// This function fires when a button is right clicked and displays or removes a flag
  //
	public void mouseClicked(MouseEvent e)  {
		BombButton tmp = (BombButton)e.getSource(); // set action to a button

		if (e.getButton() == e.BUTTON3 || e.getModifiers() == 4) { //right mouse click
			if (tmp.getFlag() == 1) {  // if flag show, hide
				tmp.setIcon(cover);
				tmp.setFlag(0);
		  }
		  else {  // show flag
				tmp.setIcon(bombflag);
				tmp.setFlag(1);
			}
		}

	}

	//These functions are included for the mouse listener... But i dont use them for actions
	public void mouseEntered(MouseEvent e)  { }
	public void mouseExited(MouseEvent e)   { }
	public void mousePressed(MouseEvent e)  { }
	public void mouseReleased(MouseEvent e) { }



	//************************************************************
	// This function goes through the board and counts the number of bombs
	//  surrounding an individual button then sets it
  //
	public void SetBombInt ( ) {
  	for(int x=0;x<Rows;x++) {  //all rows
			for(int y=0;y<Columns;y++) { //all columns
				//check for valid surrounding cells containing bombs
				if ((x-1) >= 0) {
				  if (myButtons[x-1][y].getBomb() == 1) { myButtons[x][y].setShowNum(myButtons[x][y].getShowNum() + 1); }

				  if (((y-1) >= 0) && (myButtons[x-1][y-1].getBomb() == 1)) { myButtons[x][y].setShowNum(myButtons[x][y].getShowNum() + 1); }
				  if (((y+1) <= (Columns-1)) && (myButtons[x-1][y+1].getBomb() == 1)) { myButtons[x][y].setShowNum(myButtons[x][y].getShowNum() + 1); }
				}
				if (((y-1) >= 0) && (myButtons[x][y-1].getBomb() == 1)) { myButtons[x][y].setShowNum(myButtons[x][y].getShowNum() + 1); }
				if (((y+1) <= (Columns-1)) && (myButtons[x][y+1].getBomb() == 1)) { myButtons[x][y].setShowNum(myButtons[x][y].getShowNum() + 1); }
				if ((x+1) <= (Rows-1)) {
				  if (myButtons[x+1][y].getBomb() == 1) { myButtons[x][y].setShowNum(myButtons[x][y].getShowNum() + 1); }

				  if (((y-1) >= 0) && (myButtons[x+1][y-1].getBomb() == 1)) { myButtons[x][y].setShowNum(myButtons[x][y].getShowNum() + 1); }
				  if (((y+1) <= (Columns-1)) && (myButtons[x+1][y+1].getBomb() == 1)) { myButtons[x][y].setShowNum(myButtons[x][y].getShowNum() + 1); }
				}
			}
	  }
	}


  //************************************************************
	// This function will flip a single button to show pic if it has a number in it.
	//  Otherwise it will add the surround valid, none flipped buttons to a stack to be ran.
  //
	public void ClearAlg (int x, int y) {
		// if button has surrounding bombs
		if ((myButtons[x][y].getShowNum() != 0)  && (myButtons[x][y].isEnabled())) {
			myButtons[x][y].setIcon(num[myButtons[x][y].getShowNum()-1]);
			myButtons[x][y].setDisabledIcon(num[myButtons[x][y].getShowNum()-1]);
			myButtons[x][y].setEnabled( false );
			Correct++;
		}
		// if button has NO surrounding bombs
		else if (myButtons[x][y].isEnabled()){
			myButtons[x][y].setIcon(empty);
			myButtons[x][y].setDisabledIcon(empty);
			myButtons[x][y].setEnabled( false );
			Correct++;

      //add other valid cells to stack to be ran
			if (validPos(x-1,y) && (myButtons[x-1][y].isEnabled())) { myStack.push(myButtons[x-1][y]); }
			if (validPos(x-1,y-1) && (myButtons[x-1][y-1].isEnabled())) { myStack.push(myButtons[x-1][y-1]); }
			if (validPos(x-1,y+1) && (myButtons[x-1][y+1].isEnabled())) { myStack.push(myButtons[x-1][y+1]); }

			if (validPos(x,y-1) && (myButtons[x][y-1].isEnabled())) { myStack.push(myButtons[x][y-1]); }
			if (validPos(x,y+1) && (myButtons[x][y+1].isEnabled())) { myStack.push(myButtons[x][y+1]); }

			if (validPos(x+1,y) && (myButtons[x+1][y].isEnabled())) { myStack.push(myButtons[x+1][y]); }
			if (validPos(x+1,y-1) &&  (myButtons[x+1][y-1].isEnabled())) { myStack.push(myButtons[x+1][y-1]); }
			if (validPos(x+1,y+1) && (myButtons[x+1][y+1].isEnabled())) { myStack.push(myButtons[x+1][y+1]); }
		}

		if (Correct == TotBut-BombNum && popStack.isRunning()) { showWin( ); } // fi selected all correct cells, they win
  }

  //************************************************************
	// This function reveals the board to the user and tells them they have lost the
	//  game because they hit a bomb.
  //
  public void HitBomb (int x, int y) {
		looseM.play();
		popStack.stop();                // stop timer
		for(int i=0;i<Rows;i++) {       //all rows
			for(int j=0;j<Columns;j++) {  //all columns
				if (myButtons[i][j].isEnabled()) { //if need to be flipped
					if ((i==x) && (j==y)) { mytemppic = bombclicked; } //if the bomb they clicked
					else if (myButtons[i][j].getBomb() == 1) { mytemppic = bomb; } //if a bomb
					else if ((myButtons[i][j].getFlag() == 1) && (myButtons[i][j].getBomb() == 0)) { mytemppic = badflag; } //if a flag with no bomb
					else if (myButtons[i][j].getShowNum() == 0) { mytemppic = empty; } //no number
					else { mytemppic = num[myButtons[i][j].getShowNum()-1]; }

          //disable and set pic
					myButtons[i][j].setIcon( mytemppic );
					myButtons[i][j].setDisabledIcon(mytemppic);
					myButtons[i][j].setEnabled( false );
		    }
			}
		}
		JOptionPane.showMessageDialog(null,
		"Sorry... You Hit a Bomb and Lost the Game! \n\n* Click Restart to Launch the Game with current specs." +
		"\n* Change the rows, columns, or bombs to adjust difficulty, then Restart.",
		"You Loose.",1);
  }

  //************************************************************
	// This function reveals the board to the user and tells them they won the game!
  //
  public void showWin ( ) {
		winM.play();
		popStack.stop();                // stop timer
		for(int i=0;i<Rows;i++) {       //all rows
			for(int j=0;j<Columns;j++) {  //all columns
				if (myButtons[i][j].isEnabled()) {  //if need to be flipped
					if (myButtons[i][j].getBomb() == 1) { mytemppic = bomb; } //if a bomb
					else if (myButtons[i][j].getShowNum() == 0) { mytemppic = empty; } //no number
					else { mytemppic = num[myButtons[i][j].getShowNum()-1]; }

					//disable and set pic
					myButtons[i][j].setIcon( mytemppic );
					myButtons[i][j].setDisabledIcon(mytemppic);
					myButtons[i][j].setEnabled( false );
				}
			}
		}

		JOptionPane.showMessageDialog(null,
		"CONGRADULATIONS!... YOU WIN!! \n\n* Click Restart to Launch the Game with current specs." +
		"\n* Change the rows, columns, or bombs to adjust difficulty, then Restart.",
		"You Win!",1);
  }



  //************************************************************
	// This function simply re-randomizes the array of bombs, enables the buttons, and
	//  sets their pic to the cover pic
  //
  public void ResetBoard ( ) {
    Correct=0;  // how many correct
    popStack.start();                       // start timer
		BombRow = new Randomize(Rows,Columns);  // random array to put bombs (row)
		BombRow.setPointer(0);                  // move to beginning
		BombCol = new Randomize(Columns,Rows);  // random array to put bombs (column)
		BombCol.setPointer(0);                  // move to beginning

		for(int i=0;i<Rows;i++) {        //all rows
			for(int j=0;j<Columns;j++) {   //all columns
				//reset button values
				myButtons[i][j].setShowNum(0);
				myButtons[i][j].setBomb(0);
				myButtons[i][j].setFlag(0);
				myButtons[i][j].setIcon( cover );
				myButtons[i][j].setDisabledIcon( cover );
				if (!(myButtons[i][j].isEnabled())) { myButtons[i][j].setEnabled( true ); }
			}
		}

		for (int i=0;i<BombNum;i++) {	setBombpos( );} // place bombs

		SetBombInt(); // set int for surrounding bombs

  }



  //************************************************************
	// This function simply re-randomizes the array of bombs, enables the buttons, and
	//  sets their pic to the cover pic
  //
  public void setBombpos ( ) {
		if (BombRow.EOF( )) { BombRow.setPointer(1); } //if end, start at 1
		if (BombCol.EOF( )) { BombCol.setPointer(0); } //if end, start at 0

		//already has a bomb
		if (myButtons[BombRow.getElement()][BombCol.getElement()].getBomb( ) == 1) {
			BombRow.Next(); //move pointer
		  BombCol.Next(); //move pointer
			setBombpos( );
		}

		//needs bomb
		else {
			myButtons[BombRow.getElement( )][BombCol.getElement( )].setBomb( 1 ); // set bomb
			BombRow.Next(); //move pointer
			BombCol.Next(); //move pointer
		}
	}



  //************************************************************
	// This function returns true if (x,y) is a valid position on board, false otherwise
  //
	public boolean validPos (int x, int y) {
		if ( ((x) >= 0) && ((x) <= (Rows-1)) && ((y) >= 0) && ((y) <= (Columns-1)) ) { return true; }
		else { return false; }
	}


} //end board class
