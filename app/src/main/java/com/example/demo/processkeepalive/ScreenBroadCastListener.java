package com.example.demo.processkeepalive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class ScreenBroadCastListener {
    public interface ScreenListener{
        public void screenOn();
        public void screenOff();
    }
    public ScreenListener listener;
    private Context context;
    public ScreenBroadCastListener(Context context){
        this.context = context;
    }
    /**
     * 息屏和亮屏广播
     * **/
    BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(Intent.ACTION_SCREEN_ON.equals(action)){
                listener.screenOn();
            }else if(Intent.ACTION_SCREEN_OFF.equals(action)){
                listener.screenOff();
            }
        }
    };
    public void registerListener(ScreenListener listener){
        this.listener = listener;
        registerListener();
    }
    /**
    * 注册息屏和亮屏广播
    * */
    public void registerListener(){
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        context.registerReceiver(receiver,filter);
    }
    public void unRegisterListener(){
        context.unregisterReceiver(receiver);
    }

}
