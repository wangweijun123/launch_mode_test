package com.example.administrator.androidlaunchmode;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TAG","*********BaseActivity***onCreate*************");
        Log.e("TAG","taskid:"+this.getTaskId()
                +" hashcode: "+this.hashCode());
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("TAG","************onNewIntent*************");
        Log.e("TAG","taskid:"+this.getTaskId()
                +" hashcode: "+this.hashCode());

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e("TAG","onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }
}
