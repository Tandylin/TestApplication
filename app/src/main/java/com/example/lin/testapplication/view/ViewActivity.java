package com.example.lin.testapplication.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lin.testapplication.R;
import com.example.lin.testapplication.activity.MainActivity;
import com.example.lin.testapplication.base.BaseActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.ref.WeakReference;
import java.util.Locale;

/**
 * Created by 101912 on 2017/11/10.
 */

public class ViewActivity extends BaseActivity {
    MyHandler myHandler;

    ThreadLocal<Boolean> myThreadLocal = new ThreadLocal<>();

    private String TAG = ">>>>>>>>";

    @Override
    public void initView() {
        setContentView(R.layout.activity_view);
        baseLayout.setTopLayoutVisibility(View.GONE);
        Button button = (Button) findViewById(R.id.mb_button);
        Log.w(">>>>>", "MAC: "+getLocalMacAddress());
        Log.w(">>>>>", "IMEI: "+getIMEI(mContext));
        Log.w(">>>>>", "Operators: "+getOperators(mContext));
        String carrier = android.os.Build.MANUFACTURER;
        Log.w(">>>>>", "Operators: "+android.os.Build.MANUFACTURER);


        File file = new File("/system/fonts");
        File[] files = file.listFiles(new FilenameFilter() {

            public boolean accept(File dir, String name) {

                if (name.endsWith("ttf"))

                {
                    return true;
                }
                return false;
            }

        });
        for (File f : files) {
            TTFParser ttfParser = new TTFParser();
            try {
                ttfParser.parse(f.getAbsolutePath());
//                Toast.makeText(mContext, ttfParser.getFontName(), Toast.LENGTH_LONG).show();
                Log.w(">>>>>", ttfParser.getFontName());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        Configuration configuration = new Configuration();


        Locale locale = getResources().getConfiguration().locale;
        locale.getLanguage();
        Log.w(">>>>>", locale.getLanguage());
        Log.w(">>>>>", (button.getTextSize() / getResources().getDisplayMetrics().density) + "");
        Log.w(">>>>>", button.getFontFeatureSettings());
        button.getTypeface();

    }


    public static String getLocalMacAddress() {
        String macSerial = null;
        String str = "";
        try {
            Process pp = Runtime.getRuntime().exec(
                    "cat /sys/class/net/wlan0/address ");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);


            for (; null != str; ) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();// 去空格
                    break;
                }
            }
        } catch (IOException ex) {
            // 赋予默认值
            ex.printStackTrace();
        }
        return macSerial;

    }

    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }


    public String getOperators(Context context) {
        // 移动设备网络代码（英语：Mobile Network Code，MNC）是与移动设备国家代码（Mobile Country Code，MCC）（也称为“MCC /
        // MNC”）相结合, 例如46000，前三位是MCC，后两位是MNC 获取手机服务商信息
        String OperatorsName = "";
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        String IMSI = telephonyManager.getSubscriberId();
//        String IMSI =  (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE).getSubscriberId();
        // IMSI号前面3位460是国家，紧接着后面2位00 运营商代码
        System.out.println(IMSI);
        if (IMSI.startsWith("46000") || IMSI.startsWith("46002") || IMSI.startsWith("46007")) {
            OperatorsName = "中国移动";
        } else if (IMSI.startsWith("46001") || IMSI.startsWith("46006")) {
            OperatorsName = "中国联通";
        } else if (IMSI.startsWith("46003") || IMSI.startsWith("46005")) {
            OperatorsName = "中国电信";
        }
        return OperatorsName;
    }


    private void readFile(String filePath) {
        if (filePath == null) return;

        File file = new File(filePath);
        if (file.isDirectory()) {
            Log.d(TAG, filePath + " is directory");
            return;
        } else {
            try {
                InputStream is = new FileInputStream(file);
                if (is != null) {
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    String line;
                    while ((line = br.readLine()) != null) {
                        Log.d(TAG, line);
                    }
                }
            } catch (FileNotFoundException e) {
                Log.d(TAG, filePath + " doesn't found!");
            } catch (IOException e) {
                Log.d(TAG, filePath + " read exception, " + e.getMessage());
            }
        }
    }

}
