package com.kevin.arithmetic.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tuchuantao on 2021/9/17
 * Desc: 大概有5种生产者消费者的写法，分别如下。
 * 1、用synchronized对存储加锁，然后用object原生的wait() 和 notify()做同步。
 * 2、用concurrent.locks.Lock，然后用condition的await() 和signal()做同步。
 * 3、直接使用concurrent.BlockingQueue。
 * 4、使用PipedInputStream/PipedOutputStream。
 * 5、使用信号量semaphore。
 */
public class ProducerAndConsumer {
  // 1、synchronize 对存储加锁
  private final int MAX_LEN = 10;
  private Queue<Integer> mQueue = new LinkedList();

  class Producer extends Thread {
    @Override
    public void run() {
      while (true) {
        synchronized (mQueue) {
          while (mQueue.size() == MAX_LEN) {
            mQueue.notify();
            System.out.println("当前队列满");
            try {
              mQueue.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          mQueue.add(1);
          mQueue.notify();
          System.out.println("生产者生产一条任务，当前队列长度为" + mQueue.size());
          try {
            sleep(100); // mQueue.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  class Consumer extends Thread {
    @Override
    public void run() {
      while (true) {
        synchronized (mQueue) {
          while (mQueue.size() == 0) {
            mQueue.notify();
            System.out.println("当前队列为空");
            try {
              mQueue.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          mQueue.poll();
          mQueue.notify();
          System.out.println("消费者消费一条任务，当前队列长度为" + mQueue.size());
          try {
            sleep(100); // mQueue.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    ProducerAndConsumer pc = new ProducerAndConsumer();
    Producer producer = pc.new Producer();
    Consumer consumer = pc.new Consumer();
    producer.start();
    consumer.start();
  }
}
