package com.xu.redlock.service;

import com.xu.redlock.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CharleyXu Created on 2018/1/7.
 * 消息 发布者 服务实现类
 */
@Service
public class MessagePublisherImpl implements MessagePublisher {

  private static final String CHANNEL_NAME = "chat";
  @Autowired
  private RedisUtil redisUtil;

  @Override
  public void sendMessage(String message) {
    try {
      redisUtil.pushMessage(CHANNEL_NAME, message);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
