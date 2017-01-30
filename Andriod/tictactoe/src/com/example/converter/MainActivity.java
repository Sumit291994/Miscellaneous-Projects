package com.example.converter;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final Button b1=(Button)findViewById(R.id.button1);
       
       
       b1.setOnClickListener(
    		   
    		   new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					 Thread newthtead =new Thread(){
				        	public void run(){
			        						        	
				        		Intent intent = new Intent("android.intent.action.game");
				        		startActivity(intent);
				        		
				        		
				        	 }
				        };
				        
				        newthtead.start();
				        
					
				}
			}
    		   );
       
    }
}
