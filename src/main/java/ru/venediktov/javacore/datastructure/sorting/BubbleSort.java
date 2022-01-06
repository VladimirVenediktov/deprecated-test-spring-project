package ru.venediktov.javacore.datastructure.sorting;

import java.util.Arrays;

/**
 * Сортировка "пузырьком", O(n^2).
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] array = {1, 4, 2, 3, 9, 6, 0, 12, -1};
    bubbleSort(array);
    printArray(array);
  }

  private static void bubbleSort(int[] array) {
    for (int outer = array.length - 1; outer > 0; outer--) {
      for (int i = 0; i < outer; i++) {
        if (array[i] > array[i + 1]) {
          swap(array, i, i + 1);
        }
      }
    }
  }

  private static void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

  private static void printArray(int[] array) {
    Arrays.stream(array)
        .forEach(System.out::println);
  }

}