package com.example.serviceexampleaudio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	 Button buttonStart, buttonStop,buttonNext;

	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);

	  buttonStart = (Button) findViewById(R.id.buttonStart);
	  buttonStop = (Button) findViewById(R.id.buttonStop);
	  buttonNext = (Button) findViewById(R.id.buttonNext);

	  buttonStart.setOnClickListener(this);
	  buttonStop.setOnClickListener(this);
	  buttonNext.setOnClickListener(this);
	 }

	 public void onClick(View src) {
	  switch (src.getId()) {
	  case R.id.buttonStart:
	   startService(new Intent(this, MyService.class));
	   break;
	  case R.id.buttonStop:
	   stopService(new Intent(this, MyService.class));
	   break;
	  case R.id.buttonNext:
	   Intent intent=new Intent(this,NextPage.class);
	   startActivity(intent);
	   break;
	  }
	 }
}
