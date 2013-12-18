package com.example.bitcoinlive;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    
		//Getting intent <as ArrayList not String! > from SplashScreenActivity
		Intent i = getIntent();  
	    ArrayList<String> list = i.getStringArrayListExtra("result");
	    Log.d("Result Array", "Result is: "+list.toString());
	    
	    String mtgox 	= list.get(0).toString();		//Mtgox Json response was the zero entity of arraylist
	    String bitstamp = list.get(1).toString(); 		//Bitstamp Json response was the first entity of arraylist  
	    String btce		= list.get(2).toString();		//Btce Json response was the second entity of arraylist
	    String btch 	= list.get(3).toString();		//Btch Json response was the third entity of arraylist
	   

		
		TextView tvMain1 = (TextView) findViewById(R.id.tvMain1);
		TextView tvMain2 = (TextView) findViewById(R.id.tvMain2);
		TextView tvMain3 = (TextView) findViewById(R.id.tvMain3); 
		TextView tvMain4 = (TextView) findViewById(R.id.tvMain4);
		
		//Initilazing string values
		String valueBit = "";
		String valueMt = "";
		String valueBtce = "";
		String valueBtch = "";
		
		

		try {
			//Creating Json object first before parse process
			JSONObject objBit = new JSONObject(bitstamp);
			JSONObject objMt = new JSONObject(mtgox);
			JSONObject objBtce = new JSONObject(btce);
			JSONObject objBtch = new JSONObject(btch);
			
			//JsonParse 
			valueBit = objBit.getString("high");
			valueMt = objMt.getJSONObject("data").getJSONObject("high").getString("value");
			valueBtce = objBtce.getJSONObject("ticker").getString("high");
			valueBtch = objBtch.getJSONObject("ticker").getString("high");
			Log.d("Value ", "Value result is: " + valueBtce);
			
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}

		//Set results to textview 
		tvMain1.setText(valueBit);  
		tvMain2.setText(valueMt);
		tvMain3.setText(valueBtce);
		tvMain4.setText(valueBtch);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
