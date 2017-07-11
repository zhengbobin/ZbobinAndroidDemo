package com.zbobin.androiddemo.app.base.entity;

import com.zbobin.androiddemo.utils.GsonUtil;

/**
 * 基础JSON响应实体类
 *
 * @author zbobin
 */

public class MessageResponseEntity {

    private String status; // 状态码：200代表请求响应成功，401代表请求响应失败。参考 StaticData.java
    private String msg;    // 返回的文本信息

    public static MessageResponseEntity getInstance(String json) {
        return (MessageResponseEntity) GsonUtil.jsonToObject(json, MessageResponseEntity.class);
    }

    public String getStatus() {
        return status == null ? "" : status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
