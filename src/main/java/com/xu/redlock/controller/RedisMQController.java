package com.xu.redlock.controller;

import com.xu.redlock.service.MessagePublisherImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CharleyXu Created on 2018/1/8.
 */
@RestController
public class RedisMQController {

  @Autowired
  private MessagePublisherImpl messagePublisher;

  @RequestMapping("/sendMessage")
  public String sendMessage(String message) {
    messagePublisher.sendMessage(message);
    return message;
  }
}
