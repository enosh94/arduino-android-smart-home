package com.androidarduino;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class LightsActivity extends Activity implements View.OnClickListener {
    EditText ed1;
    Button b1;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "IpAdd";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);



        View led2on = findViewById(R.id.led_2on);
        View led2off = findViewById(R.id.led_2off);
        View led3on = findViewById(R.id.led_3on);
        View led3off = findViewById(R.id.led_3off);
        View led4on = findViewById(R.id.led_4on);
        View led4off = findViewById(R.id.led_4off);
        View led5on = findViewById(R.id.led_5on);
        View led5off = findViewById(R.id.led_5off);
        View led6on = findViewById(R.id.led_6on);
        View led6off = findViewById(R.id.led_6off);
        View led7on = findViewById(R.id.led_7on);
        View led7off = findViewById(R.id.led_7off);
        View led8on = findViewById(R.id.led_8on);
        View led8off = findViewById(R.id.led_8off);
        View led9on = findViewById(R.id.led_9on);
        View led9off = findViewById(R.id.led_9off);
        View led10on = findViewById(R.id.led_10on);
        View led10off = findViewById(R.id.led_10off);
        View led11on = findViewById(R.id.led_11on);
        View led11off = findViewById(R.id.led_11off);
        View led12on = findViewById(R.id.led_12on);
        View led12off = findViewById(R.id.led_12off);
        View led13on = findViewById(R.id.led_13on);
        View led13off = findViewById(R.id.led_13off);
        View led14on = findViewById(R.id.led_14on);
        View led14off = findViewById(R.id.led_14off);
        View led15on = findViewById(R.id.led_16on);
        View led15off = findViewById(R.id.led_16off);




        led2on.setOnClickListener(this);
        led2off.setOnClickListener(this);
        led3on.setOnClickListener(this);
        led3off.setOnClickListener(this);
        led4on.setOnClickListener(this);
        led4off.setOnClickListener(this);
        led5on.setOnClickListener(this);
        led5off.setOnClickListener(this);
        led6on.setOnClickListener(this);
        led6off.setOnClickListener(this);
        led7on.setOnClickListener(this);
        led7off.setOnClickListener(this);
        led8on.setOnClickListener(this);
        led8off.setOnClickListener(this);
        led9on.setOnClickListener(this);
        led9off.setOnClickListener(this);
        led10on.setOnClickListener(this);
        led10off.setOnClickListener(this);
        led11on.setOnClickListener(this);
        led11off.setOnClickListener(this);
        led12on.setOnClickListener(this);
        led12off.setOnClickListener(this);
        led13on.setOnClickListener(this);
        led13off.setOnClickListener(this);
        led14on.setOnClickListener(this);
        led14off.setOnClickListener(this);
        led15on.setOnClickListener(this);
        led15off.setOnClickListener(this);


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
                Toast.makeText(LightsActivity.this,"Thanks",Toast.LENGTH_LONG).show();
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
            case R.id.led_2on:
                commandArduino("http://" + IPAddress + "/?cmd=3");
                Toast.makeText(getApplicationContext(), "led_2on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_2off:
                commandArduino("http://" + IPAddress + "/?cmd=4");
                Toast.makeText(getApplicationContext(), "led_2off", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_3on:
                commandArduino("http://" + IPAddress + "/?cmd=5");
                Toast.makeText(getApplicationContext(), "led_2on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_3off:
                commandArduino("http://" + IPAddress + "/?cmd=6");
                Toast.makeText(getApplicationContext(), "led_2off", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_4on:
                commandArduino("http://" + IPAddress + "/?cmd=7");
                Toast.makeText(getApplicationContext(), "led_2on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_4off:
                commandArduino("http://" + IPAddress + "/?cmd=8");
                Toast.makeText(getApplicationContext(), "led_2off", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_5on:
                commandArduino("http://" + IPAddress + "/?cmd=9");
                Toast.makeText(getApplicationContext(), "led_2on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_5off:
                commandArduino("http://" + IPAddress + "/?cmd=10");
                Toast.makeText(getApplicationContext(), "led_2off", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_6on:
                commandArduino("http://" + IPAddress + "/?cmd=11");
                Toast.makeText(getApplicationContext(), "led_2on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_6off:
                commandArduino("http://" + IPAddress + "/?cmd=12");
                Toast.makeText(getApplicationContext(), "led_2off", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_7on:
                commandArduino("http://" + IPAddress + "/?cmd=13");
                Toast.makeText(getApplicationContext(), "led_2on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_7off:
                commandArduino("http://" + IPAddress + "/?cmd=14");
                Toast.makeText(getApplicationContext(), "led_2off", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_8on:
                commandArduino("http://" + IPAddress + "/?cmd=15");
                Toast.makeText(getApplicationContext(), "led_2on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_8off:
                commandArduino("http://" + IPAddress + "/?cmd=16");
                Toast.makeText(getApplicationContext(), "led_2off", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_9on:
                commandArduino("http://" + IPAddress + "/?cmd=17");
                Toast.makeText(getApplicationContext(), "led_2on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_9off:
                commandArduino("http://" + IPAddress + "/?cmd=18");
                Toast.makeText(getApplicationContext(), "led_2off", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_10on:
                commandArduino("http://" + IPAddress + "/?cmd=19");
                Toast.makeText(getApplicationContext(), "led_2on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_10off:
                commandArduino("http://" + IPAddress + "/?cmd=20");
                Toast.makeText(getApplicationContext(), "led_2off", Toast.LENGTH_LONG).show();
                break;

            case R.id.led_11on:
                commandArduino("http://" + IPAddress + "/?cmd=21");
                Toast.makeText(getApplicationContext(), "led_2on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_11off:
                commandArduino("http://" + IPAddress + "/?cmd=22");
                Toast.makeText(getApplicationContext(), "led_2off", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_12on:
                commandArduino("http://" + IPAddress + "/?cmd=23");
                Toast.makeText(getApplicationContext(), "led_2on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_12off:
                commandArduino("http://" + IPAddress + "/?cmd=24");
                Toast.makeText(getApplicationContext(), "led_2off", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_13on:
                commandArduino("http://" + IPAddress + "/?cmd=25");
                Toast.makeText(getApplicationContext(), "led_2on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_13off:
                commandArduino("http://" + IPAddress + "/?cmd=26");
                Toast.makeText(getApplicationContext(), "led_2off", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_14on:
                commandArduino("http://" + IPAddress + "/?cmd=27");
                Toast.makeText(getApplicationContext(), "led_2on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_14off:
                commandArduino("http://" + IPAddress + "/?cmd=28");
                Toast.makeText(getApplicationContext(), "led_2off", Toast.LENGTH_LONG).show();
                break;



            case R.id.led_16on:
                commandArduino("http://" + IPAddress + "/?cmd=31");
                Toast.makeText(getApplicationContext(), "led_2on", Toast.LENGTH_LONG).show();
                break;
            case R.id.led_16off:
                commandArduino("http://" + IPAddress + "/?cmd=32");
                Toast.makeText(getApplicationContext(), "led_2off", Toast.LENGTH_LONG).show();
                break;

        }
    }
}
