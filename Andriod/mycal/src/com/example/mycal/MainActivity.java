package com.example.mycal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	public int i=0,a=0,b=0,c=0,op=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		View.OnClickListener mylist;
		final EditText e1=(EditText)findViewById(R.id.editText1);
		final Button b1=(Button)findViewById(R.id.button1);
		final Button b2=(Button)findViewById(R.id.button2);
		final Button b3=(Button)findViewById(R.id.button3);
		final Button b4=(Button)findViewById(R.id.button4);
		
		mylist=new View.OnClickListener() {
			
			@Override
			public void onClick(View data) {
				if(data.getId()==R.id.button1)
				{i++;
					if(i==1)
					{
						a=1;
						c=1;
						e1.setText("1");
					}
					else if(i==2)
					{
						if(op==1)
							{b=1;
						c=a+b;}
					}
				}
				
				
				if(data.getId()==R.id.button2)
				{i++;
					if(i==2)
					{
						a=2;
						c=a;
						e1.setText("1");
					}
					else if(i==2)
					{
						if(op==1)
							{b=2;
						c=a+b;}
					}
				}
				
				if(data.getId()==R.id.button3)
				{op=1;
				}
				
				
				if(data.getId()==R.id.button4)
				{e1.setText("="+String.valueOf(c));
				op=0;
				i=0;b=0;
				a=0;
				c=0;
	
				}
				
				
				
				
				
				
				
				
				
			}
		};
		
		
		

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
