package com.example.spinner;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements
AdapterView.OnItemSelectedListener {

	String[] country = { "India", "USA", "China", "Japan", "Other",  };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Spinner spin = (Spinner) findViewById(R.id.spinner1);
		spin.setOnItemSelectedListener(this);
		
		ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spin.setAdapter(aa);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
		Toast.makeText(getApplicationContext(),country[position] ,Toast.LENGTH_LONG).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
