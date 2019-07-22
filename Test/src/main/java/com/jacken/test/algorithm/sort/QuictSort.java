package com.jacken.test.algorithm.sort;


/**
 * @author jacken
 * @date 2019/02/20
 */
public class QuictSort {

  public static void sort(int[] array, int i, int j) {
    // while need i >= j not i == j
    if (i >= j) {
      return;
    }

    int p = partition(array, i, j);
    sort(array, i, p - 1);
    sort(array, p + 1, j);
  }

  public static int partition(int[] array, int i, int j) {
    int key = getPartitionKey(array, i, j);
    for (int k = i; k <= j; k++) {
      if (array[k] < array[key]) {
        int temp = array[k];
        array[k] = array[i];
        array[i] = temp;
        i++;
      }
    }

    int tmp = array[i];
    array[i] = array[key];
    array[key] = tmp;
    return i;
  }

  public static int getPartitionKey(int[] array, int i, int j) {
    return j;
  }

  public static void main(String[] args) {
    int[] array = {23,432,234,123,55,1,5};
    sort(array, 0, array.length - 1);
    for (int i : array) {
      System.out.println(i);
    }
  }
}

