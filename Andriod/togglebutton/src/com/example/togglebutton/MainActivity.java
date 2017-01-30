package com.example.togglebutton;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	private ToggleButton toggleButton1, toggleButton2;
	  private Button buttonSubmit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addListenerOnButtonClick();
	}
	public void addListenerOnButtonClick(){
		toggleButton1=(ToggleButton)findViewById(R.id.toggleButton1);
		toggleButton2=(ToggleButton)findViewById(R.id.toggleButton2);
		buttonSubmit=(Button)findViewById(R.id.button1);
		
		buttonSubmit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				StringBuilder result = new StringBuilder();
				   result.append("ToggleButton1 : ").append(toggleButton1.getText());
				   result.append("\nToggleButton2 : ").append(toggleButton2.getText());
		 
				Toast.makeText(getApplicationContext(), result.toString(),Toast.LENGTH_LONG).show();
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
