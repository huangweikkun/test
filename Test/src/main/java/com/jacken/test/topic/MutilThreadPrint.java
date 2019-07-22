package com.jacken.test.topic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jacken
 * @date 2019/02/14
 */
public class MutilThreadPrint {

  public static ReentrantLock reentrantLock = new ReentrantLock();
  public static Condition conditionOne = reentrantLock.newCondition();
  public static Condition conditionTwo = reentrantLock.newCondition();

  public static void main(String[] args) throws InterruptedException {
    new Thread(new ThreadTwo()).start();
    Thread.sleep(1000);
    new Thread(new ThreadOne()).start();
  }
}


class ThreadOne implements Runnable {

  private int number = 1;

  @Override
  public void run() {
    try {
      while (number <= 99) {
        try {
          MutilThreadPrint.reentrantLock.lock();
          System.out.println(number);
          number += 2;
          MutilThreadPrint.conditionTwo.signal();
          MutilThreadPrint.conditionOne.await();
        } finally {
          MutilThreadPrint.reentrantLock.unlock();
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class ThreadTwo implements Runnable {

  private int number = 2;

  @Override
  public void run() {
    try {
      while (number <= 100) {
        MutilThreadPrint.reentrantLock.lock();
        try {
          MutilThreadPrint.conditionTwo.await();
          System.out.println(number);
          number += 2;
          MutilThreadPrint.conditionOne.signal();
        } finally {
          MutilThreadPrint.reentrantLock.unlock();
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}