package com.example.pavel.ass_homework_3_broadcast_reciever;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class StateService extends IntentService {

    public static final String MY_LOG = "My logs";
    public StateService() {
        super("my service");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(MY_LOG, "onCreate");
    }

    @Override
    protected void onHandleIntent( Intent intent) {
        Log.d(MY_LOG,"Service started");
        StateManager.getInstance().changeState();
        String state = StateManager.getInstance().getCurrentState();
        Log.d(MY_LOG,"State: " + state);
        Intent broadcastIntent = new Intent("com.example.pavel.ass_homework_3_broadcast_reciever");
        broadcastIntent.putExtra("state", state);
        broadcastIntent.addFlags(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES);
        sendBroadcast(broadcastIntent);
    }

    public static final Intent newIntent(Context context){
        Intent intent = new Intent(context, StateService.class);
        Log.d(MY_LOG, "Intent");
        return intent;

    }
}
