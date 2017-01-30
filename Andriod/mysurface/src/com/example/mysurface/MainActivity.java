package com.example.mysurface;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity implements OnTouchListener {
	public float x[],y[];
	public int k=0;
	public surface mysurface;
	public Thread mythread;
	public Paint paint;
boolean b=true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		x=new float[100000];
		y=new float[100000];
		mysurface =new surface(this);
		setContentView(mysurface);
		mysurface.setOnTouchListener(this);
	}
	
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		 x[k]=arg1.getX();
		 y[k++]=arg1.getY();
		return true;
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mysurface.mypause();
	
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
	}

	public class surface extends SurfaceView implements Runnable
	{

		SurfaceHolder myholder;
		Thread mythread=null;
	//	Bitmap mybitmap= BitmapFactory.decodeResource(getResources(),R.drawable.abc_ab_bottom_solid_light_holo);
		
		public surface(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			myholder=getHolder();
			mythread=new Thread(this);
			mythread.start();
			
		}

		
		public void mypause()
		{b=false;
			
		}
		public void myresume()
		{
			b=true;
			
			mythread=new Thread(this);
			mythread.start();
			
				
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			 paint= new Paint();

			
			while(b)
			{
			if(myholder.getSurface().isValid())
			{
				
				paint.setColor(Color.RED);
				
				Canvas c=myholder.lockCanvas();
				c.drawARGB(255, 0, 0, 255);
				for(int i=0;i<k;i++)
				c.drawCircle(x[i], y[i],15,paint );
				
				myholder.unlockCanvasAndPost(c);
				
				
			}
			}
			
		}
		
		
		
		
	}

	
	
}

