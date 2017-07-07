package com.zbobin.androiddemo.utils;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Toast工具类
 */

public class ToastUtil {

    private static Toast toast;
    private static Toast toast2;

    public static void showMessage(Context context, String msg) {
        showMessage(context, msg, Toast.LENGTH_SHORT);
    }

    public static void showMessage(Context context, int resId) {
        showMessage(context, resId, Toast.LENGTH_SHORT);
    }

    /**
     * show a message with custom duration
     */
    public static void showMessage(Context context, String msg, int duration) {
        try {
            if (toast == null) {
                toast = Toast.makeText(context, msg, duration);
            } else {
                toast.setText(msg);
                toast.setDuration(duration);
            }
            toast.show();
        } catch (Exception e) {

        }
    }

    public static void showMessage(Context context, int resId, int duration) {
        try {
            if (toast == null) {
                toast = Toast.makeText(context, resId, duration);
            } else {
                toast.setText(resId);
                toast.setDuration(duration);
            }
            toast.show();
        } catch (Exception e) {

        }
    }

}
