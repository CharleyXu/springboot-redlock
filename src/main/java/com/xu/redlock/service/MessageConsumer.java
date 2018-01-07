package com.xu.redlock.service;

/**
 * @author CharleyXu Created on 2018/1/7. 消息消费者服务接口
 */
public interface MessageConsumer {

  void handleMessage(String message);
}
