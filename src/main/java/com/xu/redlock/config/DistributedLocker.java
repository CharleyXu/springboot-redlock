package com.xu.redlock.config;

import com.xu.redlock.exception.UnableAcquireLockException;

/**
 * @author CharleyXu Created on 2017/12/19. 获取锁管理
 */
public interface DistributedLocker {

  /**
   * 获取锁
   */
  <T> T lock(String resourceName, AcquiredLockWorker acquiredLockWorker)
      throws UnableAcquireLockException, Exception;

  <T> T lock(String resourceName, AcquiredLockWorker acquiredLockWorker, int lockTime)
      throws UnableAcquireLockException, Exception;

}
