package com.example.lin.testapplication.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.lin.testapplication.R;
import com.example.lin.testapplication.entity.SmsInfo;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by 101912 on 2017/7/28.
 */

public class GetSMSInfoActivity extends Activity {

    private Button button;
    private TextView textView;
    List<SmsInfo> smsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getsmsinfo);
        button = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.textView2);
        getSmsList();
        textView.setText(smsList.get(0).getBody());
    }

    public void getSmsList() {
        //获取所有短信的 Uri
        Uri uri = Uri. parse( "content://sms/");
        //获取ContentResolver对象
        ContentResolver contentResolver = this.getContentResolver();
        //根据Uri 查询短信数据
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        if ( null != cursor) {
            Log. i( TAG, "cursor.getCount():" + cursor.getCount());
            //根据得到的Cursor一条一条的添加到smsList(短信列表)中
            while (cursor.moveToNext()) {
                int _id = cursor.getInt(cursor.getColumnIndex("_id" ));
                int type = cursor.getInt(cursor.getColumnIndex("type" ));
                String address = cursor.getString(cursor.getColumnIndex( "address"));
                String body = cursor.getString(cursor.getColumnIndex("body" ));
                String date = cursor.getString(cursor.getColumnIndex("date" ));
                SmsInfo smsData = new SmsInfo(_id, type, address, body, date);
                smsList.add(smsData);
            }
            cursor.close();
        }

    }

}
