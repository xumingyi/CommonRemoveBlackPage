package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.widgethelper.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SubActivity extends BaseActivity {

    private Context mContext;
    private Unbinder mUnbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mContext = this;
        mUnbinder = ButterKnife.bind(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    /**
     * On click.
     *
     * @param v the v
     */
    @OnClick({R.id.title_bar_left_ll, R.id.title_bar_title})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.title_bar_left_ll:
                finish();
                break;
            case R.id.title_bar_title:
                break;
            default:
                break;
        }
    }

}
