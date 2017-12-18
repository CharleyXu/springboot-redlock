package com.xu.redlock.config;

import com.xu.redlock.exception.UnableAcquireLockException;
import java.util.concurrent.TimeUnit;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author CharleyXu Created on 2017/12/19.
 */
@Component
public class RedisLocker implements DistributedLocker {

  private static final String REDIS_PREFIX = "redis_";

  @Autowired
  private RedissonConnector redissonConnector;

  @Override
  public <T> T lock(String resourceName, AcquiredLockWorker acquiredLockWorker)
      throws UnableAcquireLockException, Exception {
    return lock(resourceName, acquiredLockWorker, 100);
  }

  @Override
  public <T> T lock(String resourceName, AcquiredLockWorker acquiredLockWorker, int lockTime)
      throws UnableAcquireLockException, Exception {
    RedissonClient redissonClient = redissonConnector.getRedissonClient();
    RLock lock = redissonClient.getLock(REDIS_PREFIX + resourceName);
    // 等待100秒，然后在lockTime秒后自动解锁
    boolean b = lock.tryLock(100, lockTime, TimeUnit.SECONDS);
    if (b) {
      try {
        return acquiredLockWorker.invokeAfterLockAquire();
      } finally {
        lock.unlock();
      }
    }
    throw new UnableAcquireLockException();
  }
}
