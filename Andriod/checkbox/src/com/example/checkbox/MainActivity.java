package com.example.checkbox;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity {
    CheckBox pizza,coffe,burger;
    Button buttonOrder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButtonClick();
	}
public void addListenerOnButtonClick(){
	pizza=(CheckBox)findViewById(R.id.checkBox1);
	coffe=(CheckBox)findViewById(R.id.checkBox2);
	burger=(CheckBox)findViewById(R.id.checkBox3);
	buttonOrder=(Button)findViewById(R.id.button1);
	
	buttonOrder.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View view) {
			int totalamount=0;
			StringBuilder result=new StringBuilder();
			result.append("Selected Items:");
			if(pizza.isChecked()){
				result.append("\nPizza 100Rs");
				totalamount+=100;
			}
			if(coffe.isChecked()){
				result.append("\nCoffe 50Rs");
				totalamount+=50;
			}
			if(burger.isChecked()){
				result.append("\nBurger 120Rs");
				totalamount+=120;
			}
			result.append("\nTotal: "+totalamount+"Rs");
			Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
		}
		
	});
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
