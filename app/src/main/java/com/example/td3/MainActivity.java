package com.example.td3;

//import static com.example.td3.LevelActivity.EXTRA_NUMBER;

import static com.example.td3.LevelActivity.EXTRA_LAUNCHES;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_LEVEL = "EXTRA_LEVEL";
    private static final int NUMBER_OF_LAUNCHES_REQUEST = 0;
    private TextView textView, textView2,lnumberV;
    private  int score = 0, level = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("Called onCreate() from TD3Activity");

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        lnumberV = findViewById(R.id.textView3);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_item1:
                Intent settingActivity = new Intent(this, SettingsActivity.class);
                startActivity(settingActivity);
                return true;
            case R.id.menu_item2:
                Log.d("Menu", ""+item.getTitle().toString()+" selected ");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickStart(View view) {
        if (score == 4){
            level++;
            score = 0;
            Intent intent = new Intent(this, LevelActivity.class);
            intent.putExtra(EXTRA_LEVEL, level);
            startActivityForResult(intent, NUMBER_OF_LAUNCHES_REQUEST);
            //finish();
        }
        else
            score++;
        textView.setText("Score : "+score);
        textView2.setText("Level : "+ level);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NUMBER_OF_LAUNCHES_REQUEST && resultCode == RESULT_OK) {
            int launches = data.getIntExtra(EXTRA_LAUNCHES, 0);
            lnumberV.setText("Number of times level activity created "+launches);
        }
    }

    public void onClickReStart(View view) {
        score = 0;
        level = 1;
        textView.setText("Score : "+score);
        textView2.setText("Level : "+ level);
    }
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Called onStart() from TD3Activity");
        float size = MenuHelper.getFontSize(this);
        textView.setTextSize(size);
        textView2.setTextSize(size);
        lnumberV.setTextSize(size);
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Called onResume() from TD3Activity");
    }
    @Override
    protected  void onPause() {

        System.out.println("Called onPause() from TD3Activity");
        super.onPause();
    }
    @Override
    protected void onStop() {

        System.out.println("Called onStop() from TD3Activity");
        super.onStop();
    }
    @Override
    protected void onDestroy() {

        System.out.println("Called onDestroy() from TD3Activity");
        super.onDestroy();
    }
    @Override
    protected void onRestart(){

        super.onRestart();
        System.out.println("Called onDestroy() from TD3Activity");
    }

}