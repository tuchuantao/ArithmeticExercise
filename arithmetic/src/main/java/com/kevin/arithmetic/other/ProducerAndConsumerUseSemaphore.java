package com.kevin.arithmetic.other;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * Created by tuchuantao on 2021/9/17
 * Desc:
 */
public class ProducerAndConsumerUseSemaphore {
  private final int MAX_LEN = 10;
  private Queue<Integer> mQueue = new LinkedList();
  private Semaphore notFull = new Semaphore(10);
  private Semaphore notEmpty = new Semaphore(0); // 构造参数，代表初始值
  private Semaphore mutex = new Semaphore(1);

  class Producer extends Thread {

    @Override
    public void run() {
      while (true) {
        try {
          notFull.acquire();
          mutex.acquire();
          mQueue.add(1);
          System.out.println("生产者生产一条任务，当前队列长度为" + mQueue.size());
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          mutex.release();
          notEmpty.release();
        }
      }
    }
  }

  class Consumer extends Thread {
    @Override
    public void run() {
      while (true) {
        try {
          notEmpty.acquire();
          mutex.acquire();
          mQueue.poll();
          System.out.println("消费者消费一条任务，当前队列长度为" + mQueue.size());
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          mutex.release();
          notFull.release();
        }
      }
    }
  }

  public static void main(String[] args) {
    ProducerAndConsumerUseSemaphore pc = new ProducerAndConsumerUseSemaphore();
    Producer producer = pc.new Producer();
    Consumer consumer = pc.new Consumer();
    producer.start();
    consumer.start();
  }
}
