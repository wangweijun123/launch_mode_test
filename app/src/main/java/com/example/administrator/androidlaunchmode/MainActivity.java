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

/**
 * 1 OtherActivity的配置singleInstance
 *
 * Main(taskId=199) -> Other(taskId=200,注意这里启动main,不会把新的main拉入自己的任务栈中) -> Main(taskId=199,新实例)
 * -> back 回退到了第一个main -> 在回退 到了Other  --在回退 到了桌面
 *  Main(taskId=199) -> Other(taskId=200)
 * 产生新的任务栈(taskId变了),而且看到界面的跳转不一样哦(activity实例放到哪里任务栈)
 * 两次启动,只是产生一个实例, 第二次只会收到 onNewIntent
 *
 * 2 OtherActivity的配置singleTask: 同一个任务栈
 * Main(taskId=199) -> Other(taskId=199,与启动它在同一个任务栈) -> main(新实例)
 * -> other(旧实例,onNewIntent,并且弹出了在这个任务栈的其他class的实例,带有clear top 功能)
 *
 */

/**                 多个实例              备注
 * standard           是
 * singleTop        看栈顶情况         如果在栈顶,不会产生新的实例,onNewIntent(), 否则新实例,注意不会clear top
 * singleTask         否(一个实例)             （clear top）
 * singleInstance     否(一个实例)(产生新的任务栈,并且它启动其他的activty,不会拉入自己的栈中)
 *
 */
public class MainActivity extends BaseActivity {

    Button buttonMy;
    Button button2Other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("wangweijun_xxx","***********onCreate***********");

//        testAsyncTask();

//        startService(new Intent(getApplicationContext(),MyIntentService.class));

        test();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("wangweijun_xxx","***********onStart***********");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("wangweijun_xxx","***********onResume***********");
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
                Log.e("wangweijun_xxx","第一次跳转OtherActivity");
                /*try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(MainActivity.this,OtherActivity.class));
                Log.e("wangweijun_xxx","第二次跳转OtherActivity");*/
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
                    Log.e("wangweijun_xxx","thread id:"+Thread.currentThread().getId()+" start ");
                    try {
                        int times = 4;
                        for (int i = 0; i < times; i++) {
                            Log.i("wangweijun_xxx", "thread id:"+Thread.currentThread().getId()+"休息20ms"); //这个doInBackground就打印一个Log，然后sleep 20 毫秒
                            Thread.sleep(20);
                        }
                    } catch (Exception e) {

                    }
                    Log.e("wangweijun_xxx","thread id:"+Thread.currentThread().getId()+" end");
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 1);
            // .execute(1); 默认是窜行执行器，很坑
        }
    }
}
