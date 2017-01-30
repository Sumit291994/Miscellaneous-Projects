package com.example.gps;

import java.io.IOException;

import android.R.string;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity implements LocationListener{
	public LocationManager mymanager;
	public TextView t2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 final TextView t1=(TextView)findViewById(R.id.textView1);
	         t2=(TextView)findViewById(R.id.textView2);
/*try
{mymanager =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
Location loc=mymanager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
t2.setText(mymanager.toString()+";;;;;"+loc.toString());
}catch(Exception e){Toast.makeText(getApplicationContext(), "u  have catch1"+e, 2).show();
	
}*/

mymanager =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
mymanager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, this);

		
		}

	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		
		Location x=arg0;
		t2.setText(String.valueOf(x));
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

	
	


