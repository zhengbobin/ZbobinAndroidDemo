package com.zbobin.androiddemo.app.home.entity;

/**
 * 类别实体类
 *
 * @author zbobin
 *         2017/7/11.
 */

public class KindEntity {

    private String id;          //类别标识
    private String kind_name;   //类别名称
    private String kind_url;    //类别URL

    public String getId() {
        return id == null?"":id;
    }

    public String getKind_name() {
        return kind_name == null?"":kind_name;
    }

    public String getKind_url() {
        return kind_url == null?"":kind_url;
    }
}
