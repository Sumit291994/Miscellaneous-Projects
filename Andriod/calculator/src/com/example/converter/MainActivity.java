package com.example.converter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	public int i=0,a=0,b=0,c=0,op=0,j,k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        View.OnClickListener mylist;
		final EditText e1=(EditText)findViewById(R.id.editText1);
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
		
		
		
		mylist=new View.OnClickListener() {
			
			@Override
			public void onClick(View data) {
				if(data.getId()==R.id.button1)
				a=a*10+1;
				if(data.getId()==R.id.button2)
					a=a*10+2;
			    if(data.getId()==R.id.button3)
				a=a*10+3;
				if(data.getId()==R.id.button4)
				a=a*10+4;
				if(data.getId()==R.id.button5)
				a=a*10+5;
				if(data.getId()==R.id.button6)
				a=a*10+6;
				if(data.getId()==R.id.button7)
				a=a*10+7;
				if(data.getId()==R.id.button8)
				a=a*10+8;
				if(data.getId()==R.id.button9)
				a=a*10+9;
				if(data.getId()==R.id.button10)
				a=a*10;
				
				e1.setText(String.valueOf(a));
				
				if(data.getId()==R.id.button11)
				{
				e1.setText("+");c=c+a;a=0;
				}
				
				if(data.getId()==R.id.button12)
				{c=c+a;
				e1.setText("="+String.valueOf(c));
			a=0;
			c=0;
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
