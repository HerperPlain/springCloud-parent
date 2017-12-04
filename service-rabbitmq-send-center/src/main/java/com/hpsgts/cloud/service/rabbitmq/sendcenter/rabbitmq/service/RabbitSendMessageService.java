package com.hpsgts.cloud.service.rabbitmq.sendcenter.rabbitmq.service;

import com.hpsgts.cloud.service.common.mq.em.QueueEnum;
import com.hpsgts.cloud.service.common.mq.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther hpsgts
 * @Date 2017/12/4 下午2:01
 */
@Component
public class RabbitSendMessageService {

    private static Logger logger = LoggerFactory.getLogger(RabbitSendMessageService.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     *
     * @param queueEnum
     * @param message
     */
    public void sendMessage(QueueEnum queueEnum, Message message){
        logger.info("调用发送后台sendCrmMessage方法,发送消息【{}】到QUEUE【{}】",message.toJsonString(),queueEnum.getCode());
        rabbitTemplate.convertAndSend(queueEnum.getCode(),message.toJsonString());
    }
}
