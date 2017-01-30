import java.util.Random;

// Purpose: To Randomize several types of arrays
public class Randomize
{
	private int ARrandom[];  //array to store numbers
	private Random RanNum = new Random();  //declare a random number object
	private int MaxNum=0,Recurr=1,Total;
	private int pos=0;  //variable will store the current position in the array
	private int recAR[]; //arrays that tell is position is filled and if numbers duplicated

	//************************* Constructors: *******************************

	// Get a random array of the size you pass in
	public Randomize(int nMax) { LoadMe(nMax,1); }


	// Get random array of nMax size, duplicate nTimes times
	public Randomize(int nMax,int nTimes)	{ LoadMe(nMax,nTimes);	}



	//************************************************************
	// This function loops through and creates an Array containing
	//  MaxNum amount of elements [0->(MaxNum-1)] and repeats them
	//  throughout the array Recurr times.  The elements are "randomly"
	//  selected abd placed into the arry to create a "random arry"
	//
	private void LoadMe(int nMax,int nTimes)
	{
		int placer;                 //hold position
		pos=0;                      //where we are in array
		MaxNum = nMax;              //number of unqie elements
		Recurr = nTimes;            //how many times we repeat elements
		Total = MaxNum*Recurr;      //total elements in array
		recAR = new int [MaxNum];   //array to tell if element has been used enough/too much
		ARrandom = new int [Total]; //array to hold our random numbers

		for (int i=0; i < MaxNum; i++) {  //reset array to duplicate Recurr times
			recAR[i] = 0;
		}

		for (int i=0; i < Total; i++) {
			placer = getran();                        // get random number not already taken
			ARrandom[i] = placer;                     // set random number
			recAR[placer]++;                          // increment the number selected
		}

  }


	//************************************************************
	// This function return a random number if that number has
	//  not already been used Recurr times
	//
	private int getran () {
		 int myrannum;
		 myrannum = (int)Math.round((Math.random())*(MaxNum-1));  //get random number
		 while (recAR[myrannum] >= Recurr)                     //number used too much
				myrannum = getran();
		 return myrannum;
	}

    //************************ Accessors: *************************

    //Gets a specific element out of the shuffled array
		public int getElement(int i){return ARrandom[i];}

		//Gets the element pointed to by the pointer
    public int getElement(){return ARrandom[pos];}

    //returns the entire array generated
    public int[] getArray(){return ARrandom;}



    //************************ Mutators: *************************

    //Increments the pointer
    public void Next(){pos++;}

    //decrements the pointer
    public void Prev(){pos--;}

    //sets the pointer
    public void setPointer(int i){pos = i;}



    //************************ Helpers: *************************

    // prints every element in the list
		public String toString(){
			String output = new String();

			for (int i=0;i<Total;i++)
				output += ARrandom[i] + ",";

			return output;
		}

		//return true if the pointer has pased the end of the array
		public boolean EOF(){return (pos>=Total);}

}

