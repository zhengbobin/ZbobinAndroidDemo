package com.zbobin.androiddemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Preference工具
 *
 * @author zbobin
 */

public class PreferenceUtil {

    private static final String SAVE_NAME = "UserSaveName";
    private static PreferenceUtil instance = null;
    private static SharedPreferences settings = null;
    private static SharedPreferences.Editor editor = null;

    public static PreferenceUtil getInstance(Context context) {
        if (instance == null) {
            instance = new PreferenceUtil();
            settings = context.getSharedPreferences(SAVE_NAME, 0);
            editor = settings.edit();
        }
        return instance;
    }


    /**
     * 实例
     */
    public static final String EXAMPLE = "example";
    public String getExample() {
        return getStringValue(EXAMPLE);
    }
    public void setExample(String score) {
        setStringValue(EXAMPLE, score);
    }



    /**
     * ===============工具方法===================
     */

    public void setStringValue(String key, String value) {
        editor.putString(key, value == null ? "" : value);
        editor.commit();
    }

    public String getStringValue(String key) {
        return settings.getString(key, "");
    }

    public void setBooleanValue(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBooleanValue(String key, Boolean value) {
        return settings.getBoolean(key, value);
    }

    public void setIntegerValue(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public int getIntegerValue(String key, int defaultValue) {
        return settings.getInt(key, defaultValue);
    }

}
