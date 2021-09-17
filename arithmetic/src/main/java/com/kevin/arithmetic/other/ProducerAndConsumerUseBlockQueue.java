package com.kevin.arithmetic.other;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by tuchuantao on 2021/9/17
 * Desc:
 */
public class ProducerAndConsumerUseBlockQueue {
  private BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(10);
  class Producer extends Thread {
    @Override
    public void run() {
      while(true) {
        try {
          queue.put(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("生产者生产一条任务，当前队列长度为" + queue.size());
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
  class Consumer extends Thread {
    @Override
    public void run() {
      while (true) {
        try {
          queue.take();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
  public static void main(String[] args) {
    ProducerAndConsumerUseBlockQueue pc = new ProducerAndConsumerUseBlockQueue();
    Producer producer = pc.new Producer();
    Consumer consumer = pc.new Consumer();
    producer.start();
    consumer.start();
  }

}
