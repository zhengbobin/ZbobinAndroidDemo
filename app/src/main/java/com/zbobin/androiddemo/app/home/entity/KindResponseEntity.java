package com.zbobin.androiddemo.app.home.entity;

import com.zbobin.androiddemo.app.base.entity.MessageResponseEntity;
import com.zbobin.androiddemo.utils.GsonUtil;
import java.util.ArrayList;

/**
 * 类别响应实体类
 *
 * @author zbobin
 *         2017/7/11.
 */

public class KindResponseEntity extends MessageResponseEntity{

    private ArrayList<KindEntity> kind;

    public static KindResponseEntity getInstance(String json) {
        return (KindResponseEntity) GsonUtil.jsonToObject(json, KindResponseEntity.class);
    }

    public ArrayList<KindEntity> getKind() {
        return kind;
    }
}
