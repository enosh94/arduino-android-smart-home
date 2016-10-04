package com.androidarduino;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class LDRActivity extends Activity implements View.OnClickListener {

    EditText ed1;
    Button b1;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "IpAdd";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ldr);

        View led20on = findViewById(R.id.led_20on);
        View led20off = findViewById(R.id.led_20off);


        led20on.setOnClickListener(this);
        led20off.setOnClickListener(this);



        ed1=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button2);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n  = ed1.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, n);
                editor.commit();
                Toast.makeText(LDRActivity.this,"Thanks",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void commandArduino(String url){
        try {
            HttpClient httpclient = new DefaultHttpClient();
            httpclient.execute(new HttpGet(url));
        } catch (Exception e) {
        }
    }

    public void onClick(View thisView) {

        EditText txtname1 = (EditText)findViewById(R.id.editText2);
        String IPAddress      =  txtname1.getText().toString();
        switch(thisView.getId()) {
            case R.id.led_20on:
                commandArduino("http://" + IPAddress + "/?cmd=31");
                Toast.makeText(getApplicationContext(), "led_15on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_20off:
                commandArduino("http://" + IPAddress + "/?cmd=32");
                Toast.makeText(getApplicationContext(), "led_15off", Toast.LENGTH_LONG).show();
                break;

        }
    }

}
