package com.xu.redlock.controller;

import com.xu.redlock.config.AcquiredLockWorker;
import com.xu.redlock.config.RedisLocker;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CharleyXu Created on 2017/12/19.
 */
@RestController
public class RedLockController {

  public static final ExecutorService pool = Executors.newCachedThreadPool();
  @Autowired
  RedisLocker distributedLocker;

  @RequestMapping(value = "/redlock")
  public String testRedlock() throws Exception {

    CountDownLatch startSignal = new CountDownLatch(1);
    CountDownLatch doneSignal = new CountDownLatch(5);

    for (int i = 0; i < 10; ++i) { // create and start threads
      pool.execute(new Worker(startSignal, doneSignal));
    }
    startSignal.countDown(); // let all threads proceed
    doneSignal.await();
    System.out.println("All processors done. Shutdown connection");
    return "redlock";
  }

  class Worker implements Runnable {

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
      this.startSignal = startSignal;
      this.doneSignal = doneSignal;
    }

    public void run() {
      try {
        startSignal.await();
        distributedLocker.lock("test", new AcquiredLockWorker() {

          @Override
          public Object invokeAfterLockAquire() {
            doTask();
            return null;
          }

        });
      } catch (Exception e) {

      }
    }

    void doTask() {
      System.out.println(Thread.currentThread().getName() + " start");
      Random random = new Random();
      int _int = random.nextInt(200);
      System.out.println(Thread.currentThread().getName() + " sleep " + _int + "millis");
      try {
        Thread.sleep(_int);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + " end");
      doneSignal.countDown();
    }
  }
}
