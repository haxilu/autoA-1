package com.example.scriptx1.scriptframe;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scriptx1.MainActivity;

public class toolLib {

    static class checkBoxOnClick implements View.OnClickListener {
        @Override
        public void  onClick(View v) {
            CheckBox checkBox = ((CheckBox)v);
            SharedPreferences.Editor editor = MainActivity.sp.edit();
            String key = checkBox.getText().toString();
            boolean value = checkBox.isChecked();
            editor.putBoolean(key,value);
            editor.apply();
        }
    }


    public static void checkBoxAdapter(AppCompatActivity context, int[] viewId){
        for (int value : viewId) {
            CheckBox checkBox = context.findViewById(value);
            checkBox.setChecked(MainActivity.sp.getBoolean(checkBox.getText().toString(), true));
            checkBox.setOnClickListener(new checkBoxOnClick());
        }
    }


}
