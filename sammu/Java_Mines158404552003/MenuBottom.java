import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MenuBottom extends JPanel implements ChangeListener {

	private JLabel rows, columns, bombs;
	private Bombs bombsObj;   // Driver
	private JSpinner sprows, spcols, spbombs; // To change rows, cols, bombs
	private SpinnerNumberModel mrows, mcols, mbombs; //set up how to scroll

	public MenuBottom(int R,int C,int B,Bombs b) {

	  bombsObj = b;  // pointer to parent

		setLayout(new FlowLayout());

    // make the rows JLabel and JSpinner
    rows = new JLabel("Rows:");
		add(rows);
		mrows = new SpinnerNumberModel(R, 5, 100, 5); //start at 5, can go to 100
		sprows = new JSpinner(mrows);
		sprows.addChangeListener(this);
		add(sprows);

		// make the columns JLabel and JSpinner
		columns = new JLabel("Cols:");
		add(columns);
		mcols = new SpinnerNumberModel(C, 5, 100, 5); //start at 5, can go to 100
		spcols = new JSpinner(mcols);
		spcols.addChangeListener(this);
		add(spcols);

		// make the bombs JLabel and JSpinner
		bombs = new JLabel("Bombs:");
		add(bombs);
		// this spinner model starts at 0 and goes to half of rows*columns
		mbombs = new SpinnerNumberModel(B, 1, ((mrows.getNumber().intValue()*mcols.getNumber().intValue())/2), 1);
		spbombs = new JSpinner(mbombs);
		spbombs.addChangeListener(this);
		add(spbombs);

  }

  //if JSpinners are changed, react accordingly
	public void stateChanged(ChangeEvent  e ) {
    int tmpint;

		// rows or columns change
		if (e.getSource() == sprows || e.getSource() == spcols) {
		  tmpint = 	mbombs.getNumber().intValue(); // tmp to ck if bombs too big

			if (tmpint > ((mrows.getNumber().intValue()*mcols.getNumber().intValue())/2)) { //bombs too big
				tmpint = ((mrows.getNumber().intValue()*mcols.getNumber().intValue())/2); // make bombs smaller
			}

      //make bombs only go up to 1/2 rows*columns
			mbombs = new SpinnerNumberModel(tmpint, 1, ((mrows.getNumber().intValue()*mcols.getNumber().intValue())/2), 1);
			spbombs.setModel(mbombs);
			bombsObj.setResize(1);  // have to create new game on restart
	  }

	  //bombs change
	  else if (e.getSource() == spbombs) {
			bombsObj.setResize(1);  // have to create new game on restart
	  }
	}

  //************************ Accessors: *************************

  // Return JSpinner row value
  public int getRows ( ) { return mrows.getNumber().intValue(); }

  // Return JSpinner column value
  public int getCols ( ) { return mcols.getNumber().intValue(); }

  // Return JSpinner bomb value
  public int getBombs ( ) { return mbombs.getNumber().intValue(); }



}