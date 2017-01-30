package com.example.snake;

import com.example.snake.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MainActivity extends Activity implements SensorEventListener{
	
	public int sx=20,sy=20,ii,jj,x,y,v,r=1;
	
public Button[][] b;
public long ctime,ltime,directionlock=0;//c=current time;l=last time;
public  Snake obj=new Snake(sx,sy);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new drawview(this));
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        ((KeyguardManager)getSystemService(Activity.KEYGUARD_SERVICE)).newKeyguardLock(KEYGUARD_SERVICE).disableKeyguard();
        SensorManager mysensor=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor S=mysensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mysensor.registerListener(this, S, SensorManager.SENSOR_DELAY_NORMAL);
        	ltime=System.currentTimeMillis();
        	
		    }
	
    
    
	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSensorChanged(SensorEvent arg0) {
		float x=arg0.values[0];
		float y=arg0.values[1];
		if(directionlock==0)	
		{
		if(x>3&&obj.direction!=2){obj.direction=1;
			directionlock=1;
			}
			if(x<-3&&obj.direction!=1)
				{obj.direction=2;
				directionlock=1;}
				
			if(y>3&&obj.direction!=4){
				directionlock=1;
				obj.direction=3;
			}
			if(y<-3&&obj.direction!=3){
			directionlock=1	;
			obj.direction=4;
			}
		}
		}

	public class drawview extends View {
		public Paint paint= new Paint();
		int xx=0,yy=0;
		public drawview(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
	
		public  void onDraw(Canvas c)
		{super.onDraw(c);
		ctime=System.currentTimeMillis();
		paint.setColor(Color.BLUE);
		c.drawPaint(paint);
		paint.setColor(Color.RED);
		if(r==1)
		{obj.fruitx(sx);
		obj.fruity(sy);
		ii=obj.ii;
		jj=obj.jj;r++;}
		
		c.drawRect( x/sx*ii, y/sy*jj, x/sx*(ii+1),y/sy*(jj+1), paint);
		
		
		
		if(ctime-ltime>1000)
		{
			ltime=ctime;
			
			x=getWidth();
			 y=getHeight();
			 
			 
			 
			 
			 if(v==1)
				{
					obj.fruitx(sx);
					obj.fruity(sy);
					ii=obj.ii;
					jj=obj.jj;
				//	obj.maze[ii][jj].status=1;
				}
				
			 c.drawRect( x/sx*ii, y/sy*jj, x/sx*(ii+1),y/sy*(jj+1), paint);
				
	v=obj.movesnake();
	directionlock=0;
	if(obj.settoast==1)
		 Toast.makeText(getApplicationContext(), "gameover", Toast.LENGTH_LONG).show();
	
		
		}
		
		
			for(int i=0;i<sx;i++){
				for(int j=0;j<sy;j++)
				{
					if(obj.maze[i][j].status==1)
						c.drawRect( x/sx*i, y/sy*j, x/sx*(i+1),y/sy*(j+1), paint);
					}
			}		
		invalidate();	
		}

	}
	
	
	
}
