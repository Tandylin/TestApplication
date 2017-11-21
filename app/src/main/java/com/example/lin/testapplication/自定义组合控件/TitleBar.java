package com.example.lin.testapplication.自定义组合控件;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lin.testapplication.R;

/**
 * Created by 101912 on 2017/11/20.
 */

public class TitleBar extends LinearLayout implements View.OnClickListener{
    TextView textView;
    ImageView imageView;
    LinearLayout background;

    public TitleBar(Context context) {
        super(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.titlebar, this);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.TitleBar);
        initView(typedArray);
    }

    private void initView(TypedArray typedArray) {
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.image);
        background = (LinearLayout) findViewById(R.id.ll_background);
        int image_height = (int) typedArray.getDimension(R.styleable.TitleBar_image_height, 20);
        int image_width = (int) typedArray.getDimension(R.styleable.TitleBar_image_width, 20);
        int image_src = typedArray.getResourceId(R.styleable.TitleBar_image_src, 0);
        int background_color = typedArray.getColor(R.styleable.TitleBar_background_color, 0);
        String text = typedArray.getString(R.styleable.TitleBar_text);
        textView.setText(text);
        imageView.setImageResource(image_src);
        background.setBackgroundColor(background_color);
        LayoutParams layoutParams = new LayoutParams(image_width, image_height);
        imageView.setLayoutParams(layoutParams);
        typedArray.recycle();
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onTouch();
    }

    public void setListener(TouchListener listener) {
        this.listener = listener;
    }

    private TouchListener listener;

    public interface TouchListener {
        void onTouch();
    }


}
