package com.example.td3;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LevelActivity extends AppCompatActivity {
    public static final String EXTRA_LAUNCHES = "EXTRA_LAUNCHES";

    private TextView textView, textView2,message;

    public static int timesCreated = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        System.out.println("Called onCreate() from LevelActivity");
        Button backButton;
        backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        timesCreated++;

        textView2 = findViewById(R.id.textView3);
        textView = findViewById(R.id.textView2);
        message = findViewById(R.id.message);

        textView2.setText("Activity Created " + timesCreated+" times");
        Intent intent = getIntent();
        int level = intent.getIntExtra(MainActivity.EXTRA_LEVEL, 1);
        textView.setText("Level : "+ level);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        MenuHelper.inflateMenu(inflater, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return MenuHelper.handleMenuItemClick(item, this) || super.onOptionsItemSelected(item);
    }

    @Override
    public void finish(){
        Intent data = new Intent();
        data.putExtra(EXTRA_LAUNCHES, timesCreated);
        setResult(RESULT_OK, data);
        super.finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Called onStart() from LevelActivity");
        Activity activity = new Activity();
       // Context context = (MainActivity) activity;
        float size = MenuHelper.getFontSize(this);
        textView.setTextSize(size);
        textView2.setTextSize(size);
        message.setTextSize(size);
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Called onResume() from LevelActivity");
    }
    @Override
    protected  void onPause() {

        System.out.println("Called onPause() from LevelActivity");
        super.onPause();
    }
    @Override
    protected void onStop() {

        System.out.println("Called onStop() from LevelActivity");
        super.onStop();
    }
    @Override
    protected void onDestroy() {

        System.out.println("Called onDestroy() from LevelActivity");
        super.onDestroy();
    }
    @Override
    protected void onRestart(){

        super.onRestart();
        System.out.println("Called onDestroy() from LevelActivity");
    }
}