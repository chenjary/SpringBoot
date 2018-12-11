package com.chenjie.springboot.learn.callback;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

/**
 * 消息发送到交换机确认机制
 */
public class MsgSendConfirmCallBack implements RabbitTemplate.ConfirmCallback {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.info("MsgSendConfirmCallBack  , 回调id:" + correlationData);
        if (ack) {
            logger.info("success");
        } else {
            logger.error("fail" + cause+"\n重新发送");
        }
    }
}
