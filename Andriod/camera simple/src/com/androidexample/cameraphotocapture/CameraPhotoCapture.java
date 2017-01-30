package com.androidexample.cameraphotocapture;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CameraPhotoCapture extends Activity {

	final static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1;
	
    
    Uri imageUri                      = null;
    static TextView imageDetails      = null;
    public  static ImageView showImg  = null;
    CameraPhotoCapture CameraActivity = null;
  public ImageView img; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera_photo_capture);
	//	CameraActivity = this;
		
	//	imageDetails = (TextView) findViewById(R.id.imageDetails);
		
//		showImg = (ImageView) findViewById(R.id.showImg);
		
		final Button b1 = (Button) findViewById(R.id.button1);
		img = (ImageView) findViewById(R.id.imageView1);
		 View.OnClickListener mylist;
			
		
		 mylist=new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				if(arg0.getId()==R.id.button1)
				{
					try{
					 ContentValues values = new ContentValues();
				        
				        values.put(MediaStore.Images.Media.TITLE, "myimage.png");
				        
				        values.put(MediaStore.Images.Media.DESCRIPTION,"Image capture by camera");
				        
				        /****** imageUri is the current activity attribute, define and save it for later usage  *****/
				        imageUri = getContentResolver().insert(
				        		MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
				        
				        /******   EXTERNAL_CONTENT_URI : style URI for the "primary" external storage volume. ******/

				        
				        /******  Standard Intent action that can be sent to have the camera application capture an image and return it. ******/ 
				        
				        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				        
				         intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
				         
				         intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
				         
				        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
					}catch(Exception e)
					{
						 Toast.makeText( getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
					}
				}
				
			}
		};
		b1.setOnClickListener(mylist);
		
		
	}

	 @Override
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	    {
	    	 
	    	    	
		 img.setImageURI(imageUri);
		 try {
			Bitmap mybitmap=Media.getBitmap(getContentResolver(), imageUri);
			FileOutputStream mystream=new FileOutputStream(new File("/", "myselfie.jpg"));
			mybitmap.compress(Bitmap.CompressFormat.JPEG,100, mystream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	    	        Toast.makeText(getApplicationContext(), "Picture was taken", Toast.LENGTH_SHORT).show();
	    	    
	    	
	    }
	 
	 
	
	    
	    
}
