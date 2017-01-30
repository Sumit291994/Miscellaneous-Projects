package com.example.chatapp00;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class bluetoothlist extends Activity{
	Button b1,b2,b3,b4;
	EditText e1;
	ArrayAdapter<String> mylist;
	ListView mylistv;
	BluetoothAdapter btadapter;
	Set<BluetoothDevice> btlist;
	BroadcastReceiver myreceiver;
	BluetoothDevice mmdevice;
	int count=0;
	public ConnectThread T1;
	AcceptThread t0;
	ConnectedThread T2;
	String ss;
	  BluetoothSocket mmSocket;
     BluetoothDevice mmDevice;
 
	
	View.OnClickListener mylist2 ;
	private static final UUID SerialPortServiceClass_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bluetoothtext);
		
		b1 =(Button)findViewById(R.id.button1);
		b2 =(Button)findViewById(R.id.button2);
		b3 =(Button)findViewById(R.id.button3);
		b4 =(Button)findViewById(R.id.button4);
        e1=(EditText)findViewById(R.id.editText1);

    	
		
		
		mylist2=new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(v.getId()==R.id.button4)
				{
					setContentView(R.layout.bluetoothlist);
			mylistv =(ListView)findViewById(R.id.listView1);
			list();
						mylistv.setAdapter(mylist);
						
					btlist= btadapter.getBondedDevices();
					if(btlist.size()>0){
						for(BluetoothDevice onebt:btlist){
							mylist.add(onebt.getName());
					
					
					mylistv.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
								long arg3) {
							// TODO Auto-generated method stub
							

							count=0;
							for(BluetoothDevice onebt:btlist){
							
								if (count==arg2)
								{mmdevice=onebt;
								try{ 
								T1= new ConnectThread(mmdevice);
									T1.start();
									
									
									T2= new ConnectedThread(mmSocket);
										T2.start();
										
					Toast.makeText(getApplicationContext(), "Your selected device is-"+mmdevice.getName(), 1).show();
										setContentView(R.layout.bluetoothtext);
										b1 =(Button)findViewById(R.id.button1);
										b2 =(Button)findViewById(R.id.button2);
										b3 =(Button)findViewById(R.id.button3);
										b4 =(Button)findViewById(R.id.button4);
								        e1=(EditText)findViewById(R.id.editText1);
								        b1.setOnClickListener(mylist2);
										b2.setOnClickListener(mylist2);
										b3.setOnClickListener(mylist2);
										b4.setOnClickListener(mylist2);

										
										
								}catch(Exception e)
								{
									Toast.makeText(getApplicationContext(),e.toString(), 1).show();
								}
								
								break;
								}
								count++;
								
								
						}
				
						//	Toast.makeText(getApplicationContext(), "Your selected device is-"+mmdevice.getName(), 1).show();	
						
							
							
					};
					});
					
					
							
						}
					}
					
				}
				
				
				if(v.getId()==R.id.button1)
				{if(mmdevice!=null)
					Toast.makeText(getApplicationContext(), "Sending to-"+mmdevice.getName(), 1).show();
					
					T2.write(((e1.getText()).toString()+"\r\n").getBytes());
					
					
				}
				
				if(v.getId()==R.id.button2)
				{
					T1.cancel();
					Toast.makeText(getApplicationContext(), "stopping connection from"+mmdevice.getName(), 1).show();
					
				}
				if(v.getId()==R.id.button3)
				{
					t0= new AcceptThread();
					t0.start();
					while(mmSocket==null){}
					T2= new ConnectedThread(mmSocket);
						T2.start();
		
					Toast.makeText(getApplicationContext(), "connection started", 1).show();
					
				}
				
				
			}
		};
		
		b1.setOnClickListener(mylist2);
		b2.setOnClickListener(mylist2);
		b3.setOnClickListener(mylist2);
		b4.setOnClickListener(mylist2);
		
		
		
		
		btadapter= BluetoothAdapter.getDefaultAdapter();
		
		
		
		
		myreceiver =new BroadcastReceiver() {
			
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		
		if(btadapter==null){
			Toast.makeText(getApplicationContext(), "no Bluetooth Available ", 1).show();
			finish();
		}else{
			if(!btadapter.isEnabled()){
				Intent intent = new Intent (btadapter.ACTION_REQUEST_ENABLE);
				startActivityForResult(intent,1);	
			}
			
			
			
			
		}
		
		
		
		
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==RESULT_CANCELED){
			Toast.makeText(getApplicationContext(), "Switch on bluetooth and try again", 1).show();
			finish();
		}	
		else
		{
			Toast.makeText(getApplicationContext(), "success!SELECT DEVICE and continue", 1).show();
			btlist= btadapter.getBondedDevices();
			if(btlist.size()>0){
				for(BluetoothDevice onebt:btlist){
					mylist.add(onebt.getName());
					
				}
			}
			
		}
		
		
		
}
	

	private class AcceptThread extends Thread {
		private final BluetoothServerSocket mmServerSocket;

		public AcceptThread() {
			BluetoothServerSocket tmp2 = null;
			try {
				tmp2 = btadapter.listenUsingRfcommWithServiceRecord(
						"BRiCS", SerialPortServiceClass_UUID);
			} catch (IOException e) {
			}
			mmServerSocket = tmp2;
		}

		public void run() {
			BluetoothSocket socket = null;
			while (true) {
				try {
					socket = mmServerSocket.accept();
				} catch (IOException e) {
					break;
				}
				mmSocket = socket;
				if (socket != null) {
					break;
				}
			}
		}

		/** Will cancel the listening socket, and cause the thread to finish */
		public void cancel() {
			try {
				mmServerSocket.close();
			} catch (IOException e) {
			}
		}
	}

	
	
	public class ConnectThread extends Thread {
		
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
	  //  private final BluetoothSocket mmSocket;
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
	           // T2.start();
	        	try {
	        		
	                bytes = mmInStream.read(buffer);
	                
	               
	            
	                if(bytes>0)
	                { ss = new String(buffer,0,bytes);
	              runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						e1.append(ss);
					}
				});
	                
	                //Toast.makeText(getApplicationContext(), "MSG recieved!!", 1).show();
	                
	                }
	                
	            } catch (IOException e) {
	            //	Toast.makeText(getApplicationContext(), e.toString(), 1).show();
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
	    
public void list()
{
	mylist= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
}

}
