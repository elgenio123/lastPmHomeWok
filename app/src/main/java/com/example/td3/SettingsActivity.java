package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private RadioGroup radioGroup;
    private  RadioButton radioButtonOption2, radioButtonOption, radioButtonOption3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        radioGroup = findViewById(R.id.radioGroup);
        radioButtonOption2 = findViewById(R.id.radioButtonOption2);


        radioButtonOption2.setChecked(true);

    }

    public void onClickSmallSize(View view) {
        saveFontSize("small");
        finish();
    }

    public void onClickMediumSize(View view) {
        saveFontSize("medium");
        finish();
    }

    public void onClickBigSize(View view) {
        saveFontSize("large");
        finish();
    }
    private void saveFontSize(String fontSize) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("font_size", fontSize);
        editor.apply();

    }
}