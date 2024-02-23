package com.example.myfirstcollegeapplication;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyApplication_OnlineTransfer extends Application {

    public static final String TAG = MyApplication_OnlineTransfer.class.getSimpleName();

    private static MyApplication_OnlineTransfer mInstance;
    private RequestQueue mRequestQueue;
//    private MyPreferenceManager pref; // Add this line

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized MyApplication_OnlineTransfer getInstance() {
        return mInstance;
    }

//    public MyPreferenceManager getPrefManager() {
//        if (pref == null) {
//            pref = new MyPreferenceManager(this);
//        }7
//
//        return pref;
//    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
