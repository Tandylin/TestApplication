package com.example.lin.testapplication.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by 101912 on 2017/11/13.
 */

public class MyHandler extends Handler {

    public MyHandler() {
        super();
    }

    public MyHandler(Looper looper) {
        super(looper);
    }

    @Override
    public void handleMessage(Message msg) {
        //...
        switch (msg.what) {
            //...
        }
    }
}
