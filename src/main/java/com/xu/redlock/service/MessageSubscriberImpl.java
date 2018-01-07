package com.xu.redlock.service;

import org.springframework.stereotype.Component;

/**
 * @author CharleyXu Created on 2018/1/8. 消息订阅者服务实现类
 */
@Component
public class MessageSubscriberImpl implements MessageSubscriber {

  @Override
  public void handleMessage(String message) {
    System.out.println("message:" + message);
  }
}
