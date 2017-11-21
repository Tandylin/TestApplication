package com.example.lin.testapplication.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by 101912 on 2017/11/1.
 */

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    public static final String APP_ID = "wxf3536093a5f1ce76";
    public static final String APP_SECRET = "wxf3536093a5f1ce76";
    private IWXAPI mWeixinAPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWeixinAPI = WXAPIFactory.createWXAPI(this, APP_ID, true);
        mWeixinAPI.handleIntent(this.getIntent(), this);

    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        mWeixinAPI.handleIntent(intent, this);//必须调用此句话
    }


    //微信发送的请求将回调到onReq方法
    @Override
    public void onReq(BaseReq baseReq) {

    }

    //发送到微信请求的响应结果
    @Override
    public void onResp(BaseResp baseResp) {
        Log.d(">>>>>>>", "onResp");
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                Log.d(">>>>>>>", "ERR_OK");
                //发送成功
                SendAuth.Resp sendResp = (SendAuth.Resp) baseResp;
                if (sendResp != null) {
                    String code = sendResp.code;
                    getAccess_token(code);
                }
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                Log.d(">>>>>>>", "ERR_USER_CANCEL");
                //发送取消
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                Log.d(">>>>>>>", "ERR_AUTH_DENIED");
                //发送被拒绝
                break;
            default:
                //发送返回
                break;
        }
    }


    /**
     * 获取openid accessToken值用于后期操作
     *
     * @param code 请求码
     */
    private void getAccess_token(final String code) {
        String path = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
                + APP_ID
                + "&secret="
                + APP_SECRET
                + "&code="
                + code
                + "&grant_type=authorization_code";
        Log.d(">>>>>>>>", "getAccess_token：" + path);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(">>>>>>", "getAccess_token_result:" + response);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                    String openid = jsonObject.getString("openid").toString().trim();
                    String access_token = jsonObject.getString("access_token").toString().trim();
                    getUserMesg(access_token, openid);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
        /*//网络请求，根据自己的请求方式
        VolleyRequest.get(this, path, "getAccess_token", false, null, new VolleyRequest.Callback() {
            @Override
            public void onSuccess(String result) {
                Log.d(">>>>>>", "getAccess_token_result:" + result);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(result);
                    String openid = jsonObject.getString("openid").toString().trim();
                    String access_token = jsonObject.getString("access_token").toString().trim();
                    getUserMesg(access_token, openid);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(String errorMessage) {

            }
        });*/
    }


    /**
     * 获取微信的个人信息
     *
     * @param access_token
     * @param openid
     */
    private void getUserMesg(final String access_token, final String openid) {
        String path = "https://api.weixin.qq.com/sns/userinfo?access_token="
                + access_token
                + "&openid="
                + openid;
        Log.d(">>>>>>", "getUserMesg：" + path);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(">>>>>>", "getUserMesg_result:" + response);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                    String nickname = jsonObject.getString("nickname");
                    int sex = Integer.parseInt(jsonObject.get("sex").toString());
                    String headimgurl = jsonObject.getString("headimgurl");

                    Log.d(">>>>>>", "用户基本信息:");
                    Log.d(">>>>>>", "nickname:" + nickname);
                    Log.d(">>>>>>", "sex:" + sex);
                    Log.d(">>>>>>", "headimgurl:" + headimgurl);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
       /* //网络请求，根据自己的请求方式
        VolleyRequest.get(this, path, "getAccess_token", false, null, new VolleyRequest.Callback() {
            @Override
            public void onSuccess(String result) {
                Log.d(">>>>>>", "getUserMesg_result:" + result);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(result);
                    String nickname = jsonObject.getString("nickname");
                    int sex = Integer.parseInt(jsonObject.get("sex").toString());
                    String headimgurl = jsonObject.getString("headimgurl");

                    Log.d(">>>>>>", "用户基本信息:");
                    Log.d(">>>>>>", "nickname:" + nickname);
                    Log.d(">>>>>>", "sex:" + sex);
                    Log.d(">>>>>>", "headimgurl:" + headimgurl);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                finish();
            }

            @Override
            public void onError(String errorMessage) {

            }
        });*/
    }


}
