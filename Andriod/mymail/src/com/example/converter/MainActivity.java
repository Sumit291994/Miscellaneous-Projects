package com.example.converter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	public int i=0,a=0,b=0,c=0,op=0,j,k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        View.OnClickListener mylist;
		final EditText e1=(EditText)findViewById(R.id.editText1);
		final EditText e2=(EditText)findViewById(R.id.editText2);
		final EditText e3=(EditText)findViewById(R.id.editText3);
		final TextView t1 =(TextView)findViewById(R.id.textView1);
		final TextView t2 =(TextView)findViewById(R.id.textView2);
		final Button b1=(Button)findViewById(R.id.button1);
		
		
		
		
		mylist=new View.OnClickListener() {
			
			@Override
			public void onClick(View data) {
				
				if(data.getId()==R.id.button1)
				{
				Intent myintent =new Intent(android.content.Intent.ACTION_SEND);
				String s1=String.valueOf(e1.getText());
				String s2=String.valueOf(e2.getText());
				String s3=String.valueOf(e3.getText());
				myintent.setType("Plain/Text");
				myintent.putExtra(android.content.Intent.EXTRA_SUBJECT, s2);
				myintent.putExtra(android.content.Intent.EXTRA_TEXT, s3);
				myintent.putExtra(android.content.Intent.EXTRA_EMAIL,s1);
				
				startActivity(myintent);
				
				}
					}
		};
		b1.setOnClickListener(mylist);
		
        
        
  

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
