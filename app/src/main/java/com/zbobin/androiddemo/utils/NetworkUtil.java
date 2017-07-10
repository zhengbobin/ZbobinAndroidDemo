package com.zbobin.androiddemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/**
 *  判断网络状态
 *
 *  注：需要添加权限
 * 	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
 *  <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
 *
 *  @author zbobin
 */
public class NetworkUtil {

	/**
	 * 判断wifi网络是否链接
	 * @param inContext
	 * @return
	 */
	public static boolean isWiFiActive(Context inContext) {
		WifiManager mWifiManager = (WifiManager) inContext.getApplicationContext()
		.getSystemService(Context.WIFI_SERVICE);
		WifiInfo wifiInfo = mWifiManager.getConnectionInfo();
		int ipAddress = wifiInfo == null ? 0 : wifiInfo.getIpAddress();
		if (mWifiManager.isWifiEnabled() && ipAddress != 0) {
			return true;
		} else {
			return false;   
		}
	}

	/**
	 * 判断网络是否链接
	 * @param context
	 * @return
	 */
	public static boolean isNetworkAvailable(Context context) {
        if (context == null)
            return true;

		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity == null) {
			return false;
		} else {
			NetworkInfo info = connectivity.getActiveNetworkInfo();
			if(info == null){
				return false;
			}else{
				if(info.isAvailable()){
					return true;
				}

			}
		}
		return false;
	}

}
