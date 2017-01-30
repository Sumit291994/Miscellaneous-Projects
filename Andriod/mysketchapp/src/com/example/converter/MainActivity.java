package com.example.converter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnTouchListener{
	public float x,y,arrx[],arry[];
	public int k=0;
	


    
    
        
        
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            drawview drawv=new drawview(this);
            setContentView(drawv);
            drawv.setOnTouchListener(this);
        
            arrx =new float[100000];
            arry=new float[100000];
  
}
    
    
    
    public class drawview extends View {
    	public Paint paint= new Paint();
    	public drawview(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
    	
    	
    	public  void onDraw(Canvas c)
		{super.onDraw(c);
		paint.setColor(Color.WHITE);
	//	c.drawPaint(paint);
		paint.setColor(Color.RED);
		//Toast.makeText(getApplicationContext(), String.valueOf(x), Toast.LENGTH_LONG).show();
	

//for(int i=0;i<k-1;i++)
	c.drawCircle(x,y,10, paint);
//		c.drawCircle(0,0, 10, paint);
	invalidate();	

		}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public boolean onTouch(View arg0, MotionEvent touch) {
		//arrx[k]=touch.getX();
	//	arry[k++]=touch.getY();
		x=touch.getX();
		y=touch.getY();
		// TODO Auto-generated method stub
		return true;
	}
    
}
