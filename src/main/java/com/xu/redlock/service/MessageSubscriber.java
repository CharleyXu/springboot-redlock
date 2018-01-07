package com.xu.redlock.service;

/**
 * @author CharleyXu Created on 2018/1/7. 消息订阅者服务接口
 */
public interface MessageSubscriber {

  void handleMessage(String message);
}
