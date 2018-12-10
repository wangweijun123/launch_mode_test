package com.example.administrator.androidlaunchmode;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends BaseActivity {

    Button buttonMy;
    Button button2Other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TAG","***********onCreate***********");

//        testAsyncTask();

        startService(new Intent(getApplicationContext(),MyIntentService.class));

        test();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG","***********onStart***********");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG","***********onResume***********");
    }

    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_my:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,MainActivity.class);
                startActivity(intent);

                break;
            case R.id.button2_other:
                startActivity(new Intent(MainActivity.this,OtherActivity.class));
                break;
        }
    }


    public void  test() {
        ListView lv =  null;
//        lv.setAdapter(new SimpleAdapter());

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        TextView tv = new TextView(getApplicationContext());
        tv.setText("xxx");
        tv.setTextColor(Color.BLACK);
        toast.setView(tv);
        toast.show();

      /*  TextView tv = new TextView(getApplicationContext());
        tv.setText("xxx");
        tv.setTextColor(Color.BLACK);
        showToast(getApplicationContext(), tv);*/
    }

    public static void showToast(Context context, View view){
        Toast mViewToast = null;
        if(null == mViewToast){
            mViewToast = new Toast(context);
        }
        mViewToast.setDuration(Toast.LENGTH_SHORT);
        mViewToast.setView(view);
        mViewToast.show();
    }

    private void testAsyncTask() {
        for (int i=0; i<10; i++) {
            new AsyncTask<Integer, Void, Void>(){
                @Override
                protected Void doInBackground(Integer... integers) {
                    Log.e("TAG","thread id:"+Thread.currentThread().getId()+" start ");
                    try {
                        int times = 4;
                        for (int i = 0; i < times; i++) {
                            Log.i("TAG", "thread id:"+Thread.currentThread().getId()+"休息20ms"); //这个doInBackground就打印一个Log，然后sleep 20 毫秒
                            Thread.sleep(20);
                        }
                    } catch (Exception e) {

                    }
                    Log.e("TAG","thread id:"+Thread.currentThread().getId()+" end");
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 1);
            // .execute(1); 默认是窜行执行器，很坑
        }
    }
}
