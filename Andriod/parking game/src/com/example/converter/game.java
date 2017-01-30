package com.example.converter;

public class game {
	float arrx[],arry[];
	public game()
	{
		arrx=new float[100000];
		arry=new float[100000];
             	
       
	}
	public int level1(int x,int y)
	{
		arrx[0]=x/2;arry[0]=0;
		arrx[1]=x;arry[1]=y/3;
		arrx[2]=0;arry[2]=2*y/3;
		arrx[3]=x/4;arry[3]=1000;
		arrx[4]=(x/2+3);arry[4]=2*y/3+2;
		arrx[5]=x;arry[5]=y;
		return 6;
	}

}
