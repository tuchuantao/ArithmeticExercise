package com.kevin.arithmetic.other;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tuchuantao on 2021/8/31
 * Desc:
 */
public class ThreadDemo {

//  private int num = 100;
  private volatile int num = 100;
  public StringBuilder builder1 = new StringBuilder();
  public StringBuilder builder2 = new StringBuilder();

  public static void main(String[] args) {
    ThreadDemo demo = new ThreadDemo();
//    demo.printNum();
//    System.out.println("builder1= " + demo.builder1);
//    System.out.println("builder2= " + demo.builder2);
    demo.threadPool();
  }

  /**
   * 主存与工作空间数据同步时机：
   *   1、获取锁 & 释放锁
   *   2、Thread.sleep() 同步
   *   3、线程切换
   */
  private void printNum() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        int count = 0;
        //StringBuilder builder = new StringBuilder();
        while (num > 0 ) {
          count++;
          //builder.append(num).append(",");
          builder1.append(num--).append(",");
          //num--;
          //System.out.println("count= " + count + "Thread 1 =" + num--);
        }
        while (true) {
          count++;
        }
        //System.out.println("count= " + count + "Thread 1 =" + builder.toString());
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        int count = 0;
        //StringBuilder builder = new StringBuilder();
        while (num > 0 ) {
          count++;
          builder2.append(num--).append(",");
          //builder.append(num).append(",");
          //num--;
          //System.out.println("count= " + count + "Thread 2 =" + num--);
        }
        //System.out.println("count= " + count + "Thread 2 =" + builder.toString());
      }
    }).start();
  }

  private void threadPool() {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 100, 5000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(),
        new ThreadFactory() {
          private int num = 1;

          @Override
          public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("Test Thread " + num++);
            return thread;
          }
        }, new RejectedExecutionHandler() {
      @Override
      public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

      }
    });

    for (int i = 0; i < 5; i++) {
      executor.execute(new Runnable() {
        @Override
        public void run() {
          while (num > 0) {
            System.out.println("Thread Name=" + Thread.currentThread().getName() + "/ num =" + num--);
          }
        }
      });
    }
  }
}
