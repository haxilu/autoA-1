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

public class PaoMianInit extends AppCompatActivity {

    SharedPreferences sp ;
    Menu MyMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pao_mian_init);
        sp = MainActivity.sp;

        checkBoxAdapter(new int[]{
                R.id.checkBox3, R.id.checkBox,
                R.id.checkBox2, R.id.checkBox4,
                R.id.checkBox5, R.id.checkBox6,
                R.id.checkBox7

        });


    }

    class checkBoxOnClick implements OnClickListener{
        @Override
        public void onClick(View v) {
            CheckBox checkBox = ((CheckBox)v);
            SharedPreferences.Editor editor = sp.edit();
            String key = checkBox.getText().toString();
            boolean value = checkBox.isChecked();
            editor.putBoolean(key,value);
            editor.apply();
        }
    }


    public void checkBoxAdapter(int[] viewId){
        for (int value : viewId) {
            CheckBox checkBox = findViewById(value);
            checkBox.setChecked(sp.getBoolean(checkBox.getText().toString(), true));
            checkBox.setOnClickListener(new checkBoxOnClick());
        }
    }


    @Override //创建菜单
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu_init, menu);
        MyMenu=menu;
        return super.onCreateOptionsMenu(menu);
    }

//    @Override //菜单按钮点击事件
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menuInitF://保存按钮
//                SharedPreferences.Editor editor = sp.edit();
//                editor.putBoolean("checkBox3",checkBox3.isChecked());
//                editor.putBoolean("自动讨伐吕布",checkBox.isChecked());
//                editor.putBoolean("自动内政征收",checkBox2.isChecked());
//                editor.putBoolean("自动群雄涿鹿",checkBox4.isChecked());
//                editor.putBoolean("自动平叛剿匪",checkBox5.isChecked());
//                editor.putBoolean("自动联盟巡查",checkBox6.isChecked());
//                editor.putBoolean("自动灵符争夺",checkBox7.isChecked());
//                editor.apply();
//                break;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }

}
