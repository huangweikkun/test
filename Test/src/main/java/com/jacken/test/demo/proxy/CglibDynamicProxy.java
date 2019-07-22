package com.jacken.test.demo.proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author jacken
 * @date 2019/06/23
 */
public class CglibDynamicProxy implements MethodInterceptor {

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    System.out.println("hit before");
    Object returnValue = methodProxy.invokeSuper(o, objects);
    System.out.println("hit after");
    return returnValue;
  }

  public static void main(String[] args) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(Hit.class);
    enhancer.setCallback(new CglibDynamicProxy());
    Hit hit = (Hit) enhancer.create();
    System.out.println(hit.getClass());
    hit.hit();
    hit.print();
  }
}


class Hit {
  public void hit() {
    System.out.println("hit me");
  }

  public void print() {
    System.out.println("print");
  }
}

