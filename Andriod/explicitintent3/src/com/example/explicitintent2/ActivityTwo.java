package com.example.explicitintent2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends Activity {

  
/** Called when the activity is first created. */

  @Override
  public void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    
    TextView tv=new TextView(this);
    tv.setText("second activity");
    setContentView(R.layout.activity_two);
   
    Bundle extras = getIntent().getExtras();
    String value1 = extras.getString("Value1");
    String value2 = extras.getString("Value2");
    
    Toast.makeText(getApplicationContext(),"Values are:\n First value: "+value1+"\n Second Value: "+value2,Toast.LENGTH_LONG).show();
    
    Button button1=(Button)findViewById(R.id.Button01);
    
    button1.setOnClickListener(new OnClickListener(){
    	public void onClick(View view) {
    	    Intent i = new Intent(getApplicationContext(), ActivityOne.class);
    	    startActivity(i);
    	  }
    });
  }
} 