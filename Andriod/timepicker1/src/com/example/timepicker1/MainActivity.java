package com.example.timepicker1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView textview1;
	TimePicker timepicker1;
	Button changetime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textview1=(TextView)findViewById(R.id.textView1);
		timepicker1=(TimePicker)findViewById(R.id.timePicker1);
		//Uncomment the below line of code for 24 hour view
		timepicker1.setIs24HourView(true);
		changetime=(Button)findViewById(R.id.button1);
		
	    textview1.setText(getCurrentTime());
		
		changetime.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view) {
				 textview1.setText(getCurrentTime());
			}
		});
		
	}

	public String getCurrentTime(){
		String currentTime="Current Time: "+timepicker1.getCurrentHour()+":"+timepicker1.getCurrentMinute();
	   	return currentTime;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
