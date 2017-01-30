package com.example.registration_form;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	public Thread mythread;
	public String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
       final Button b1=(Button)findViewById(R.id.button1);
/*        final TextView t1=(TextView)findViewById(R.id.textView1);
        final TextView t2=(TextView)findViewById(R.id.textView2);
        final TextView t3=(TextView)findViewById(R.id.textView3);
        final EditText e1=(EditText)findViewById(R.id.editText1);
        final EditText e2=(EditText)findViewById(R.id.editText4);
        final EditText e3=(EditText)findViewById(R.id.editText3);
        */
        
    	mythread=new Thread(){
    	    public void run(){
    		HttpClient client = new DefaultHttpClient();
    	    HttpPost post = new HttpPost("http://android.bricsworld.com/data/");
    	    
    	    List<NameValuePair> pairs = new ArrayList<NameValuePair>();
    	    pairs.add(new BasicNameValuePair("a","data"));
    	    pairs.add(new BasicNameValuePair("b","hii"));
    	    pairs.add(new BasicNameValuePair("c","hello"));
    	    pairs.add(new BasicNameValuePair("d","12103528"));
    	    pairs.add(new BasicNameValuePair("e","VG"));
    	    pairs.add(new BasicNameValuePair("f","vr938293!##"));
    	    pairs.add(new BasicNameValuePair("g","--"));
    	    pairs.add(new BasicNameValuePair("h","helloooooooooo"));
    	    
    	    
    	    
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
					Toast.makeText(MainActivity.this, s, 1).show();
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
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
/*	String name=(e1.getText().toString());	
	String roll=(e2.getText().toString());
	String email=(e3.getText().toString());
	e1.setText("");e2.setText("");e3.setText("");
*/
			}
		});
        

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
