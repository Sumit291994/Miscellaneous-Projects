package com.example.bluetooth02;

import java.util.Set;



import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ArrayAdapter<String> mylist;
	Button button;
	ListView mylistv;
	BluetoothAdapter btadapter;
	Set<BluetoothDevice> btlist;
	BroadcastReceiver myreceiver;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button =(Button)findViewById(R.id.button1);
		mylistv =(ListView)findViewById(R.id.listView1);
		mylist= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		mylistv.setAdapter(mylist);
		
		btadapter= BluetoothAdapter.getDefaultAdapter();
		
		myreceiver =new BroadcastReceiver(){

			@Override
			public void onReceive(Context arg0, Intent arg1) {
				// TODO Auto-generated method stub
				
			}
			
		};
		if(btadapter==null){
			Toast.makeText(getApplicationContext(), "no BT  Available ", 1).show();
			finish();
		}else{
			if(!btadapter.isEnabled()){
				Intent intent = new Intent (btadapter.ACTION_REQUEST_ENABLE);
				startActivityForResult(intent,1);	
			}
			
			btlist= btadapter.getBondedDevices();
			if(btlist.size()>0){
				for(BluetoothDevice onebt:btlist){
					mylist.add(onebt.getName());
					
				}
			}
			
			
		}
		
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==RESULT_CANCELED){
			Toast.makeText(getApplicationContext(), "BT must be enabled", 2).show();
			finish();
		}
		else
		{
			btlist= btadapter.getBondedDevices();
			if(btlist.size()>0){
				for(BluetoothDevice onebt:btlist){
					mylist.add(onebt.getName());
					
				}}
		}
		
		
	}
	

	
}