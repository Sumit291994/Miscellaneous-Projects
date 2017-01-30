Author: Mike Dattilo
Program: Minesweeper
Teacher: Dr. Seales


Running the program:
	- To compile this program, simply unzip the contents into the same directory and type "javac Bombs.java"
	- After compiled, run by typing "java Bombs" (default settings).
	- You can also run for preferred number of rows columns and bombs by typing "java Bombs rows columns bombs"
	

Game Play:
	- Rules are the same as regular Minesweeper
	- You win by revealing all squares that do not contain a bomb
	- You loose if you hit a bomb.
	- You can mark "potential" bombs by right clicking on the square.
	- Restart anytime to start over with current specs.
	- Change the number of rows, columns, or bombs in the game by adjusting the spinners at the bottom and restarting.
	- Click the Information button furing the game for instructions on game play.


File Purpose/Design:
  - Bombs.java
		This class is the "driver" class for the program.  It initializes the game by creating  
		a new instance of the other classes.  This class acts as the interaction point between
		other classes as well.  Values can be passed back to this class, then passed into another
		class.  Upon a restart where the rows, columns or bombs have changed, this class removes the
		current elements from the container and adds new ones with correct properties.
  
  - BombButton.java
  	This class extends the JButton class.  I have added some integers to this class so I can
  	get the x and y coordinates, how many bombs surround it, if it has a bomb, and if it has a flag.
  	It contains accessors and mutators the other classes use.
  	
  - Board.java
		This class is the "brains" of the game. It will initially make an array of BombButton (above)
		which will act as the minesweeper cells for the game.  Any actions on the buttons are handled here.
		It contains a mouselistener and actionlistener for each button (for left and right clicks respectively).
		When a button is clicked, I first check to see if it is a bomb.  If so I show the board and tell them
		they lost the game.  Otherwise, I send it to the ClearAlg(x,y) function.  This function will only flip
		the one cell if it contains a number in it.  Otherwise, it will add the valid, unflipped surrounding 8 
		cells to a stack to be ran.  Originally I just had it do a recurrsive call, but the heap ran out of 
		storage for the 100x100 case.  When the number of cells clears = totalcells - bombs, I show the board
		and tell them they won.  The reset function is when no parameters change (rows, columns, bombs).  Here I
		simply reset the defaults, make different random arrays to place bombs, enable buttons, and show cover
		picture.  If parameters have changed, the driver will destroy this instance and make another instance of
		the board will different parameters.
  
  - MenuTop.java
		This class contains only the restart button and instuctions button.  The other important aspect is the
		integer I named Resize.  If any values in the MenuBottom class change, this value is set to 1 instead
		of 0.  That means when the restart button is hit, it tells the driver it needs to creat new instances 
		of each class instead of resetting them.
  
  - MenuBottom.java
	 	This class contains the JSpinners to show or change the value of rows, columns, and bombs.  It will only
	 	allow the amount of bombs to be 1/2 the number of rows*columns.  If any of these three values change,
	 	a bit is sent to the MenuTop class to tell it on restart, the board needs to be resized.
  
  - Randomize.java
	 	This class is what I use to make my "randomized arrays".  It takes 2 arguements.  The first is the number 
	 	of elements you wish to appear.  So if were 13, it would create numbers 0-12.  The second number is how
	 	many times you want these numbers to repeat.  So if 1 were passed in, it would only make numbers 0-12
	 	in a random order.  But if 2 were passed in, you would have two 0's, two 1's.... two 12's in a random order.
	 	This class also includes helpful functions such as next, which returns the next value of the array.  Setpointer
	 	will set the current position of the array to whatever you pass in.  You can also get the current element, if end 
	 	of array, and a string of the array if desired.