package com.example.myapplication.widgethelper.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.R;

public class NavigationBar extends RelativeLayout {
    private ImageView titleBarLeftBtn;
    private ImageView titleBarRightBtn;
    private ImageView titleBarRightSecondBtn;
    private TextView titleBarTitle;

    public NavigationBar( Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.navigation_bar, this, true);
        titleBarLeftBtn =  findViewById(R.id.title_bar_left);
        titleBarRightBtn =  findViewById(R.id.title_bar_right);
        titleBarRightSecondBtn =  findViewById(R.id.title_bar_right_two);
        titleBarTitle = (TextView) findViewById(R.id.title_bar_title);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomTitleBar);
        if (attributes != null) {
            //处理titleBar背景色
            int titleBarBackGround = attributes.getResourceId(R.styleable.CustomTitleBar_title_background_color, Color.BLACK);

            //先处理左边按钮
            //获取是否要显示左边按钮
            boolean leftButtonVisible = attributes.getBoolean(R.styleable.CustomTitleBar_left_button_visible, true);
            if (leftButtonVisible) {
                titleBarLeftBtn.setVisibility(View.VISIBLE);
            } else {
                titleBarLeftBtn.setVisibility(View.INVISIBLE);
            }
//            设置左边按钮的文字
//            String leftButtonText = attributes.getString(R.styleable.CustomTitleBar_left_button_text);
//            if (!TextUtils.isEmpty(leftButtonText)) {
//                titleBarLeftBtn.setText(leftButtonText);
//                //设置左边按钮文字颜色
//                int leftButtonTextColor = attributes.getColor(R.styleable.CustomTitleBar_left_button_text_color, Color.WHITE);
//                titleBarLeftBtn.setTextColor(leftButtonTextColor);
//            }
            //设置左边图片icon 这里是二选一 要么只能是文字 要么只能是图片
            int leftButtonDrawable = attributes.getResourceId(R.styleable.CustomTitleBar_left_button_drawable, R.drawable.common_back);
            if (leftButtonDrawable != -1) {
                titleBarLeftBtn.setImageResource(leftButtonDrawable);  //设置到哪个控件的位置（）
            }

            //处理标题
            //先获取标题是否要显示图片icon
            int titleTextDrawable = attributes.getResourceId(R.styleable.CustomTitleBar_title_text_drawable, -1);
            if (titleTextDrawable != -1) {
                titleBarTitle.setBackgroundResource(titleTextDrawable);
            } else {
                //如果不是图片标题 则获取文字标题
                String titleText = attributes.getString(R.styleable.CustomTitleBar_title_text);
                if (!TextUtils.isEmpty(titleText)) {
                    titleBarTitle.setText(titleText);
                }

                // 字体大小
                String titleSize = attributes.getString(R.styleable.CustomTitleBar_title_size);
                if (!TextUtils.isEmpty(titleSize)) {
                    Float nTitleSize = Float.parseFloat(titleSize);
                    titleBarTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, nTitleSize);
                }

                //获取标题显示颜色
                int titleTextColor = attributes.getColor(R.styleable.CustomTitleBar_title_text_color, Color.WHITE);
                titleBarTitle.setTextColor(titleTextColor);
            }

            //先处理右边按钮
            //获取是否要显示右边按钮
            boolean rightButtonVisible = attributes.getBoolean(R.styleable.CustomTitleBar_right_button_visible, true);
            if (rightButtonVisible) {
                titleBarRightBtn.setVisibility(View.VISIBLE);
            } else {
                titleBarRightBtn.setVisibility(View.INVISIBLE);
            }
//            //设置右边按钮的文字
//            String rightButtonText = attributes.getString(R.styleable.CustomTitleBar_right_button_text);
//            if (!TextUtils.isEmpty(rightButtonText)) {
//                titleBarRightBtn.setText(rightButtonText);
//                //设置右边按钮文字颜色
//                int rightButtonTextColor = attributes.getColor(R.styleable.CustomTitleBar_right_button_text_color, Color.WHITE);
//                titleBarRightBtn.setTextColor(rightButtonTextColor);
//            }
            //设置右边图片icon 这里是二选一 要么只能是文字 要么只能是图片
            int rightButtonDrawable = attributes.getResourceId(R.styleable.CustomTitleBar_right_button_drawable, -1);
            if (rightButtonDrawable != -1) {
                titleBarRightBtn.setImageResource(rightButtonDrawable);  //设置到哪个控件的位置（）
            }

            //先处理右边第二个按钮
            //获取是否要显示右边按钮
            boolean rightButtonSecondVisible = attributes.getBoolean(R.styleable.CustomTitleBar_right_second_button_visible, true);
            if (rightButtonSecondVisible) {
                titleBarRightSecondBtn.setVisibility(View.VISIBLE);
            } else {
                titleBarRightSecondBtn.setVisibility(View.INVISIBLE);
            }
//            //设置右边按钮的文字
//            String rightSecondButtonText = attributes.getString(R.styleable.CustomTitleBar_right_second_button_text);
//            if (!TextUtils.isEmpty(rightButtonText)) {
//                titleBarRightSecondBtn.setText(rightButtonText);
//                //设置右边按钮文字颜色
//                int rightButtonTextColor = attributes.getColor(R.styleable.CustomTitleBar_right_second_button_text_color, Color.WHITE);
//                titleBarRightSecondBtn.setTextColor(rightButtonTextColor);
//            }
            //设置右边图片icon 这里是二选一 要么只能是文字 要么只能是图片
            int rightSecondButtonDrawable = attributes.getResourceId(R.styleable.CustomTitleBar_right_second_button_drawable, -1);
            if (rightSecondButtonDrawable != -1) {
                titleBarRightSecondBtn.setImageResource(rightSecondButtonDrawable);  //设置到哪个控件的位置（）
            }

            attributes.recycle();
        }
    }

    public void setTitleClickListener(OnClickListener onClickListener) {
        if (onClickListener != null) {
            titleBarLeftBtn.setOnClickListener(onClickListener);
            titleBarRightBtn.setOnClickListener(onClickListener);
        }
    }

    public ImageView getTitleBarLeftBtn() {
        return titleBarLeftBtn;
    }

    public ImageView getTitleBarRightBtn() {
        return titleBarRightBtn;
    }

    public TextView getTitleBarTitle() {
        return titleBarTitle;
    }

}
