package com.chenjie.springboot.learn.config;

import com.chenjie.springboot.learn.callback.MsgSendConfirmCallBack;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMq配置
 */
@Configuration
public class RabbitMqConfig {

    /** 消息交换机的名字*/
    public static final String EXCHANGE = "exchangeTest";
    /** 队列key1*/
    public static final String ROUTINGKEY1 = "queue_one_key1";
    /** 队列key2*/
    public static final String ROUTINGKEY2 = "queue_one_key2";

    @Autowired
    private QueueConfig queueConfig;
    @Autowired
    private ExchangeConfig exchangeConfig;

    /**
     * 连接工厂
     */
    @Autowired
    private ConnectionFactory connectionFactory;

    /**
     将消息队列1和交换机进行绑定
     */
    @Bean
    public Binding binding_one() {
        return BindingBuilder.bind(queueConfig.Queue1()).to(exchangeConfig.directExchange()).with(RabbitMqConfig.ROUTINGKEY1);
    }

    /**
     * 将消息队列2和交换机进行绑定
     */
    @Bean
    public Binding binding_two() {
        return BindingBuilder.bind(queueConfig.Queue2()).to(exchangeConfig.directExchange()).with(RabbitMqConfig.ROUTINGKEY2);
    }

    /**
     * queue listener  观察 监听模式
     * 当有消息到达时会通知监听在对应的队列上的监听对象
     * @return
     */
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer_one(){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(connectionFactory);
        simpleMessageListenerContainer.addQueues(queueConfig.Queue1());
        simpleMessageListenerContainer.setExposeListenerChannel(true);
        simpleMessageListenerContainer.setMaxConcurrentConsumers(5);
        simpleMessageListenerContainer.setConcurrentConsumers(1);
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        return simpleMessageListenerContainer;
    }

    /**
     * 定义rabbit template用于数据的接收和发送
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setConfirmCallback(msgSendConfirmCallBack());
        return template;
    }

    /**
     * 消息确认机制
     * Confirms给客户端一种轻量级的方式，能够跟踪哪些消息被broker处理，
     * 哪些可能因为broker宕掉或者网络失败的情况而重新发布。
     * 确认并且保证消息被送达，提供了两种方式：发布确认和事务。(两者不可同时使用)
     * 在channel为事务时，不可引入确认模式；同样channel为确认模式下，不可使用事务。
     * @return
     */
    @Bean
    public MsgSendConfirmCallBack msgSendConfirmCallBack() {
        return new MsgSendConfirmCallBack();
    }
}
