/*
Is One Array a Rotation of Another? (Java)
Write a function that returns true if one array is a rotation of another.

NOTE: There are no duplicates in each of these arrays.

Example: [1, 2, 3, 4, 5, 6, 7] is a rotation of [4, 5, 6, 7, 1, 2, 3].
*/

package Problems.Arrays;

public class ArrayRotation {

  public static void main(String[] args) {
    // NOTE: The following input values will be used for testing your solution.
    int[] array1 = { 1, 2, 3, 4, 5, 6, 7 };
    int[] array2a = { 4, 5, 6, 7, 8, 1, 2, 3 };
    // isRotation(array1, array2a) should return false.
    int[] array2b = { 4, 5, 6, 7, 1, 2, 3 };
    // isRotation(array1, array2b) should return true.
    int[] array2c = { 4, 5, 6, 9, 1, 2, 3 };
    // isRotation(array1, array2c) should return false.
    int[] array2d = { 4, 6, 5, 7, 1, 2, 3 };
    // isRotation(array1, array2d) should return false.
    int[] array2e = { 4, 5, 6, 7, 0, 2, 3 };
    // isRotation(array1, array2e) should return false.
    int[] array2f = { 1, 2, 3, 4, 5, 6, 7 };
    // isRotation(array1, array2f) should return true.
  }

  // Implement your solution below.
  public static Boolean isRotation(int[] array1, int[] array2) {
    return false;
  }
}
