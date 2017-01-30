package com.example.snake;

import com.example.snake.R;

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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements SensorEventListener{
	
public Button[][] b;
public long ctime,ltime,direction;//c=current time;l=last time;
public Snake obj=new Snake(5,5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager mysensor=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor S=mysensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mysensor.registerListener(this, S, SensorManager.SENSOR_DELAY_NORMAL);
        
        b=new Button [5][5];
        
        View.OnClickListener mylist;
        
	b[0][0]=(Button)findViewById(R.id.button1);
		b[0][1]=(Button)findViewById(R.id.button2);
		b[0][2]=(Button)findViewById(R.id.button3);
		b[0][3]=(Button)findViewById(R.id.button4);
		b[0][4]=(Button)findViewById(R.id.button5);
		b[1][0]=(Button)findViewById(R.id.button6);
		b[1][1]=(Button)findViewById(R.id.button7);
		b[1][2]=(Button)findViewById(R.id.button8);
		b[1][3]=(Button)findViewById(R.id.button9);
		b[1][4]=(Button)findViewById(R.id.button10);
		b[2][0]=(Button)findViewById(R.id.button11);
	    b[2][1]=(Button)findViewById(R.id.button12);
		b[2][2]=(Button)findViewById(R.id.button13);
		b[2][3]=(Button)findViewById(R.id.button14);
		b[2][4]=(Button)findViewById(R.id.button15);
		b[3][0]=(Button)findViewById(R.id.button16);
		b[3][1]=(Button)findViewById(R.id.button17);
		b[3][2]=(Button)findViewById(R.id.button18);
		b[3][3]=(Button)findViewById(R.id.button19);
		b[3][4]=(Button)findViewById(R.id.button20);
		b[4][0]=(Button)findViewById(R.id.button21);
		b[4][1]=(Button)findViewById(R.id.button22);
		b[4][2]=(Button)findViewById(R.id.button23);
		b[4][3]=(Button)findViewById(R.id.button24);
		b[4][4]=(Button)findViewById(R.id.button25);
		ltime=System.currentTimeMillis();
		
		
		
		
		
		
        
        
        
  

    }
	
	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSensorChanged(SensorEvent arg0) {
		ctime=System.currentTimeMillis();
		float x=arg0.values[0];
		float y=arg0.values[1];
		if(ctime-ltime>=1000)
		{
			ltime=ctime;
			
			if(x>3)obj.direction=1;
			if(x<-3)obj.direction=2;
			if(y>3)obj.direction=3;
			if(y<-3)obj.direction=4;
			obj.movesnake();
			for(int i=0;i<=5;i++)
				for(int j=0;j<=5;j++)
				{
					if(obj.maze[i][j].status==1)
						b[i][j].setText("X");
				}
			
		}

		
	}


    
    
	

	
    
}
