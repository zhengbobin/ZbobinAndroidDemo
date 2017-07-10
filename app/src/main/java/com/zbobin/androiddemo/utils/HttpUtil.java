package com.zbobin.androiddemo.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zbobin.androiddemo.R;
import com.zbobin.androiddemo.entity.StaticData;

/**
 * 网络访问工具类
 *
 * @author zbobin
 */

public class HttpUtil {

    private static AsyncHttpClient client = new AsyncHttpClient();

    static {
        client.setTimeout(15000); // 设置链接超时，如果不设置，默认为10s
    }

    public static AsyncHttpClient getClient() {
        return client;
    }

    /**
     * 用于注销登录状态下的请求
     */
    public static RequestParams getRequestParams(Context context) {
        RequestParams params = new RequestParams();
        PreferenceUtil pref = PreferenceUtil.getInstance(context);
        params.put(StaticData.APP_VERSION, getVersionName(context));
        //手机类型(android或ios)
        params.put(StaticData.PHONE_TYPE, "android");
        //设备id
        params.put(StaticData.PHONE_ID, getPid(context));
        //系统版本(如android2.3.3)
        params.put(StaticData.VERSION, android.os.Build.VERSION.RELEASE);

        return params;
    }

    /**
     * 获取当前应用的版本信息
     */
    public static String getVersionName(Context context) {
        try {
            if (context == null) {
                return "";
            }
            // 获取packagemanager的实例
            PackageManager packageManager = context.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            if (packageManager != null) {
                PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                return packInfo.versionName;
            } else {
                return "";
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取当前设备id
     */
    public static String getPid(Context context) {
        try {
            if (context == null) {
                return "";
            } else {
                return ((TelephonyManager) (context.getSystemService(Context.TELEPHONY_SERVICE))).getDeviceId();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 不带参数的post请求，获取一个String对象
     */
    public static void post(Context context, String url, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            ToastUtil.showMessage(context, R.string.network_is_disabled);
            return;
        }
        client.post(url, asyncHttpResponseHandler);
    }

    /**
     * 带参数的post请求，获取一个String对象
     */
    public static void post(Context context, String url, RequestParams params,
                            AsyncHttpResponseHandler asyncHttpResponseHandler) {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            ToastUtil.showMessage(context, R.string.network_is_disabled);
            return;
        }
        client.post(url, params, asyncHttpResponseHandler);

    }

}
