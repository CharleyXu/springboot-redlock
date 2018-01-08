package com.xu.redlock.config;

import com.xu.redlock.service.MessageSubscriberImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @author CharleyXu Created on 2018/1/8.
 */
@Configuration
public class RedisMQConfig {

  @Bean
  RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
      MessageListenerAdapter listenerAdapter) {

    RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    //订阅通道 chat , 可以添加多个 messageListener
    container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
    return container;
  }

  @Bean
  MessageListenerAdapter listenerAdapter(MessageSubscriberImpl messageSubscriber) {
    //这个地方 是给messageListenerAdapter 传入一个消息接受的处理器，利用反射的方法调用“handleMessage”
    //调用处理器 handleMessage
    return new MessageListenerAdapter(messageSubscriber, "handleMessage");
  }
}
