package com.kevin.arithmetic.other;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程顺序打印 1~100
 * <p>
 * Create by Kevin-Tu on 2020/1/7.
 */
public class ThreeThread {

    public static void main(String[] args) {
        //new ThreeThread().solutionFun(3, 100);
        new ThreeThread().solutionFun3(3, 100);
    }

    private volatile int number = 1;

    /**
     * 使用Lock
     * <p>
     * 三个线程通过 signalAll() 和 await()
     * 并不是最优解，存在一个试错的过程，
     *
     * @param threadCount
     * @param maxNumber
     */
    public void solutionFun(int threadCount, int maxNumber) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        for (int i = 1; i <= threadCount; i++) {
            final int remain = i % threadCount;
            new Thread(() -> {
                while (number <= maxNumber) {
                    lock.lock();
                    if (number % threadCount == remain) {
                        System.out.println("Thread :" + remain + "  number=" + number);
                        number++;
                        condition.signalAll();
                    }
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /**
     * 使用synchronized
     *
     * @param threadCount
     * @param maxNumber
     */
    public void solutionFun2(int threadCount, int maxNumber) {
        Object lock = new Object();

        for (int i = 1; i <= threadCount; i++) {
            final int remain = i % threadCount;
            new Thread(() -> {
                while (number <= maxNumber) {
                    synchronized (lock) {
                        if (number % threadCount == remain) {
                            System.out.println("Thread :" + remain + "  number=" + number);
                            number++;
                            lock.notifyAll();
                        }
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    /**
     * 使用信号量
     *
     * @param threadCount
     * @param maxNumber
     */
    public void solutionFun3(int threadCount, int maxNumber) {
        Semaphore[] semaphores = new Semaphore[threadCount];

        // 初始化信号量
        for (int i = 0; i < threadCount; i++) {
            semaphores[i] = new Semaphore(0);
        }
        semaphores[0].release();

        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    while (number <= maxNumber) {
                        semaphores[index - 1 >= 0 ? index - 1 : threadCount - 1].acquire();
                        if (number <= maxNumber) {
                            System.out.println("Thread :" + index + "  number=" + number);
                            number++;
                        }
                        semaphores[index].release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}