package com.example.demo.processkeepalive;

import android.app.Activity;
import android.content.Context;

import java.lang.ref.WeakReference;

public class ScreenManager {
    public static ScreenManager gDefault;
    private final Context context;

    public static ScreenManager getInstance(Context context){
        if(gDefault == null){
            gDefault = new ScreenManager(context);
        }
        return  gDefault;
    }
    private ScreenManager(Context context){
        this.context = context;
    }
    public void startActivity(){
        onePxActivity.startSelf(context);
    }
    private WeakReference<Activity> mActivity;
    public void setActivity(Activity activity){
        mActivity = new WeakReference<>(activity);
    }
    public void finishActivity(){
        if(mActivity !=null){
            Activity activity = mActivity.get();
            if(activity !=null){
                activity.finish();
            }
        }
    }
}
