package com.jacken.test.algorithm.linklist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author jacken
 * @date 2019/02/15
 */
public class LinkList<V> {

  private Node head;
  private Node tail;
  private int size;

  static class Node<V> {
    protected V value;
    protected Node next;

    public Node(V value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  public LinkList() {
    this.size = 0;
    this.head = new Node(null, null);
  }

  public void add(V value) {
    Node node = new Node(value, null);
    if (tail == null) {
      tail = node;
      head.next = tail;
    }else {
      tail.next = node;
      tail = node;
    }

    size ++;
  }

  public V get() {
    if (head.next == null) {
      tail = null;
      return null;
    }

    Node node = head.next;
    head.next = head.next.next;

    size --;
    return (V)node.value;
  }

  public Iterator<V> iterator() {
    return new Itr();
  }

  private class Itr implements Iterator<V> {

    private int cursor = 0;

    @Override
    public boolean hasNext() {
      return head.next != null;
    }

    @Override
    public V next() {
      if (head.next == null) {
        return null;
      }

      return get();
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer<? super V> action) {

    }
  }
  public static void main(String[] args) {
    LinkList<Integer> firstLinkList = new LinkList<>();
    firstLinkList.add(1);
    firstLinkList.add(6);
    firstLinkList.add(7);
    LinkList<Integer> secondLinkList = new LinkList<>();
    secondLinkList.add(2);
    secondLinkList.add(4);
    secondLinkList.add(6);

    LinkList<Integer> mergeLinkList = mergeTwoSortLinkList(firstLinkList, secondLinkList);
    Iterator<Integer> integerIterator = mergeLinkList.iterator();
    while (integerIterator.hasNext()) {
      System.out.println(integerIterator.next());
    }
  }

  public static LinkList<Integer> mergeTwoSortLinkList(LinkList<Integer> first, LinkList<Integer> second) {
    LinkList<Integer> mergeLinkList = new LinkList();

    Integer firstNodeValue = first.get();
    Integer secondNodeValue = second.get();
    do {
      if (firstNodeValue > secondNodeValue) {
        mergeLinkList.add(secondNodeValue);
        secondNodeValue = second.get();
      } else {
        mergeLinkList.add(firstNodeValue);
        firstNodeValue = first.get();
      }
    } while ((firstNodeValue != null && secondNodeValue != null));

    if (firstNodeValue == null) {
      while(secondNodeValue != null){
        mergeLinkList.add(secondNodeValue);
        secondNodeValue = second.get();
      }
    }
    if (secondNodeValue == null) {
      while(firstNodeValue != null){
        mergeLinkList.add(firstNodeValue);
        firstNodeValue = first.get();
      }
    }

    return mergeLinkList;
  }

}
