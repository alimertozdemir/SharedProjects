package com.example.bitcoinlive;

import java.util.ArrayList;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;

public class SplashScreenActivity extends Activity {

	ArrayList<String> result = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);

		String URL_MTGOX = "http://data.mtgox.com/api/2/BTCUSD/money/ticker";
		String URL_BITSTAMP = "https://www.bitstamp.net/api/ticker/";
		String URL_BTCE = "https://btc-e.com/api/2/btc_usd/ticker";
		String URL_BTCCH = "https://data.btcchina.com/data/ticker";

		AsyncHttpClient client = new AsyncHttpClient();
		client.get(URL_MTGOX, new AsyncHttpResponseHandler() {

			@Override
			public void onSuccess(String response) {

				result.add(0, response);

			}

		});

		AsyncHttpClient client2 = new AsyncHttpClient();
		client2.get(URL_BITSTAMP, new AsyncHttpResponseHandler() {

			@Override
			public void onSuccess(String response) {

				result.add(1, response);

			}

		});

		AsyncHttpClient client3 = new AsyncHttpClient();
		client3.get(URL_BTCE, new AsyncHttpResponseHandler() {

			@Override
			public void onSuccess(String response) {

				result.add(2, response);

			}

		});

		AsyncHttpClient client4 = new AsyncHttpClient();
		client4.get(URL_BTCCH, new AsyncHttpResponseHandler() {

			@Override
			public void onSuccess(String response) {

				result.add(3, response);
				Log.d("Result", "Result is: " + response);
				Intent intent = new Intent(getBaseContext(), MainActivity.class);
				intent.putStringArrayListExtra("result", result);
				startActivity(intent);
				finish();

			}

		});

	}
}
