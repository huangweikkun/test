package com.jacken.test.design.pattern;


/**
 * A single instance pattern demo
 * @author jacken
 * @date 2019/06/24
 */
public class SingleInstancePatternDemo {

  public static void main(String[] args) {
    Thread threadOne = new Thread(() -> {
      Instance instance = DoubleCheckedSingleInstance.getSingleInstance();
      System.out.println(instance);
    });
    Thread threadTwo = new Thread(() -> {
      Instance instance = DoubleCheckedSingleInstance.getSingleInstance();
      System.out.println(instance);
    });
    threadOne.start();
    threadTwo.start();

    Thread threadThree = new Thread(() -> {
      Instance instance = EunmSingleInstance.SINGLE_INSTANCE.getInstance();
      System.out.println(instance);
    });
    Thread threadFour = new Thread(() -> {
      Instance instance = EunmSingleInstance.SINGLE_INSTANCE.getInstance();
      System.out.println(instance);
    });
    threadThree.start();
    threadFour.start();
  }
}

class Instance {
  public void print() {
    System.out.println("print instance");
  }
}

class DoubleCheckedSingleInstance {

  private static volatile Instance instance = null;

  public static Instance getSingleInstance () {
    if (instance == null) {
      synchronized (DoubleCheckedSingleInstance.class) {
        if (instance == null) {
          instance  = new Instance();
        }
      }
    }

    return instance;
  }
}

enum EunmSingleInstance {
  SINGLE_INSTANCE(new Instance());
  private Instance instance;

  EunmSingleInstance(Instance instance) {
    this.instance = instance;
  }

  public Instance getInstance() {
    return instance;
  }
}
