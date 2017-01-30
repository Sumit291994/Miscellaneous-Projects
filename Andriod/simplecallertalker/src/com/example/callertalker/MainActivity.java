package com.example.callertalker;

import java.util.Locale;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;
import android.speech.tts.TextToSpeech;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {
	private TextToSpeech tts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tts = new TextToSpeech(this, this);
		  
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        
        PhoneStateListener callStateListener = new PhoneStateListener() {
        public void onCallStateChanged(int state, String incomingNumber){
              if(state==TelephonyManager.CALL_STATE_RINGING){
            	  tts.speak(incomingNumber+" calling", TextToSpeech.QUEUE_FLUSH, null);
                  Toast.makeText(getApplicationContext(),"Phone is Ringing : "+incomingNumber, Toast.LENGTH_LONG).show();
                 }
              if(state==TelephonyManager.CALL_STATE_OFFHOOK){
                    Toast.makeText(getApplicationContext(),"Phone in a call or call picked", Toast.LENGTH_LONG).show();
              }
              if(state==TelephonyManager.CALL_STATE_IDLE){
                    //Toast.makeText(getApplicationContext(),"phone is neither ringing nor in a call", Toast.LENGTH_LONG).show();
              }
        }
        };
        telephonyManager.listen(callStateListener,PhoneStateListener.LISTEN_CALL_STATE);
	}

	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
			int result = tts.setLanguage(Locale.US);
		    if (result == TextToSpeech.LANG_MISSING_DATA
		            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
		        Log.e("TTS", "This Language is not supported");
		    } else {    	
		    }

		} else {
		    Log.e("TTS", "Initilization Failed!");
		}
	}
	
	@Override
	public void onDestroy() {
	// Don't forget to shutdown tts!
	if (tts != null) {
	    tts.stop();
	    tts.shutdown();
	}
	super.onDestroy();
	}

}
