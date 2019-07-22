package com.jacken.test.algorithm.sort;

/**
 * @author jacken
 * @date 2019/02/14
 */
public class InsertSort {

  public static int[] sort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int value = array[i];
      int j = i - 1;
      for(;j >= 0; j--) {
        if (array[j] > value) {
            array[j+1] = array[j];
        }else {
          break;
        }
      }
      array[j+1] = value;
    }

    return array;
  }

  public static void main(String[] args) {
    int[] array = {10,2,5,5,1,20};
    int[] sortArray = sort(array);
    for (int i : sortArray) {
      System.out.println(i);
    }
  }
}
