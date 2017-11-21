package com.example.lin.testapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by 101912 on 2017/7/27.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    public MyBroadcastReceiver() {
        super();
    }


    //由于broadcastreceiver在10s内没有相应，便会抛出ARN，所以不便在onReceive中处理耗时任务
    //如有，一般开启一个service来处理
    @Override
    public void onReceive(Context context, Intent intent) {
        //终止广播，可用通过setPriority来设置广播接收器的优先级（-1000~1000）
        abortBroadcast();
    }
}
