package com.hpsgts.cloud.servermq.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * 配置后台业务处理类
 */

@Configuration
@RabbitListener(queues = RabbitCrmListener.CRM_QUEUE)
public class RabbitCrmListener {
    private static Logger logger = LoggerFactory.getLogger(RabbitCrmListener.class);
    public static final String CRM_QUEUE="crm_queue";
    @Bean
    public Queue crmQueue(){
        return new Queue(CRM_QUEUE);
    }

    @RabbitHandler
    public void process(@Payload String msg){
        logger.info("触发业务处理方法,接收数据：{}",msg);
    }
}
