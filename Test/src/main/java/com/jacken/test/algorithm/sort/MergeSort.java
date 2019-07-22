package com.jacken.test.algorithm.sort;

/**
 * @author jacken
 * @date 2019/02/20
 */
public class MergeSort {

  public static void sort(int[] array, int i, int j) {
    if (i == j) {
      return;
    }

    int middle = (i + j)/2;
    sort(array, i, middle);
    sort(array, middle+1, j);
    merge(array, i, middle, j);
  }

  public static void merge(int[] array, int i, int middle, int j) {
    int[] tempArray = new int[j - i + 1];
    int index = 0;
    int startIndex = i;
    int middleIndex = middle + 1;
    while (startIndex <= middle && middleIndex <= j) {
      if (array[startIndex] >= array[middleIndex]) {
        tempArray[index] = array[middleIndex];
        middleIndex ++;
      }else {
        tempArray[index] = array[startIndex];
        startIndex ++;
      }
      index++;
    }

    while (startIndex <= middle) {
      tempArray[index++] = array[startIndex++];
    }

    while (middleIndex <= j) {
      tempArray[index++] = array[middleIndex++];
    }

    index = 0;
    for(;i <= j; i++) {
      array[i] = tempArray[index++];
    }
  }

  public static void main(String[] args) {
    int[] array = {5,2,6,7,4,5};
    sort(array, 0, array.length - 1);
    for (int i : array) {
      System.out.println(i);
    }
  }
}
