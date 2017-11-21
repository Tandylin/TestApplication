package com.example.lin.testapplication.entity;

/**
 * Created by 101912 on 2017/7/28.
 */

public class SmsInfo {

    private int _id;
    private int type;
    private String address;
    private String body;
    private String data;

    public SmsInfo(int _id, int type, String address, String body, String data) {
        this._id = _id;
        this.type = type;
        this.address = address;
        this.body = body;
        this.data = data;
    }

    public String getBody() {
        return body;
    }

}
