package com.zbobin.androiddemo.entity;

/**
 * 接口统一管理类
 *
 * @author zbobin
 */

public class UrlData {

    // 接口的前缀地址
    public static String SERVER_URL;

    /**
     * 提供于测试服务器
     *
     */
    static {

        /**
         * 生产环境
         */
        SERVER_URL = "http://www.zbobin.com/";

    }

    //获取导航类别
    public static final String APP_KIND = SERVER_URL + "/app/kaifadaohang/api_kind.php";

}
