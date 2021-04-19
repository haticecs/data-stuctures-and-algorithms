/*
Non-Repeating Character (Java)
Implement a function that takes a string and returns the first character that does not appear twice or more.
Example:
"abacc" -> 'b' ('a' appears twice, and so does 'c')
"xxyzx" -> 'y' ('y' and 'z' are non-repeating characters, and 'y' appears first)
If there is no non-repeating character, return null.
*/

package Problems.Strings;

import java.util.HashMap;

public class NonRepeatingCharacter {

  public static void main(String[] args) {
    // NOTE: The following input values will be used for testing your solution.
    System.out.println(nonRepeating("abcab")); // should return 'c'
    System.out.println(nonRepeating("abab")); // should return null
    System.out.println(nonRepeating("aabbbc")); // should return 'c'
    System.out.println(nonRepeating("aabbdbc")); // should return 'd'
  }

  // Implement your solution below.
  public static Character nonRepeating(String s) {
    return null;
  }
}
