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
    System.out.println(isRotation(array1, array2a));

    int[] array2b = { 4, 5, 6, 7, 1, 2, 3 };
    // isRotation(array1, array2b) should return true.
    System.out.println(isRotation(array1, array2b));

    int[] array2c = { 4, 5, 6, 9, 1, 2, 3 };
    // isRotation(array1, array2c) should return false.
    System.out.println(isRotation(array1, array2c));

    int[] array2d = { 4, 6, 5, 7, 1, 2, 3 };
    // isRotation(array1, array2d) should return false.
    System.out.println(isRotation(array1, array2d));

    int[] array2e = { 4, 5, 6, 7, 0, 2, 3 };
    // isRotation(array1, array2e) should return false.
    System.out.println(isRotation(array1, array2e));

    int[] array2f = { 1, 2, 3, 4, 5, 6, 7 };
    // isRotation(array1, array2f) should return true.
    System.out.println(isRotation(array1, array2f));

    int[] array2g = { 2, 3, 4, 5, 6, 7, 1 };
    // isRotation(array1, array2g) should return true.
    System.out.println(isRotation(array1, array2g));

    int[] array2h = { 2, 4, 5, 6, 7, 1 };
    // isRotation(array1, array2h) should return false.
    System.out.println(isRotation(array1, array2h));
  }

  // Implement your solution below.
  public static Boolean isRotation(int[] array1, int[] array2) {
    int len = array1.length;
    int len2 = array2.length;

    //If lengths are not equal, return false
    if (len != len2) {
      return false;
    }

    //Finding the difference between indexes
    int diff = -1;
    for (int i = 0; i < len; i++) {
      if (array1[0] == array2[i]) {
        diff = i;
        break;
      }
    }
    //If there isn't chosen element, first element, in the second array return false
    if (diff == -1) {
      return false;
    }
    //Check all items in the array with the rotation difference
    for (int j = 0; j < len; j++) {
      if (array1[j] != array2[(j + diff) % len]) {
        return false;
      }
    }
    return true;
  }
}
