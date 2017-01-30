import java.io.*;
import java.net.*;

public class MultiThreadedServer
{
	public static void main(String [] args)
	{
		int i=0;
		System.out.println("Server Started. Waiting for connections...");
		try
		{

			ServerSocket s = new ServerSocket(8081);
			for(;;)
			{
				Socket incoming = s.accept();
				System.out.println("New Client Connected with id " + i );
				Thread t = new ThreadedServer(incoming,i);
				i++;
				t.start();
			}
		}
		catch(Exception e)
		{
			System.out.println("Error: " + e);
		}
	}
}

class ThreadedServer extends Thread
{
	Socket incoming;
	int counter;
	public ThreadedServer(Socket i,int c)
	{
		incoming=i;
		counter=c;
	}

	public void run()
	{
		try
		{
			BufferedReader in =new BufferedReader(new InputStreamReader(incoming.getInputStream()));
			PrintWriter out = new PrintWriter(incoming.getOutputStream(), true);

			String line;
			boolean done=false;
			while(!done)
			{
				line=in.readLine();
				if(line.trim().equals("BYE") || line == null)
					done = true;
				else
				{
					out.println("Echo Server Responds: " + line);
					System.out.println("Echo Server Responds: " + line);
				}
			}
			incoming.close();
		}
		catch(Exception e)
		{
			System.out.println("Error: " + e);
		}
	}
}