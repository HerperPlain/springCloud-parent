package com.hpsgts.cloud.service.common.mq.em;

/**
 * @Auther hpsgts
 * @Date 2017/12/4 下午2:05
 */
public enum QueueEnum {
    CRM_QUEUE("crm_queue");//后台消息队列

    private String code;

    QueueEnum(String code) {
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
