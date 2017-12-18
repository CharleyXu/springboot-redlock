package com.xu.redlock.exception;

/**
 * @author CharleyXu Created on 2017/12/19. 异常类
 */
public class UnableAcquireLockException extends RuntimeException {

  public UnableAcquireLockException() {
    super();
  }

  public UnableAcquireLockException(String message) {
    super(message);
  }

  public UnableAcquireLockException(String message, Throwable cause) {
    super(message, cause);
  }
}
