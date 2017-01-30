package com.example.explicitintent2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ActivityOne extends Activity {
	  
	/** Called when the activity is first created. */

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    
        Button button1=(Button)findViewById(R.id.Button01);
	    
	    button1.setOnClickListener(new OnClickListener(){
	     public void onClick(View view) {
	      Intent i = new Intent(getApplicationContext(), ActivityTwo.class);
	      i.putExtra("Value1", "Android By Surendra");
	      i.putExtra("Value2", "Simple Tutorial");
	      // Set the request code to any code you like, you can identify the
	      // callback via this code
	      startActivity(i);
	     }
	     });

	  }

	  	 
	} 