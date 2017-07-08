package com.tencent.googleplay.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

import com.tencent.googleplay.base.MyApplication;

/**
 * Created by zhaoyang on 2017/7/8.
 */

public class UIUtils {
    /**获得上下文
     * @return
     */
    public static Context getContext() {
        return MyApplication.getmContext();
    }

    /**
     * @return 获得资源文件
     */
    public  static Resources getResource() {
        return getContext().getResources();
    }

    /**得到String.xml文件中的信息.
     * @param resid
     * @return
     */
    public static String getString(int resid) {
        return getResource().getString(resid);
    }

    /**
     * @param resid 得到String.xml文件中的字符数组的信息.
     * @return
     */
    public static String[] getStrings(int resid) {
        return getResource().getStringArray(resid);
    }

    /**得到color.xml的颜色值
     * @param resId
     * @return
     */
    public static int  getColor(int resId) {
        return getResource().getColor(resId);
    }
    /**
     * 得到应用程序包名
     */
    public static String getPackageName() {
        return getContext().getPackageName();
    }


}
