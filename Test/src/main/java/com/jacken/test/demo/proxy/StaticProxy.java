package com.jacken.test.demo.proxy;

/**
 * @author jacken
 * @date 2019/06/23
 */
public class StaticProxy {


}

interface Flyable {
  void fly();
}

class AirPlane implements Flyable {


  @Override
  public void fly() {
    System.out.println("I can fly");
  }
}

class AirFlyProxy implements Flyable {

  private Flyable flyable;

  public AirFlyProxy(Flyable flyable) {
    this.flyable = flyable;
  }

  @Override
  public void fly() {
    System.out.println("proxy before");
    flyable.fly();
    System.out.println("proxy after");
  }
}