package com.example.lin.testapplication.activity;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.lin.testapplication.base.BaseActivity;
import com.example.lin.testapplication.entity.Person;

import org.json.JSONObject;

/**
 * Created by 101912 on 2017/9/22.
 */

public class VolleyActivity extends BaseActivity {

    @Override
    public void initView() {

    }

    @Override
    public void setData() {
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://www.baidu.com", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }
}
