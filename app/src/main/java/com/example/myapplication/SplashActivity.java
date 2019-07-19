package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;

import com.example.myapplication.Utils.SpUtils;

public class SplashActivity extends BaseActivity {

    private Context mContext;
    Handler handler = new Handler();
    private int waitTime = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        mContext = this;

        //全屏，滑动弹出状态栏和单行栏
        if (Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

        //第三方库初始化等可以继续做延迟加上处理自己决定即可

        if(SpUtils.getValue(mContext, AccountConstants.IS_FIRST).equals(
                AccountConstants.SP_DEFAULT_STR)){
            SpUtils.setValue(mContext, AccountConstants.IS_FIRST, "true");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mContext.startActivity(new Intent(SplashActivity.this,
                            MainActivity.class));
                    finish();
                }
            }, waitTime);
        }else{
            mContext.startActivity(new Intent(SplashActivity.this,
                    MainActivity.class));
            finish();
        }

    }

    /**
     * 屏蔽物理返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        if (handler != null) {
            //If token is null, all callbacks and messages will be removed.
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
