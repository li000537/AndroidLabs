package com.example.emma.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends Activity {
    protected static final String ACTIVITY_NAME = "StartActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

         final Button button = (Button)findViewById(R.id.button);
         final Button button_chat = (Button)findViewById(R.id.button_chat);
         final Button button_weather = (Button)findViewById(R.id.button_weather) ;

         button.setOnClickListener(new View.OnClickListener(){
             public void onClick(View v){
                 Intent intent = new Intent(StartActivity.this, ListItemActivity.class);
                 startActivityForResult(intent, 50);
             }
         });
         button_chat.setOnClickListener(new View.OnClickListener(){
             public void onClick(View v){
               Intent intent = new Intent(StartActivity.this, NewChatWindow.class);
               startActivity(intent);
                 Log.i(ACTIVITY_NAME,"User clicked Start Chat");
             }
         });
         button_weather.setOnClickListener(new View.OnClickListener(){
             public void onClick(View v) {
                 Intent intent = new Intent(StartActivity.this, WeatherForecast.class);
                 startActivity(intent);
             }
         });

    }
        protected void onActivityResult(int requestCode, int responseCode, Intent data){
            if (requestCode == 50 && responseCode == Activity.RESULT_OK){
                Log.i(ACTIVITY_NAME,"Returned to StartActivity.onActivityResult");
                String messagePassed = data.getStringExtra("Response");
                CharSequence text = "ListItemActivity passed: ";
                Toast.makeText(getApplicationContext(),text + messagePassed,Toast.LENGTH_LONG).show();
            }
        }
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause");
    }
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME,"In onDestroy()");
    }
}
