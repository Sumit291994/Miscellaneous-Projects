package com.example.snake;

//import  com.example.snake.MainActivity.*;

public class Snake {
	 box headbox,tailbox,maze[][];
	 int direction,sizex,sizey,hx,hy,ii,jj,a,settoast=0;
	 
	public Snake(int x,int y)
{
		direction=1;
		sizex=x;
		sizey=y;
	maze=new box[sizex][sizey];
for(int i=0;i<sizex;i++)
	for(int j=0;j<sizey;j++)
	{
		maze[i][j]=new box(i,j,0);
		}

headbox=maze[sizex/2][sizey/2];
headbox.status=1;
tailbox=headbox;

		}


public int movesnake()
{//this.ii=ii;
//this.jj=jj;
	hx=headbox.dx;
	hy=headbox.dy;
	if(direction==1)
	hx++;
	else if(direction==2)
		hx--;
	else if(direction==3)
		hy--;
	else if(direction==4)
		hy++;
	
	
	if(hx==sizex)hx=0;
	if(hx==-1)hx=sizex-1;
	if(hy==sizey)hy=0;
	if(hy==-1)hy=sizey-1;
	
	box temp=maze[hx][hy];
	if(temp.status==1)
		settoast=1;
	else
	{temp.status=1;settoast=0;}
	headbox.head=temp;
	headbox=temp;
	
	

		if(headbox.dx==ii&&headbox.dy==jj)
	{a=1;
	
	}
	else
	{
		tailbox.status=0;tailbox=tailbox.head;
		a=0;}
return a;
}

public void fruitx(int sx)
{
	while(true)
	{
		this.ii=(int)(Math.random()*10);

if(ii<sx)
	break;
	}

	}
	

public void fruity(int sy)
	{
		while(true)
		{
			 
	this.jj=(int)(Math.random()*10);
			//this.jj=sizex/2;
	if(jj<sy)
		break;
		}

	}
}
