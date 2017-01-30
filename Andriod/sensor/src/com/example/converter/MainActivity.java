package com.example.converter;

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

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements SensorEventListener {
	View.OnClickListener myhandler;
	double num1=0,num2,opr;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager mysensor=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor S=mysensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mysensor.registerListener(this, S, SensorManager.SENSOR_DELAY_NORMAL);
        
       
        
        
                	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent arg0) {
		// TODO Auto-generated method stub
		float x=arg0.values[0];
		float y=arg0.values[1];
		float z=arg0.values[2];
		
		
		((EditText)findViewById(R.id.editText1)).setText(String.valueOf(x));
		((EditText)findViewById(R.id.editText1)).setText(String.valueOf(y));
		((EditText)findViewById(R.id.editText1)).setText(String.valueOf(z));
	}
    
}
