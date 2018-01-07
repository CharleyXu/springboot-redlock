package com.xu.redlock.bean;

import org.springframework.stereotype.Component;

/**
 * @author CharleyXu Created on 2018/1/8.
 */
@Component
public class MessageReceiver {

  /**
   * 接受消息
   */
  public void receiveMessage(String message) {
    System.out.println(message);
  }
}
