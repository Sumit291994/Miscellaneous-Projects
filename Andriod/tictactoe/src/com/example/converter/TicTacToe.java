package com.example.converter;

import java.util.Random;

public class TicTacToe {
	final static int maze[]= new int[9];
	
	
	static int a;
	static int value;
	static int z,o,zz;
	
	int and_player;
	int human_player;
	static int countbox;
	static int box;
	
	
	
	public TicTacToe() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static void entry (int box, int value){
		maze[box]=value;
		countbox++;
		
		
			
	}
	
	public static int check_winner( int value ){
		for(int i=0;i<9;i+=3){
			if((maze[i]==value&&maze[i+1]==value&&maze[i+2]==value)){
				return value;
			}
						
		}
		
		for(int i=0;i<3;i+=1){
			if((maze[i]==value&&maze[i+3]==value&&maze[i+6]==value)){
				return value;
			}
						
		}
		
		
		if((maze[0]==value&&maze[4]==value&&maze[8]==value))
		{
		 return value;
		}
		
		else if((maze[2]==value&&maze[4]==value&&maze[6]==value))
		{
			return value;
		}

		return 0;
	}
	
	
	public static int checkcount (){
	return countbox;
	}
	
	
	
	
	public static void reset (){
		countbox=0;
		for(int i=0;i<9;i++)
		maze[i]=0;
	}
	
	
	 
	public static int cpu_move ()
	{
		if(countbox==1)
		{
			if(box==4)
			{
				while(true)
				{
			 a=(int)(Math.random()*10);
				if(a>=0 && a<9 && a!=4)
				{
					entry(a,2);
					break;
				
				}
				
				
				}
				
			}
			else if(box==0)
			{a=8;
				entry(8,2);
			}
				
			else if(box==2||box==1)
			{a=6;
				entry(6,2);
			}
			else if(box==6||box==3)
			{a=2;
				entry(2,2);
			}
			else if(box==8||box==5||box==7)
			{a=0;
				entry(0,2);
			}
		
			
		
		return a;
				
		}
		if(countbox==3)
		{
			a=-1;
			for(int i=0;i<9;i+=3)
			{z=0;o=0;
				for(int j=i;j<i+3;j++)
				{
					if(maze[j]==0)
						{z++;zz=j;}
					else if(maze[j]==1)
						o++;
				}
				if(z==1 &&o==2)
					{a=zz;break;}
			}
			if(a<0)
			{
				for(int i=0;i<3;i++)
				{z=0;o=0;
					for(int j=i;j<=i+6;j+=3)
					{
						if(maze[j]==0)
						{z++;zz=j;}
					else if(maze[j]==1)
						o++;
					}
					if(z==1 &&o==2)
						{a=zz;break;}
				}
			}
			
			if(a<0)
			{z=0;o=0;
				for(int i=1;i<9;i+=4)
				{
					if(maze[i]==0)
					{z++;zz=i;}
				else if(maze[i]==1)
					o++;
				}
				if(z==1 &&o==2)
				a=zz;
				
			}
			
			if(a<0)
			{z=0;o=0;
				for(int i=2;i<7;i+=2)
				{
					if(maze[i]==0)
					{z++;zz=i;}
				else if(maze[i]==1)
					o++;
				}
				if(z==1 &&o==2)
				a=zz;
				
			}
			
			if(a<0)
			{
				if(maze[6]==0)
					a=6;
				else if(maze[0]==0)
					a=0;
				else if(maze[2]==0)
					a=2;
				else if(maze[8]==0)
					a=8;
			}
			entry(a,2);
			return a;
		}
		
		if(countbox==5||countbox==7)
		{a=-1;
		for(int i=0;i<9;i+=3)
		{z=0;o=0;
			for(int j=i;j<i+3;j++)
			{
				if(maze[j]==0)
					{z++;zz=j;}
				else if(maze[j]==2)
					o++;
			}
			if(z==1 &&o==2)
				{a=zz;break;}
		}
		if(a<0)
		{
			for(int i=0;i<3;i++)
			{z=0;o=0;
				for(int j=i;j<=i+6;j+=3)
				{
					if(maze[j]==0)
					{z++;zz=j;}
				else if(maze[j]==2)
					o++;
				}
				if(z==1 &&o==2)
					{a=zz;break;}
			}
		}
		
		if(a<0)
		{z=0;o=0;
			for(int i=1;i<9;i+=4)
			{
				if(maze[i]==0)
				{z++;zz=i;}
			else if(maze[i]==2)
				o++;
			}
			if(z==1 &&o==2)
			a=zz;
			
		}
		
		if(a<0)
		{z=0;o=0;
			for(int i=2;i<7;i+=2)
			{
				if(maze[i]==0)
				{z++;zz=i;}
			else if(maze[i]==2)
				o++;
			}
			if(z==1 &&o==2)
			a=zz;
			
		}
		
		if(a<0)
		{
			a=-1;
			for(int i=0;i<9;i+=3)
			{z=0;o=0;
				for(int j=i;j<i+3;j++)
				{
					if(maze[j]==0)
						{z++;zz=j;}
					else if(maze[j]==1)
						o++;
				}
				if(z==1 &&o==2)
					{a=zz;break;}
			}
		}
			if(a<0)
			{
				for(int i=0;i<3;i++)
				{z=0;o=0;
					for(int j=i;j<i+6;j+=3)
					{
						if(maze[j]==0)
						{z++;zz=j;}
					else if(maze[j]==1)
						o++;
					}
					if(z==1 &&o==2)
						{a=zz;break;}
				}
			}
			
			if(a<0)
			{z=0;o=0;
				for(int i=1;i<9;i+=4)
				{
					if(maze[i]==0)
					{z++;zz=i;}
				else if(maze[i]==1)
					o++;
				}
				if(z==1 &&o==2)
				a=zz;
				
			}
			
			if(a<0)
			{z=0;o=0;
				for(int i=2;i<7;i+=2)
				{
					if(maze[i]==0)
					{z++;zz=i;}
				else if(maze[i]==1)
					o++;
				}
				if(z==1 &&o==2)
				a=zz;
				
			}
			
			if(a<0)
			{
				if(maze[6]==0)
					a=6;
				else if(maze[0]==0)
					a=0;
				else if(maze[2]==0)
					a=2;
				else if(maze[8]==0)
					a=8;
			}
		entry(a,2);
			return a;
			
		}
		
		return (-1);
		
		
	}
	
}
