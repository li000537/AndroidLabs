package com.example.emma.androidlabs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemActivity extends Activity {
    protected static final String ACTIVITY_NAME = "ListItemActivity";
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageButton imageButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        Switch switchButton = (Switch)findViewById(R.id.switch_item);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton switchButton, boolean isChecked){
                if(isChecked){
                    CharSequence text = "Switch is on";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(getApplicationContext(),text,duration);
                    toast.show();
                }
                if(!isChecked){
                    CharSequence text = "Switch is off";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getApplicationContext(),text,duration);
                    toast.show();
                }
            }
        });
        CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox_item);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
                if(isChecked){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListItemActivity.this);
                    builder.setMessage(R.string.dialog_message).
                            setTitle(R.string.dialog_title).
                            setPositiveButton(R.string.dialog_OK, new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog, int id){
                                    Intent resultIntent = new Intent();
                                    resultIntent.putExtra("Response","Here is my response");
                                    setResult(Activity.RESULT_OK,resultIntent);
                                    finish();
                                }
                            }).
                            setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            }).show();
                }
            }
        });
        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePictureIntent.resolveActivity(getPackageManager())!=null)
                    startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
            }
        });
    }
    protected void onActivityResult(int requestCode, int responseCode, Intent data){
        setResult(Activity.RESULT_OK);
        if(requestCode == REQUEST_IMAGE_CAPTURE && responseCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");

            imageButton.setImageBitmap(bitmap);
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
        Log.i(ACTIVITY_NAME, "In onPause()");
    }
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}
