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

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements LocationListener {
	public Thread mythread;
	public String s;
	public LocationManager mymanager;
	double x,y;
	public TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
 //      final Button b1=(Button)findViewById(R.id.button1);
        t1=(TextView)findViewById(R.id.textView1);
       mymanager =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
       mymanager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, this);

      
    	
        
        

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		 x = (arg0.getLatitude())*100;
		 y=(arg0.getLongitude())*100;
		 t1.setText(String.valueOf(x));
		 mythread=new Thread(){
	    	    public void run(){
	    		HttpClient client = new DefaultHttpClient();
	    	    HttpPost post = new HttpPost("http://ekaad.com/?table=GPS9415474641&mobile=8585927154&a="+String.valueOf(x)+"&b="+String.valueOf(y));
	    	    
	    	    List<NameValuePair> pairs = new ArrayList<NameValuePair>();
	    	/*    pairs.add(new BasicNameValuePair("a","data"));
	    	    pairs.add(new BasicNameValuePair("b","hii"));
	    	    pairs.add(new BasicNameValuePair("c","hello"));
	    	    pairs.add(new BasicNameValuePair("d","12103528"));
	    	    pairs.add(new BasicNameValuePair("e","VG"));
	    	    pairs.add(new BasicNameValuePair("f","vr938293!##"));
	    	    pairs.add(new BasicNameValuePair("g","--"));
	    	    pairs.add(new BasicNameValuePair("h","helloooooooooo"));*/
	    	    
	    	    
	    	    
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
	}


	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
    
}
