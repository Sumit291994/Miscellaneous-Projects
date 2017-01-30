package com.example.bluetooth;


import java.util.Set;

//import com.example.converter.R;

import android.R.array;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat.IntentBuilder;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Build;
import android.preference.PreferenceManager.OnActivityResultListener;

public class MainActivity extends Activity {
public BluetoothAdapter bt;
Set<BluetoothDevice> mydevice;
ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	 ListView l1=(ListView)findViewById(R.id.listView1);
		
		
bt= BluetoothAdapter.getDefaultAdapter();
if (bt==null)
{	Toast.makeText(getApplicationContext(), "NO BLUETOOTH DEVICE FOUND!", 1).show();
finish();
}


else
{	Toast.makeText(getApplicationContext(), "BLUETOOTH DEVICE FOUND!", 1).show();
if(!bt.isEnabled())
{
	Toast.makeText(getApplicationContext(), "BLUETOOTH should b switched on.", 1).show();
	Intent intent =new Intent(bt.ACTION_REQUEST_ENABLE);
	startActivityForResult(intent, 1);
	
}

mydevice=bt.getBondedDevices();
if(mydevice.size()>0)
{
	for(BluetoothDevice mybluetooth:mydevice)
	{
		adapter.add(mybluetooth.getName());
	}
	l1.setAdapter(adapter);
}


}		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==RESULT_CANCELED)
		{
			Toast.makeText(getApplicationContext(), "BLUETOOTH MUST b switched on first and then start again", 1).show();
			finish();
			
		}
	}
	
	
	
	
	}

	
