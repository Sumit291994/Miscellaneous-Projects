// Java core packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;

public class BombButton extends JButton {

   private int row,column,bomb,ShowNum,flag;

   // set up basic button
   public BombButton(int r,int c)
   {
		 	 row = r;
		 	 column = c;
		 	 bomb = 0;  // defaults to not have a bomb
		 	 flag = 0;  // defaults to not have a flag
		 	 ShowNum = 0; // defaults to no bombs surrounding
   }

	 //************************ Accessors: *************************

	 // Returns row element
	 public int getRow(){ return row;}

   // Returns column element
	 public int getColumn(){ return column;}

	 // Returns bomb element
	 public int getBomb(){ return bomb;}

	 // Returns flag element
	 public int getFlag(){ return flag;}

   // Returns ShowNum element
	 public int getShowNum(){ return ShowNum;}


	 //************************ Mutators: *************************

	 // Sets row element
	 public void setRow(int somerow){row = somerow;}

   // Sets column element
	 public void setColumn(int somecol){column = somecol;}

   // Sets bomb element
	 public void setBomb(int somebomb){bomb = somebomb;}

	 // Sets flag element
	 public void setFlag(int someflag){flag = someflag;}

   // Sets ShowNum element
	 public void setShowNum(int somenum){ShowNum = somenum;}


}  // end class BombButton