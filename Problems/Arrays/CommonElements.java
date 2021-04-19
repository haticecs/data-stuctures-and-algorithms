/*
Common Elements in Two Sorted Arrays (Java)
Write a function that returns the common elements (as an array)
between two sorted arrays of integers (ascending order).

Example: The common elements between
[1, 3, 4, 6, 7, 9] and [1, 2, 4, 5, 9, 10] are [1, 4, 9].
*/
package Problems.Arrays;

import java.util.ArrayList;

public class CommonElements {

  public static void main(String[] args) {
    // NOTE: The following input values are used for testing your solution.

    int[] array1A = { 1, 3, 4, 6, 7, 9 };
    int[] array2A = { 1, 2, 4, 5, 9, 10 };
    // commonElements(array1A, array2A) should return [1, 4, 9] (an array).
    printArray(commonElements(array1A, array2A));

    int[] array1B = { 1, 2, 9, 10, 11, 12 };
    int[] array2B = { 0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15 };
    // commonElements(array1B, array2B) should return [1, 2, 9, 10, 12] (an array).
    printArray(commonElements(array1B, array2B));

    int[] array1C = { 0, 1, 2, 3, 4, 5 };
    int[] array2C = { 6, 7, 8, 9, 10, 11 };
    // common_elements(array1C, array2C) should return [] (an empty array).
    printArray(commonElements(array1C, array2C));
  }

  // Implement your solution below.
  // NOTE: Remember to return an Integer array, not an int array.
  public static Integer[] commonElements(int[] array1, int[] array2) {
    ArrayList<Integer> resultList = new ArrayList<>();
    Integer[] resultInArray = new Integer[0];
    int n = array1.length;
    int m = array2.length;
    int i = 0, j = 0;
    while (i < n && j < m) {
      if (array1[i] == array2[j]) {
        resultList.add(array1[i]);
        i++;
        j++;
      } else if (array1[i] > array2[j]) {
        j++;
      } else { //array2[j] > array1[i]
        i++;
      }
    }
    resultInArray = new Integer[resultList.size()];
    for (int k = 0; k < resultList.size(); k++) {
      resultInArray[k] = resultList.get(k);
    }
    return resultInArray;
  }

  public static void printArray(Integer[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
