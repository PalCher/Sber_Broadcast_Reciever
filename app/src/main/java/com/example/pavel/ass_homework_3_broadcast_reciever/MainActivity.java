package com.example.pavel.ass_homework_3_broadcast_reciever;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MyBroadcastReceiver myBroadcastReceiver;
    private IntentFilter myIntentFilter;
    private TextView tvState;
    private Button btnChange;
    private StateManager stateManager;
    public static final String MY_LOG = "My logs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        init();
    }

    private void initViews(){
        tvState = findViewById(R.id.tv_state);
        btnChange = findViewById(R.id.btn_change);
    }

    private void initListeners(){
        btnChange.setOnClickListener(new ChangeButtonListener());
    }

    private void init(){
        myBroadcastReceiver = new MyBroadcastReceiver(new ViewCallbackReceiver());
        myIntentFilter = new IntentFilter("com.example.pavel.ass_homework_3_broadcast_reciever");
    }

    private class ChangeButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            startService(StateService.newIntent(MainActivity.this));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myBroadcastReceiver, myIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myBroadcastReceiver);
    }

    private class ViewCallbackReceiver implements ViewCallback{

        @Override
        public void onStatusChanged(String state) {
            tvState.setText(state);
        }
    }
}
