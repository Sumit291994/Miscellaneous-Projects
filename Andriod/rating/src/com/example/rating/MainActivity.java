package com.example.rating;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends Activity {
	RatingBar ratingbar1;
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButtonClick();
	}

	public void addListenerOnButtonClick(){
		ratingbar1=(RatingBar)findViewById(R.id.ratingBar1);
		button=(Button)findViewById(R.id.button1);
		
		button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				String rating=String.valueOf(ratingbar1.getRating());
				Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
			}
			
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
