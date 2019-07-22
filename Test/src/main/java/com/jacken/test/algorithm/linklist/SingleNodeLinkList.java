package com.jacken.test.algorithm.linklist;

import java.util.Iterator;

/**
 * @author jacken
 * @date 2019/06/02
 */
public class SingleNodeLinkList<V> implements Iterable {

  private Node head = new Node(null);
  private int length = 0;

  /**
   * @param
   * @return
   */
  public void insert(V value) {
    Node node = new Node(value);
    node.next = this.head;
    head = node;
    length ++;
  }

  public void delete(V value) {

  }

  public Node find(V value) {
    Node findNode = this.head;
    while (findNode != null) {
      if (value.equals(findNode.value)) {
        return findNode;
      }
      findNode = findNode.next;
    }
    return null;
  }

  @Override
  public Iterator iterator() {
    return new Itr();
  }

  private class Itr implements Iterator {

    private int cursor;
    private Node currentNode = head;

    public Itr() {
       this.cursor = 1;
    }

    @Override
    public boolean hasNext() {
      if(cursor <= length) {
        cursor ++;
        return true;
      }

      return false;
    }

    @Override
    public Node next() {
      if (currentNode != null && currentNode.next == null) {
        return null;
      }
      Node returnCurrentNode = currentNode;
      currentNode = currentNode.next;
      return returnCurrentNode;

    }
  }

  static class Node<V> {

    private V value;
    private Node next;

    public V getValue() {
      return value;
    }

    public void setValue(V value) {
      this.value = value;
    }

    public Node(V value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {
    SingleNodeLinkList<Integer> singleNodeLinkList = new SingleNodeLinkList<>();
    singleNodeLinkList.insert(1);
    singleNodeLinkList.insert(2);
    for (Object o : singleNodeLinkList) {
      System.out.println(((Node<Integer>)o).getValue());
    }
  }

}
