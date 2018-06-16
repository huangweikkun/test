package com.jacken.test.serialize;

import java.io.Serializable;

/**
 * @author jacken
 * @date 2018/04/29
 */
public class Person implements Serializable {

  private String name;
  private Integer age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
