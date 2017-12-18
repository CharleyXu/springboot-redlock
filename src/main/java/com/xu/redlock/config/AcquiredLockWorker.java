package com.xu.redlock.config;

/**
 * @author CharleyXu Created on 2017/12/19. 获取锁后需要处理的逻辑
 */
public interface AcquiredLockWorker {

  <T> T invokeAfterLockAquire() throws Exception;
}
