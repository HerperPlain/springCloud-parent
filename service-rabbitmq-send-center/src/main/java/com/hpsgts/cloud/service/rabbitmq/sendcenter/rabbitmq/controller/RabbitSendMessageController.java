package com.hpsgts.cloud.service.rabbitmq.sendcenter.rabbitmq.controller;

import com.hpsgts.cloud.service.common.mq.em.QueueEnum;
import com.hpsgts.cloud.service.common.mq.message.SQLMessage;
import com.hpsgts.cloud.service.rabbitmq.sendcenter.rabbitmq.service.RabbitSendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther 黄朴（Herper.Plain）
 * @Date 2017/12/4 下午7:07
 * @Company 上海宏鹿信息技术服务有限公司
 */
@RestController
@RequestMapping(value = "/rabbit")
public class RabbitSendMessageController {
    @Autowired
    RabbitSendMessageService rabbitSendMessageService;
    @RequestMapping(value = "/sendCrmMessage.do")
    public String sendCrmMessage(HttpServletRequest request, HttpServletResponse response,SQLMessage model){
        rabbitSendMessageService.sendMessage(QueueEnum.CRM_QUEUE,model);
        return "hello，"+model.getSqlText()+"酱";
    }
}
