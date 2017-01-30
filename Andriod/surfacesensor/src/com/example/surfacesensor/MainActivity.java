package com.example.surfacesensor;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainActivity extends Activity implements SensorEventListener,OnTouchListener {
	float x,y,xx,yy;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		surface mysurface =new surface(this);
		setContentView(mysurface);
		mysurface.setOnTouchListener(this);
		SensorManager mysensor=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor S=mysensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mysensor.registerListener(this, S, SensorManager.SENSOR_DELAY_NORMAL);
		
//        mysurface.setoonSensorChanged(this);
		
		}
	
	
	
	public class surface extends SurfaceView implements Runnable
	{

		SurfaceHolder myholder;
		Thread mythread=null;
		Bitmap mybitmap= BitmapFactory.decodeResource(getResources(),R.drawable.abc_ab_bottom_solid_light_holo);
		
		public surface(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			myholder=getHolder();
			mythread=new Thread(this);
			mythread.start();
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			
			while(true)
			{
			if(myholder.getSurface().isValid())
			{
				
				
				
				Canvas c=myholder.lockCanvas();
				c.drawARGB(255, 0, 0, 255);
				c.drawBitmap(mybitmap, x, y, null);
				
				myholder.unlockCanvasAndPost(c);
				
				
			}
			}
			
		}


	

	}	
	@Override
	public void onSensorChanged(SensorEvent arg0) {
	
		// TODO Auto-generated method stub
		
	 xx=arg0.values[0];
		yy=arg0.values[1];
	
	
		if(xx<-2)
		x++;
		
		 if(xx>2)
			x--;
		if(yy<-2)
		y--;
		 if(yy>2)
		y++;
	}
	

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		x=arg1.getX();
		y=arg1.getY();
		return false;
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	

}
