package com.example.audioplay;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button start,pause,stop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		start=(Button)findViewById(R.id.button1);
		pause=(Button)findViewById(R.id.button2);
		stop=(Button)findViewById(R.id.button3);
		
		final MediaPlayer mp=new MediaPlayer();
		try{
		mp.setDataSource(Environment.getExternalStorageDirectory().getPath()+"/Music/maine.mp3");
		
		mp.prepare();
		}catch(Exception e){e.printStackTrace();}
		
		start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mp.start();
			}
		});
		pause.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mp.pause();
			}
		});
		stop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mp.stop();
			}
		});
	}
}
