package com.hpsgts.cloud.service.common.mq.message;

import com.alibaba.druid.support.json.JSONUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther 黄朴（Herper.Plain）
 * @Date 2017/12/4 下午2:51
 * @company 上海宏鹿信息技术服务有限公司
 */
public class SQLMessage implements Message{

    public static final String MSG_TYPE="SQL";
    private String sqlText;

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    @Override
    public String toJsonString() {
        Map<String,Object> items = new HashMap<String,Object>();
        items.put("msgtype",MSG_TYPE);
        Map<String,String> textMessage = new HashMap<String,String>();
        textMessage.put("content",sqlText);
        textMessage.put("params",null);

        items.put("text",textMessage);
        return JSONUtils.toJSONString(items);
    }
}
