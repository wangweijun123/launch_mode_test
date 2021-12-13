package com.example.administrator.androidlaunchmode;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("wangweijun_xxx","*********BaseActivity***onCreate*************");
        Log.e("wangweijun_xxx","taskid:"+this.getTaskId()
                +" hashcode: "+this.hashCode());
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("wangweijun_xxx","************onNewIntent*************");
        Log.e("wangweijun_xxx","taskid:"+this.getTaskId()
                +" hashcode: "+this.hashCode());

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e("wangweijun_xxx","onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }
}
