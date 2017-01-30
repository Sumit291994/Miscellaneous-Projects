package com.example.converter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements SensorEventListener{
	public int x,y,level=1,k;
	public surface mysurface;
	public Paint paint;
   public game mygame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mysurface =new surface(this);
		setContentView(mysurface);
		mygame=new game();
		SensorManager mysensor=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor S=mysensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mysensor.registerListener(this, S, SensorManager.SENSOR_DELAY_NORMAL);
		

		
        }

	public class surface extends SurfaceView implements Runnable
	{

		SurfaceHolder myholder;
		Thread mythread=null;
		
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
			paint= new Paint();
			
			while(true)
			{
			if(myholder.getSurface().isValid())
			{
				
				paint.setColor(Color.RED);
				y=getHeight();
				x=getWidth();
				if(level==1)
                k=  mygame.level1(x, y);
				
				
				Canvas c=myholder.lockCanvas();
				c.drawARGB(255, 0, 255, 0);
			//	c.drawRect(0, 0, 100, 100, paint);
				
				
				for(int i=0;i<k;i=i+2)
				c.drawRect(mygame.arrx[i], mygame.arry[i], mygame.arrx[i+1], mygame.arry[i+1], paint);
					
				c.drawRect(x/4,y/3, x/2+3,y, paint);
				myholder.unlockCanvasAndPost(c);
				
			
			}
			
		}   
        
        
        
	}

    }

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent arg0) {
		// TODO Auto-generated method stub
		float dx=arg0.values[0];
		float dy=arg0.values[1];
		
		
	}
}
