package com.example.td3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.td3.R;

public class MenuHelper {
    public static void inflateMenu(MenuInflater inflater, Menu menu) {
        inflater.inflate(R.menu.main_menu, menu);
    }

    public static boolean handleMenuItemClick(MenuItem item, Context context) {
        int id = item.getItemId();
        Activity activity = (Activity) context;;

        if (id == R.id.menu_item1) {
            Intent settingActivity = new Intent(activity.getApplicationContext(), SettingsActivity.class);
            activity.startActivity(settingActivity);
            return true;
        }
        if (id == R.id.menu_item2){
            activity.finish();
        }

        return false;
    }
    public static float getFontSize(Activity activity) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String fontSize = sharedPreferences.getString("font_size", "medium");

        float size;
        switch (fontSize) {
            case "small":
                size = 12;
                break;
            case "large":
                size = 30;
                break;
            case "medium":
            default:
                size = 18;
                break;
        }
        return size;
    }
}

