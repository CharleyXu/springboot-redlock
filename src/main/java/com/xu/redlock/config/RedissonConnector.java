package com.xu.redlock.config;

import javax.annotation.PostConstruct;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

/**
 * @author charlie Created on 2017/12/18. 获取RedissonClient连接类
 */
@Component
public class RedissonConnector {

  RedissonClient redissonClient;

  @PostConstruct
  public void init() {
    redissonClient = Redisson.create();
  }

  public RedissonClient getRedissonClient() {
    return redissonClient;
  }

}
