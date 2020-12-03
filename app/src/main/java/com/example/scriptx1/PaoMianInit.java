package com.example.scriptx1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;

import static com.example.scriptx1.scriptframe.toolLib.checkBoxAdapter;

public class PaoMianInit extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pao_mian_init);


        checkBoxAdapter(this,new int[]{
                R.id.checkBox3, R.id.checkBox,
                R.id.checkBox2, R.id.checkBox4,
                R.id.checkBox5, R.id.checkBox6,
                R.id.checkBox7

        });

    }



}
