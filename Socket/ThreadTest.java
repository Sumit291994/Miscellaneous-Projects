import java.io.*;

class AnotherThread extends Thread
{
	
	AnotherThread()
	{
		start();
	}
	
	public void run()
	{
	for(int i=1;i<10;i++)	{
	try {
		System.out.println( i + " 2nd ");
		Thread.sleep(50);
		} catch (Exception e){}
	}
	System.out.println("2nd thread finish");
	}

} 



class ThreadTest
{
	public static void main(String args[])
	{
		AnotherThread at = new AnotherThread();
		//t.start();
		
		for(int i=1;i<10;i++)
		{
		try {
			System.out.println( i + " 1st ");
			Thread.sleep(50);
			} catch (Exception e) {}
		}
		System.out.println("1st thread finish");
	}

}