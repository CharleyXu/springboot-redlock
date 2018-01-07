package com.xu.redlock.service;

import com.xu.redlock.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CharleyXu Created on 2018/1/7.
 */
@Service
public class MessagePublisherImpl implements MessagePublisher {

  @Autowired
  private RedisUtil redisUtil;
  //多频道
  private String[] channels;

  @Override
  public boolean sendMessage(String message) {
    return false;
  }
}
