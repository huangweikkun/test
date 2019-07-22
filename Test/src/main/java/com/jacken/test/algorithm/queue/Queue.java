package com.jacken.test.algorithm.queue;

/**
 * @author jacken
 * @date 2019/06/08
 */
public interface Queue<V> {

  boolean enqueue(V value);

  V dequeue();

}
