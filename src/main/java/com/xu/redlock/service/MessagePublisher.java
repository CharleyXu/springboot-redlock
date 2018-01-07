package com.xu.redlock.service;

/**
 * @author CharleyXu Created on 2018/1/7.
 * 消息 发布者 服务接口
 */
public interface MessagePublisher {

  void sendMessage(String message);
}
