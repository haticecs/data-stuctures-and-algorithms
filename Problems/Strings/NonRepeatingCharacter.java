/*
Non-Repeating Character (Java)
Implement a function that takes a string and returns the first character that does not appear twice or more.
Example:
"abacc" -> 'b' ('a' appears twice, and so does 'c')
"xxyzx" -> 'y' ('y' and 'z' are non-repeating characters, and 'y' appears first)
If there is no non-repeating character, return null.
*/

package Problems.Strings;

import java.util.*;

public class NonRepeatingCharacter {

  public static void main(String[] args) {
    // NOTE: The following input values will be used for testing your solution.
    System.out.println(nonRepeating("abcab")); // should return 'c'
    System.out.println(nonRepeating("abab")); // should return null
    System.out.println(nonRepeating("aabbbc")); // should return 'c'
    System.out.println(nonRepeating("aabbdbc")); // should return 'd'
    System.out.println(nonRepeating("cbbabb")); // should return 'c'
  }

  // Implement your solution below.
  public static Character nonRepeating(String s) {
    //LinkedHashMap maintains original insertion order, HashMap doesn't.
    HashMap<Character, Integer> hm = new LinkedHashMap<>();
    char[] arr = s.toCharArray();
    for (char c : arr) {
      //c is a current key
      if (hm.containsKey(c)) {
        Integer newCount = hm.get(c) + 1;
        hm.put(c, newCount);
      } else {
        hm.put(c, 1);
      }
    }
    for (Character k : hm.keySet()) {
      int count = hm.get(k);
      if (count == 1) {
        return k;
      }
    }
    return null;
  }
}
/* Solution
  public static Character nonRepeating2(String s) {
    HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
    // NOTE: Using s.toCharArray() is no the most efficient method,
    // but I chose to use it here for simplicity.
    for (char c : s.toCharArray()) {
      if (charCount.containsKey(c)) {
        Integer newVal = charCount.get(c) + 1;
        charCount.put(c, newVal);
      } else {
        charCount.put(c, 1);
      }
    }
    for (char c : s.toCharArray()) {
      if (charCount.get(c) == 1) return c;
    }
    return null;
  }
*/
