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

public class DoorActivity extends Activity implements View.OnClickListener {

    EditText ed1;
    Button b1;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "IpAdd";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door);

        View led1on = findViewById(R.id.led_1on);
        View led1off = findViewById(R.id.led_1off);


        led1on.setOnClickListener(this);
        led1off.setOnClickListener(this);



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
                Toast.makeText(DoorActivity.this,"Thanks",Toast.LENGTH_LONG).show();
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
            case R.id.led_1on:
                commandArduino("http://" + IPAddress + "/?cmd=1");
                Toast.makeText(getApplicationContext(), "Door Opened", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_1off:
                commandArduino("http://" + IPAddress + "/?cmd=2");
                Toast.makeText(getApplicationContext(), "Door Closed", Toast.LENGTH_LONG).show();
                break;

        }
    }

}
