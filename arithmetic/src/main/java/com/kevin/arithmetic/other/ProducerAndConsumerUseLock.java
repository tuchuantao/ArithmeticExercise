package com.kevin.arithmetic.other;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tuchuantao on 2021/9/17
 * Desc:
 */
public class ProducerAndConsumerUseLock {
  private final int MAX_LEN = 1000;
  private Queue<Integer> mQueue = new LinkedList();
  private final ReentrantLock lock = new ReentrantLock();
  private final Condition full = lock.newCondition();
  private final Condition empty = lock.newCondition();

  class Producer extends Thread {
    @Override
    public void run() {
      while (true) {
        lock.lock();
        try {
          while (mQueue.size() == MAX_LEN) {
            System.out.println("当前队列满");
            try {
              full.await();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          mQueue.add(1);
          empty.signal();
          System.out.println("生产者生产一条任务，当前队列长度为" + mQueue.size());
//          try {
//            sleep(100);
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
        } finally {
          lock.unlock();
        }

//        try {
//          Thread.sleep(100);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
      }
    }
  }

    class Consumer extends Thread {
      @Override
      public void run() {
        while (true) {
          lock.lock();
          try {
            while (mQueue.size() == 0) {
              System.out.println("当前队列为空");
              try {
                empty.await();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
            mQueue.poll();
            full.signal(); // signalAll()
            System.out.println("消费者消费一条任务，当前队列长度为" + mQueue.size());
//            try {
//              Thread.sleep(500);
//            } catch (InterruptedException e) {
//              e.printStackTrace();
//            }
          } finally {
            lock.unlock();
          }

//          try {
//            Thread.sleep(100);
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
        }
      }
    }

    public static void main(String[] args) {
      ProducerAndConsumerUseLock pc = new ProducerAndConsumerUseLock();
      Producer producer = pc.new Producer();
      Consumer consumer = pc.new Consumer();
      producer.start();
      consumer.start();
    }
  }
