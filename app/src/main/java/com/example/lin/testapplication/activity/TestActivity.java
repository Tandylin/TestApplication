package com.example.lin.testapplication.activity;

import android.widget.Button;
import android.widget.TextView;

import com.example.lin.testapplication.R;
import com.example.lin.testapplication.base.BaseActivity;
import com.example.lin.testapplication.自定义组合控件.TitleBar;


/**
 * Created by 101912 on 2017/8/3.
 */

public class TestActivity extends BaseActivity {

    private TextView textView1;
    private TextView textView2;
    private Button button;
    private TitleBar titleBar;

    @Override
    public void initView() {
        setContentView(R.layout.activity_test);
        /*titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setListener(new TitleBar.TouchListener() {
            @Override
            public void onTouch() {
                Toast.makeText(getApplicationContext(), "点击了按钮", Toast.LENGTH_SHORT).show();
            }
        });*/
        /*textView1 = (TextView) findViewById(R.id.textView4);
        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("in", "lin").commit();
        textView1.setText(sharedPreferences.getString("in", "liasn"));
        button = (Button) findViewById(R.id.bt_button);

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long currentTime = System.currentTimeMillis();
                String result = dateFormat.format(currentTime);
                Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
            }
        });*/

    }
}
