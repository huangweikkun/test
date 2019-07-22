package com.jacken.test.algorithm.sort;

/**
 * @author jacken
 * @date 2019/02/14
 */
public class BubbleSort {

  public static int[] sort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length - i - 1; j++) {
        if(array[j] > array[j + 1]) {
          int temp = array[j+1];
          array[j+1] = array[j];
          array[j] = temp;
        }
      }
    }
    return array;
  }

  public static void main(String[] args) {
    int[] array = {2,4,5,3,1,7};
    array = sort(array);
    for (int i : array) {
      System.out.println(i);
    }
  }
}
