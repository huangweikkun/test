package com.jacken.test.algorithm.array;

/**
 * @author jacken
 * @date 2019/02/03
 */
public class ArrayList {

  private int[] array;
  private int size;
  private int pointer;

  public ArrayList(int size) {
    this.size = size;
    this.array = new int[size];
    this.pointer = 0;
  }

  public int remove(int index) {
    if (index > pointer) {
      throw new IllegalArgumentException();
    }

    int result = array[index];
    for (int i = index; i < pointer; i++) {
      array[i] = array[i+1];
    }

    return result;
  }

  public int get() {
    if (pointer == 0) {
      return -1;
    }

    int result = array[0];
    for (int i = 0; i < array.length -1; i++) {
      array[i] = array[i+1];
    }
    return result;
  }

  public void put(int param) {
    if (pointer >= size) {
      resize();
    }
    array[pointer] = param;
    pointer ++;
  }

  private void resize() {
    size = size * 2;
    int[] oldArray = array;
    array = new int[size];
    for (int i = 0; i < pointer; i++) {
      array[i] = oldArray[i];
    }
  }

  public static void main(String[] args) {
    ArrayList list = new ArrayList(10);
    list.put(1);
    int i = list.get();
    System.out.println(i);
  }

}
