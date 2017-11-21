package com.example.lin.testapplication.thread;

import android.text.TextUtils;

/**
 * Created by 101912 on 2017/10/12.
 */

public class ThreadTest {

    public static void main(String args[]) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    class ThreadRunnable implements Runnable {

        @Override
        public void run() {

        }
    }


}
