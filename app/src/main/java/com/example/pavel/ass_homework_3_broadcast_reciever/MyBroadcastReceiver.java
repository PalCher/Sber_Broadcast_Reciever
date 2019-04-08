package com.example.pavel.ass_homework_3_broadcast_reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private ViewCallback mViewCallback;

    public MyBroadcastReceiver(ViewCallback mViewCallback) {
        this.mViewCallback = mViewCallback;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        this.mViewCallback.onStatusChanged(intent.getStringExtra("state"));
    }

}
