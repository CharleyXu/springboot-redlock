package com.xu.redlock.service;

/**
 * @author CharleyXu Created on 2018/1/7. 消息生产者服务接口
 */
public interface MessagePublisher {

  boolean sendMessage(String message);
}
