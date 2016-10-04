package com.androidarduino;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity{

	EditText ed1;
	Button b1;
	public static final String MyPREFERENCES = "MyPrefs";
	public static final String Name = "IpAdd";
	SharedPreferences sharedpreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		StrictMode.ThreadPolicy policy = new StrictMode.
		ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	public void lights(View view){
		startActivity(new Intent(MainActivity.this,LightsActivity.class));
	}
	public void doors(View view){
		startActivity(new Intent(MainActivity.this,DoorActivity.class));
	}
	public void temprature(View view){
		startActivity(new Intent(MainActivity.this,TemperatureActivity.class));
	}
	public void motion(View view){
		startActivity(new Intent(MainActivity.this,MotionActivity.class));
	}
	public void LDR(View view){
		startActivity(new Intent(MainActivity.this,LDRActivity.class));
	}

}
