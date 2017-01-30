package com.example.chatapp00;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainpage extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainpage);
		 final Button b1=(Button)findViewById(R.id.button1);
		 final Button b2=(Button)findViewById(R.id.button2);
		 View.OnClickListener mylist;
		 
		 
		 mylist=new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				if(arg0.getId()==R.id.button1)
				{
					Intent intent1=new Intent("android.intent.action.internet");
					startActivity(intent1);
				}
				
				
				if(arg0.getId()==R.id.button2)
				{
				
					Intent intent2=new Intent("android.intent.action.bluetooth");
					startActivity(intent2);
				}
				
				
				
			}
		};
		
		b1.setOnClickListener(mylist);
		b2.setOnClickListener(mylist);
			
	}

}
