package com.example.snake;

public class Snake {
	 box headbox,tailbox,maze[][];
	 int direction,sizex=5,sizey=5,hx,hy;
	 
	public Snake(int x,int y)
{sizex=x;
sizey=y;
	maze=new box[sizex][sizey];
for(int i=0;i<5;i++)
	for(int j=0;j<5;j++)
	maze[i][j]=new box(i,j,0);
headbox=maze[sizex/2][sizey/2];
tailbox=headbox;

		}


public void movesnake()
{
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
	
	
	if(hx==sizex)
		hx=0;
	else if(hx==-1)
		hx=sizex-1;
	if(hy==sizey)
		hy=0;
	else if(hy==-1)
		hy=sizey-1;
	box temp=new box(hx,hy,1);
	
	headbox.head=temp;
	headbox=temp;
	tailbox.status=0;
tailbox=tailbox.head;

	
	
}




}
