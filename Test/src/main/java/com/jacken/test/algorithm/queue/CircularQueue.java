package com.jacken.test.algorithm.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jacken
 * @date 2019/06/08
 */
public class CircularQueue<V> implements Queue<V> {

  private List<V> array;
  private int size;
  private int head;
  private int tail;

  public CircularQueue(int size) {
    array = new ArrayList<>();
    this.size = size;
    head = 0;
    tail = 0;
  }

  @Override
  public boolean enqueue(V value) {
    if (tail + 1 % size == head) {
      return false;
    }

    array.set(tail, value);
    tail = tail + 1 % size;
    return true;
  }

  @Override
  public V dequeue() {
      if (head == tail) {
      return null;
    }

    V value = array.get(head);
    head = head + 1 % size;
    return value;
  }

  private <T> T genericMethod(T value) {
    return value;
  }

  public static void main(String[] args) {
    short s = 1;
  }
}
