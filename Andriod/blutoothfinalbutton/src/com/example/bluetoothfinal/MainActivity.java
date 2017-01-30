package com.example.bluetoothfinal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
	BluetoothDevice mmdevice;
	int count=0;
	public ConnectThread T1;
	
    private static final UUID SerialPortServiceClass_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	//	button =(Button)findViewById(R.id.button1);
		mylistv =(ListView)findViewById(R.id.listView1);
		mylist= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		mylistv.setAdapter(mylist);
		 View.OnClickListener mylist2;
		final Button b1=(Button)findViewById(R.id.button1);
		final Button b2=(Button)findViewById(R.id.button2);
		final Button b3=(Button)findViewById(R.id.button3);
		//final Button b4=(Button)findViewById(R.id.button4);
		mylist2=new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId()==R.id.button1)
				{
					Toast.makeText(getApplicationContext(), "Your selected device is-"+mmdevice.getName(), 1).show();
					 T1= new ConnectThread(mmdevice);
					T1.start();
				}
				if(v.getId()==R.id.button2)
				{ConnectedThread T2= new ConnectedThread(T1.mmSocket);
				T2.write("welcome bluetooth".getBytes());
					
				}
				
				if(v.getId()==R.id.button3)
				{
					T1.cancel();
				}
				
				
				
			}
		};
		
		
		b1.setOnClickListener(mylist2);
		b2.setOnClickListener(mylist2);
		b3.setOnClickListener(mylist2);
		
		
        
		mylistv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
		//		Toast.makeText(getApplicationContext(), "hie", 1).show();
				count=0;
				for(BluetoothDevice onebt:btlist){
				
					if (count==arg2)
					mmdevice=onebt;
					count++;
					
					
			}
				Toast.makeText(getApplicationContext(), "Press button to select service", 1).show();
				
				
				
				
		};
		});
		
		btadapter= BluetoothAdapter.getDefaultAdapter();
		
		myreceiver =new BroadcastReceiver(){

			@Override
			public void onReceive(Context arg0, Intent arg1) {
				// TODO Auto-generated method stub
				
			}
			
		};
		if(btadapter==null){
			//Toast.makeText(getApplicationContext(), "no BT  Available ", 1).show();
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
			//Toast.makeText(getApplicationContext(), "BT must be enabled", 2);
			finish();
		}	

}	


	
	public class ConnectThread extends Thread {
		private  BluetoothSocket mmSocket;
	    private final BluetoothDevice mmDevice;
	 
	    public ConnectThread(BluetoothDevice device) {
	        BluetoothSocket tmp = null;
	        mmDevice = device;
	        try {
	            tmp = device.createRfcommSocketToServiceRecord(SerialPortServiceClass_UUID);
	        } catch (IOException e) { }
	        mmSocket = tmp;
	    }
	 
	    public void run() {
	        btadapter.cancelDiscovery();
	 
	        try {
	            mmSocket.connect();
	        } catch (IOException connectException) {
	            try {
	                mmSocket.close();
	            } catch (IOException closeException) { }
	            return;
	        }
	    }
	 
	    /** Will cancel an in-progress connection, and close the socket */
	    
	        
public void cancel() {
	        try {
	            mmSocket.close();
	        } catch (IOException e) { }
	    }
	}
	
	
	public class ConnectedThread extends Thread {
	    private final BluetoothSocket mmSocket;
	    private final InputStream mmInStream;
	    private final OutputStream mmOutStream;
	 
	    @SuppressLint("NewApi")
		public ConnectedThread(BluetoothSocket socket) {
	        mmSocket = socket;
	        InputStream tmpIn = null;
	        OutputStream tmpOut = null;
			while(!mmSocket.isConnected()){};
	        try {
	            tmpIn = socket.getInputStream();
	            tmpOut = socket.getOutputStream();
	        } catch (IOException e) { }
	 
	        mmInStream = tmpIn;
	        mmOutStream = tmpOut;
	    }
	 
	    public void run() {
	        byte[] buffer = new byte[1024];  // buffer store for the stream
	        int bytes; // bytes returned from read()
	        while (true) {
	            try {
	                bytes = mmInStream.read(buffer);
	            } catch (IOException e) {
	                break;
	            }
	        }
	    }
	 
	    public void write(byte[] bytes) {
	        try {
	            mmOutStream.write(bytes);
	        } catch (IOException e) { 
	
	        }
	    }
	    public void cancel() {
	        try {
	            mmSocket.close();
	        } catch (IOException e) { }
	    }
	}

}