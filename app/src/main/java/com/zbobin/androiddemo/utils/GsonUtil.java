package com.zbobin.androiddemo.utils;

import com.google.myjson.Gson;
import com.google.myjson.GsonBuilder;
import com.google.myjson.JsonSyntaxException;

/**
 * 对象、JSON字符串 转换工具
 *
 * @author zbobin
 */

public class GsonUtil {

    private static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm").create();

    /**
     * 对象 转 JSON字符串
     * @param obj
     * @return
     */
    public static String objectToJson(Object obj) {
        String temp = "";
        try {
            temp = gson.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            CommonLogUtil.e("-GsonUtile:objectToJson-", "数据转换异常");
        }
        return temp;
    }

    /**
     * JSON字符串 转 对象
     * @param json
     * @param classType
     * @return
     */
    public static Object jsonToObject(String json, Class<?> classType) {
        Object object = null;
        try {
            object = gson.fromJson(json, classType);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            CommonLogUtil.e("-GsonUtile:jsonToObject-", "数据转换异常");
            return null;
        }
        return object;
    }

}
