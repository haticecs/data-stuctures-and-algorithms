/*
Find the most frequently occurring item in an array.
Example: The most frequently occurring item in [1, 3, 1, 3, 2, 1] is 1.

If you're given an empty array, you should return null (in Java) or None (in Python).

You can assume that there is always a single, unique value that appears most frequently unless the array is empty.  
For instance, you won't be given an array such as [1, 1, 2, 2].
*/

package Problems.Arrays;

import java.util.HashMap;

public class MostFrequentlyOccurringItem {

  public static void main(String[] args) {
    // NOTE: The following input values are used for testing your solution.
    // mostFrequent(array1) should return 1.
    int[] array1 = { 1, 3, 1, 3, 2, 1 };
    System.out.println(mostFrequent(array1));

    // mostFrequent(array2) should return 3.
    int[] array2 = { 3, 3, 1, 3, 2, 1 };
    System.out.println(mostFrequent(array2));

    // mostFrequent(array3) should return null.
    int[] array3 = {};
    System.out.println(mostFrequent(array3));

    // mostFrequent(array4) should return 0.
    int[] array4 = { 0 };
    System.out.println(mostFrequent(array4));

    // mostFrequent(array5) should return -1.
    int[] array5 = { 0, -1, 10, 10, -1, 10, -1, -1, -1, 1 };
    System.out.println(mostFrequent(array5));
  }

  // Implement your solution below.
  public static Integer mostFrequent(int[] givenArray) {
    int length = givenArray.length;
    Integer maxItem = null;
    int maxCount = -1;

    if (length == 0) {
      return null;
    }

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < length; i++) {
      int key = givenArray[i];
      if (!hashMap.containsKey(key)) {
        hashMap.put(key, 1);
      } else {
        int count = hashMap.get(key);
        hashMap.put(key, count + 1);
      }
    }
    for (Integer k : hashMap.keySet()) {
      int currentCount = hashMap.get(k);
      if (currentCount > maxCount) {
        maxCount = currentCount;
        maxItem = k;
      }
    }
    return maxItem;
  }
}
