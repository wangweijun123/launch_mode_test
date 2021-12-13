package com.example.administrator.androidlaunchmode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class OtherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Log.e("wangweijun_xxx","********OtherActivity***onCreate***********");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("wangweijun_xxx","********OtherActivity***onStart***********");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("wangweijun_xxx","********OtherActivity***onResume***********");
    }

    public void loadclick(View v){
        startActivity(new Intent(OtherActivity.this,MainActivity.class));
    }
}
