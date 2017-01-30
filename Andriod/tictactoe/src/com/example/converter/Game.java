package com.example.converter;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Game extends Activity {
	public int c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main_game);
        
        
        
        
        View.OnClickListener mylist;
        
        final TicTacToe mytic=new TicTacToe();
        final Button b1=(Button)findViewById(R.id.button1);
        final Button b2=(Button)findViewById(R.id.button2);
        final Button b3=(Button)findViewById(R.id.button3);
        final Button b4=(Button)findViewById(R.id.button4);
        final Button b5=(Button)findViewById(R.id.button5);
        final Button b6=(Button)findViewById(R.id.button6);
        final Button b7=(Button)findViewById(R.id.button7);
        final Button b8=(Button)findViewById(R.id.button8);
        final Button b9=(Button)findViewById(R.id.button9);
        final Button b10=(Button)findViewById(R.id.button10);
        final Button b11=(Button)findViewById(R.id.button11);
        final Button b12=(Button)findViewById(R.id.button12);
        final EditText e1=(EditText)findViewById(R.id.editText1);
        
        final MediaPlayer mymusic=MediaPlayer.create(Game.this, R.raw.music);
			

		
        
        mylist=new View.OnClickListener() {
			
			@Override
			public void onClick(View data) {
				
				if(data.getId()==R.id.button1)
				{b1.setText("X");
				
				mytic.entry(0, 1);

				
				{
				int b=mytic.check_winner(1);
				if(b==1)
				e1.setText("user WON !!");	
				else 
				{
				 b=mytic.cpu_move();
					c++;	
				if(b==0)
					b1.setText("O");
				else if(b==1)
				b2.setText("O"); 
				else if(b==2)
					b3.setText("O"); 
				else if(b==3)
					b4.setText("O"); 
				else if(b==4)
					b5.setText("O"); 
				else if(b==5)
					b6.setText("O"); 
				else if(b==6)
					b7.setText("O"); 
				else if(b==7)
					b8.setText("O"); 
				else if(b==8)
					b9.setText("O"); 
					
				
				
				
				
				b=mytic.check_winner(2);
					if(b==2)
					e1.setText("cpu WON !!");	
				}	
				}
				}
				if(data.getId()==R.id.button2)
				{b2.setText("X");
				
				mytic.entry(1, 1);
				
				{
				int b=mytic.check_winner(1);
				if(b==1)
				e1.setText("user WON !!");	
				else 
				{
				 b=mytic.cpu_move();
					c++;	
				if(b==0)
					b1.setText("O");
				else if(b==1)
				b2.setText("O"); 
				else if(b==2)
					b3.setText("O"); 
				else if(b==3)
					b4.setText("O"); 
				else if(b==4)
					b5.setText("O"); 
				else if(b==5)
					b6.setText("O"); 
				else if(b==6)
					b7.setText("O"); 
				else if(b==7)
					b8.setText("O"); 
				else if(b==8)
					b9.setText("O"); 
					
				
				
				
				
				b=mytic.check_winner(2);
					if(b==2)
					e1.setText("cpu WON !!");	
				}	
				}
				
				}
				if(data.getId()==R.id.button3)
				{b3.setText("X");
				mytic.entry(2, 1);
				c=mytic.checkcount();
				if(c==7)
					e1.setText("Game Over press RESET");
				else
				{
				int b=mytic.check_winner(1);
				if(b==1)
				e1.setText("user WON !!");	
				else 
				{
				 b=mytic.cpu_move();
					c++;	
				if(b==0)
					b1.setText("O");
				else if(b==1)
				b2.setText("O"); 
				else if(b==2)
					b3.setText("O"); 
				else if(b==3)
					b4.setText("O"); 
				else if(b==4)
					b5.setText("O"); 
				else if(b==5)
					b6.setText("O"); 
				else if(b==6)
					b7.setText("O"); 
				else if(b==7)
					b8.setText("O"); 
				else if(b==8)
					b9.setText("O"); 
					
				
				
				
				
				b=mytic.check_winner(2);
					if(b==2)
					e1.setText("cpu WON !!");	
				}	
				}
				}
				if(data.getId()==R.id.button4)
				{b4.setText("X");
				mytic.entry(3, 1);
				c=mytic.checkcount();
			{
				int b=mytic.check_winner(1);
				if(b==1)
				e1.setText("user WON !!");	
				else 
				{
				 b=mytic.cpu_move();
					c++;	
				if(b==0)
					b1.setText("O");
				else if(b==1)
				b2.setText("O"); 
				else if(b==2)
					b3.setText("O"); 
				else if(b==3)
					b4.setText("O"); 
				else if(b==4)
					b5.setText("O"); 
				else if(b==5)
					b6.setText("O"); 
				else if(b==6)
					b7.setText("O"); 
				else if(b==7)
					b8.setText("O"); 
				else if(b==8)
					b9.setText("O"); 
					
				
				
				
				
				b=mytic.check_winner(2);
					if(b==2)
					e1.setText("cpu WON !!");	
				}	
				}
				}
				if(data.getId()==R.id.button5)
				{b5.setText("X");
				mytic.entry(4, 1);
				c=mytic.checkcount();
			
				{
				int b=mytic.check_winner(1);
				if(b==1)
				e1.setText("user WON !!");	
				else 
				{
				 b=mytic.cpu_move();
					c++;	
				if(b==0)
					b1.setText("O");
				else if(b==1)
				b2.setText("O"); 
				else if(b==2)
					b3.setText("O"); 
				else if(b==3)
					b4.setText("O"); 
				else if(b==4)
					b5.setText("O"); 
				else if(b==5)
					b6.setText("O"); 
				else if(b==6)
					b7.setText("O"); 
				else if(b==7)
					b8.setText("O"); 
				else if(b==8)
					b9.setText("O"); 
					
				
				
				
				
				b=mytic.check_winner(2);
					if(b==2)
					e1.setText("cpu WON !!");	
				}	
				}
				}
				if(data.getId()==R.id.button6)
				{b6.setText("X");
				mytic.entry(5, 1);
				
				{
				int b=mytic.check_winner(1);
				if(b==1)
				e1.setText("user WON !!");	
				else 
				{
				 b=mytic.cpu_move();
					c++;	
				if(b==0)
					b1.setText("O");
				else if(b==1)
				b2.setText("O"); 
				else if(b==2)
					b3.setText("O"); 
				else if(b==3)
					b4.setText("O"); 
				else if(b==4)
					b5.setText("O"); 
				else if(b==5)
					b6.setText("O"); 
				else if(b==6)
					b7.setText("O"); 
				else if(b==7)
					b8.setText("O"); 
				else if(b==8)
					b9.setText("O"); 
					
				
				
				
				
				b=mytic.check_winner(2);
					if(b==2)
					e1.setText("cpu WON !!");	
				}
				}
				}
				if(data.getId()==R.id.button7)
				{b7.setText("X");
				mytic.entry(6, 1);
				
				{
				int b=mytic.check_winner(1);
				if(b==1)
				e1.setText("user WON !!");	
				else 
				{
				 b=mytic.cpu_move();
					c++;	
				if(b==0)
					b1.setText("O");
				else if(b==1)
				b2.setText("O"); 
				else if(b==2)
					b3.setText("O"); 
				else if(b==3)
					b4.setText("O"); 
				else if(b==4)
					b5.setText("O"); 
				else if(b==5)
					b6.setText("O"); 
				else if(b==6)
					b7.setText("O"); 
				else if(b==7)
					b8.setText("O"); 
				else if(b==8)
					b9.setText("O"); 
					
				
				
				
				
				b=mytic.check_winner(2);
					if(b==2)
					e1.setText("cpu WON !!");	
				}
				}
				}
				if(data.getId()==R.id.button8)
				{b8.setText("X");
				mytic.entry(7, 1);
				
				{
				int b=mytic.check_winner(1);
				if(b==1)
				e1.setText("user WON !!");	
				else 
				{
				 b=mytic.cpu_move();
					c++;	
				if(b==0)
					b1.setText("O");
				else if(b==1)
				b2.setText("O"); 
				else if(b==2)
					b3.setText("O"); 
				else if(b==3)
					b4.setText("O"); 
				else if(b==4)
					b5.setText("O"); 
				else if(b==5)
					b6.setText("O"); 
				else if(b==6)
					b7.setText("O"); 
				else if(b==7)
					b8.setText("O"); 
				else if(b==8)
					b9.setText("O"); 
					
				
				
				
				
				b=mytic.check_winner(2);
					if(b==2)
					e1.setText("cpu WON !!");	
				}	
				}
				}
				if(data.getId()==R.id.button9)
				{b9.setText("X");
				mytic.entry(8, 1);
				
				{
				
				
				int b=mytic.check_winner(1);
				if(b==1)
				e1.setText("user WON !!");	
				else 
				{
				 b=mytic.cpu_move();
						c++;
				if(b==0)
					b1.setText("O");
				else if(b==1)
				b2.setText("O"); 
				else if(b==2)
					b3.setText("O"); 
				else if(b==3)
					b4.setText("O"); 
				
				else if(b==4)
					b5.setText("O"); 
				else if(b==5)
					b6.setText("O"); 
				else if(b==6)
					b7.setText("O"); 
				else if(b==7)
					b8.setText("O"); 
				else if(b==8)
					b9.setText("O"); 
					
				
				
				
				
				b=mytic.check_winner(2);
					if(b==2)
					e1.setText("cpu WON !!");	
				}	
				}
				}
				
				
				
				if(data.getId()==R.id.button10)
					{
					mytic.reset();
					b1.setText("");
					b2.setText("");
					b3.setText("");
					b4.setText("");
					b5.setText("");
					b6.setText("");
					b7.setText("");
					b8.setText("");
					b9.setText("");
					e1.setText("");
					}
				if(data.getId()==R.id.button11)
				{
					mymusic.start();
				}
				if(data.getId()==R.id.button12)
				{
					mymusic.stop();
				}
					
			}
			
			
		
			
		};
		
		b1.setOnClickListener(mylist);
		b2.setOnClickListener(mylist);
		b3.setOnClickListener(mylist);
		b4.setOnClickListener(mylist);
		b5.setOnClickListener(mylist);
		b6.setOnClickListener(mylist);
		b7.setOnClickListener(mylist);
		b8.setOnClickListener(mylist);
		b9.setOnClickListener(mylist);
		b10.setOnClickListener(mylist);
		
		b11.setOnClickListener(mylist);
		b12.setOnClickListener(mylist);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
