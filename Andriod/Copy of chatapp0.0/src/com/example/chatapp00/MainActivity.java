package com.example.chatapp00;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	public Thread mythread,mythread2;
	public String s,num;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 View.OnClickListener mylist;
		
		 final Button b1=(Button)findViewById(R.id.button1);
	
		         final TextView t1=(TextView)findViewById(R.id.textView1);
		         final TextView t2=(TextView)findViewById(R.id.textView2);
		         final TextView t3=(TextView)findViewById(R.id.textView3);
		         final TextView t4=(TextView)findViewById(R.id.textView4);
		         final TextView t5=(TextView)findViewById(R.id.textView5);
		         final TextView t6=(TextView)findViewById(R.id.textView6);
		         final EditText e1=(EditText)findViewById(R.id.editText1);
		         final EditText e2=(EditText)findViewById(R.id.editText2);
		         final EditText e3=(EditText)findViewById(R.id.editText3);
		         final EditText e4=(EditText)findViewById(R.id.editText4);
		         
		         
		         mylist=new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if(arg0.getId()==R.id.button1)
						{
							s=(e4.getText()).toString();
						 num=(e3.getText()).toString();
							mythread=new Thread(){
					    	    public void run(){
					    		HttpClient client = new DefaultHttpClient();
					    	    HttpPost post = new HttpPost("http://android.bricsworld.com/data/");
					    	    
					    	    List<NameValuePair> pairs = new ArrayList<NameValuePair>();
					    	    pairs.add(new BasicNameValuePair("a",num));
					    	    pairs.add(new BasicNameValuePair("b",s));
					    	    
					    	    
					    	    
					    	    
					    	    try {
					    			post.setEntity(new UrlEncodedFormEntity(pairs));
					    		} catch (UnsupportedEncodingException e) {
					    			// TODO Auto-generated catch block
					    			e.printStackTrace();
					    		}
					    	    
					    	   try {
					    			HttpResponse response = client.execute(post);
					    		 s=response.toString();
					    		runOnUiThread(new Runnable() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										Toast.makeText(MainActivity.this, "msg SENT   "+s, 1).show();
										t5.setText(e3.getText());
										e2.setText(e4.getText());
									}
								});
					    		} catch (ClientProtocolException e) {
					    			// TODO Auto-generated catch block
					    			e.printStackTrace();
					    		} catch (IOException e) {
					    			// TODO Auto-generated catch block
					    			e.printStackTrace();
					    		}
					    	    }
					    				};
					        mythread.start();
					        
					        
					}
						
						
						
						
					
						
						
						
						
						
						
						
					}
				};
				
				b1.setOnClickListener(mylist);
				mythread=new Thread()
				{
					 public void run(){
				    		HttpClient client2 = new DefaultHttpClient();
				    	    HttpGet get = new HttpGet("http://android.bricsworld.com/data/");
				    	    
				    	while(true) 
				    	{
				    	    
				    	   try {
				    			HttpResponse response = client2.execute(get);
				    		 s=response.toString();
				    		
				    		runOnUiThread(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									 if(s.equalsIgnoreCase("no msg"))
						    		 {
						    			 
						    		 }
						    		 else{
									Toast.makeText(MainActivity.this, "msg recieved", 1).show();
									e1.setText(s);
						    		 }
								}
							});
				    		} catch (ClientProtocolException e) {
				    			// TODO Auto-generated catch block
				    			e.printStackTrace();
				    		} catch (IOException e) {
				    			// TODO Auto-generated catch block
				    			e.printStackTrace();
				    		}
				    	}
					 }
				};

		
	}

	

	
	}



