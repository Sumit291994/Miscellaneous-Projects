package com.example.converter;

import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	public int i,r;
	double sound[];
	byte sound2[];
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        View.OnClickListener mylist;
		//final EditText e1=(EditText)findViewById(R.id.editText1);
		final Button b1=(Button)findViewById(R.id.button1);
		final Button b2=(Button)findViewById(R.id.button2);
		final Button b3=(Button)findViewById(R.id.button3);
		final Button b4=(Button)findViewById(R.id.button4);
		final Button b5=(Button)findViewById(R.id.button5);
		final Button b6=(Button)findViewById(R.id.button6);
		
		mylist=new View.OnClickListener() {
			
			@Override
			public void onClick(View data) {
				if(data.getId()==R.id.button1)
				{
				r=0;	generatesound(1000);
					
				}
				if(data.getId()==R.id.button2)
				{
					r=1;generatesound(1000);
				}
				if(data.getId()==R.id.button3)
				{generatesound(800);
					
				}
				if(data.getId()==R.id.button4)
				{
					generatesound(1304);
				}
				if(data.getId()==R.id.button5)
				{generatesound(3000);
					
				}
				if(data.getId()==R.id.button6)
				{
					generatesound(2343);
				}
				
				
					}
		};
		b1.setOnClickListener(mylist);
		b2.setOnClickListener(mylist);
		b3.setOnClickListener(mylist);
		b4.setOnClickListener(mylist);
		b5.setOnClickListener(mylist);
		b6.setOnClickListener(mylist);
		
        
        
        
        
        
  

    }
    public void generatesound(int f)//f=frequency
    {sound=new double [40000];//40000points per sec
    sound2=new byte [80000];
    int v=32767;
    for(i=0;i<40000;i++)
    {
    	sound[i]=Math.sin(2*Math.PI*i*f/40000);
    	int temp=(int) (v*sound[i]);//32767is highest 16 bit no.this converts sound[i] into 16 bit no
    	 temp--;
    	sound2[2*i]=(byte) (temp&255);//last 8 bites
    	sound2[2*i+1]=(byte) ((temp>>8)&255);//first 8 bites
   
    }
    AudioTrack mytrack=new AudioTrack(AudioManager.STREAM_MUSIC, 40000, AudioFormat.CHANNEL_CONFIGURATION_MONO, AudioFormat.ENCODING_PCM_16BIT, 40000, AudioTrack.MODE_STATIC);//buffr size=40000*time of wave in sec
    	mytrack.write(sound2, 0, 80000);
    	mytrack.play();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
