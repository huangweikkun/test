package com.jacken.test.demo.proxy;


import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jacken
 * @date 2019/06/23
 */
public class JDKDynamicProxy {

  private Object targetObject;

  public JDKDynamicProxy(Object targetObject) {
    this.targetObject = targetObject;
  }

  public Object getPorxy() {
     return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), (Object proxy, Method method, Object[] args) -> {
       System.out.println("invoke before");
       Object returnValue = method.invoke(targetObject,args);
       System.out.println("invoke after");
       return returnValue;
     });
  }

  public static void main(String[] args) {
    Shoutable shoutable = new Duck();
    JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy(shoutable);
    Shoutable proxy = (Shoutable) jdkDynamicProxy.getPorxy();
    System.out.println(proxy.getClass());
    proxy.shout();
  }

}

interface Shoutable {
  void shout();
}

class Duck implements Shoutable {

  @Override
  public void shout() {
    System.out.println("I can shout loudly");
  }
}

