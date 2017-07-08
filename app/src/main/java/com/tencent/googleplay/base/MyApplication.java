package com.tencent.googleplay.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

/**
 * 这是一个全局的类,用来提供上下文
 * Created by zhaoyang on 2017/7/8.
 */

public class MyApplication extends Application {

    private static Context mContext;
    private static Handler mMaintHreadHandler;
    private static int mMyTid;

    /**
     * 程序的入口,做一些初始化的操作
     */
    @Override
    public void onCreate() {
        mContext = getApplicationContext();
        mMaintHreadHandler = new Handler();
        /**
         * 获取主线程的线程id
         * myTid:Thread
         * myPid:Process
         * myUid:User
         */

        mMyTid = Process.myTid();
        super.onCreate();
    }

    /**
     * @return  得到上下文
     */
    public static Context getmContext() {
        return mContext;
    }

    /**
     * @return  得到主线程
     */
    public static Handler getmMaintHreadHandler() {
        return mMaintHreadHandler;
    }

    /**
     * @return  得到线程的id
     */
    public static int getmMyTid() {
        return mMyTid;
    }
}
