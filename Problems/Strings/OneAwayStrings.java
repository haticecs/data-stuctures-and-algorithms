/*One Away Strings (Java)
Write a function that takes two strings and returns true if they are one away from each other.

They are one away from each other if a single operation (changing a character, deleting a character or adding a character) will change one of the strings to the other.

Examples:

"abcde" and "abcd" are one away (deleting a character).
"a" and "a" are one away (changing the only character 'a' to the equivalent character 'a').
"abc" and "bcc" are NOT one away. (They are two operations away.)
*/
package Problems.Strings;

public class OneAwayStrings {

  public static void main(String[] args) {
    // NOTE: The following input values will be used for testing your solution.
    System.out.println(isOneAway("abcde", "abcd")); // should return true
    System.out.println(isOneAway("abde", "abcde")); // should return true
    System.out.println(isOneAway("a", "a")); // should return true
    System.out.println(isOneAway("abcdef", "abqdef")); // should return true
    System.out.println(isOneAway("abcdef", "abccef")); // should return true
    System.out.println(isOneAway("abcdef", "abcde")); // should return true
    System.out.println(isOneAway("aaa", "abc")); // should return false
    System.out.println(isOneAway("abcde", "abc")); // should return false
    System.out.println(isOneAway("abc", "abcde")); // should return false
    System.out.println(isOneAway("abc", "bcc")); // should return false
  }

  // Implement your solution below.
  /* TRUE Scenarios
  1 -> lengths are same -> check the different character count(opCount)
      if (opCount == 0) return true (same strings!)
      if (opCount == 1) return true 
  2 -> (length difference == 1) -> check every element using two pointers
      if there are different element, move in the max len string
      since the one different element will be in that string.
      and increase opCount.
      otherwise, increase both pointers.
      check opCount.
      if (opCount == 0) return true (one different element is at the end!)
      if (opCount == 1) return true.
   DEFAULT return false for other all possible scenarios (ex.length difference > 1)
  */
  public static Boolean isOneAway(String s1, String s2) {
    int p1 = 0, p2 = 0;
    int len1 = s1.length(), len2 = s2.length();

    int maxLen = len1 > len2 ? len1 : len2;
    char arr1[] = s1.toCharArray();
    char arr2[] = s2.toCharArray();
    int opCount = 0;

    if (len1 == len2) {
      while (p1 < len1) {
        if (arr1[p1] != arr2[p1]) opCount++;
        p1++;
      }
      if (opCount <= 1) return true;
    } /*When pointers points to different characters, 
    we need to increase the pointers belongs to the maxLen array */else if (
      Math.abs(len1 - len2) == 1
    ) {
      while (p1 < len1 && p2 < len2) {
        if (arr1[p1] != arr2[p2]) {
          if (maxLen == len1) p1++; else p2++;
          opCount++;
        }
        p1++;
        p2++;
      }
      if (opCount <= 1) return true;
    }
    return false;
  }
}
/*Solution
    public static Boolean isOneAway(String s1, String s2) {
        if (s1.length() - s2.length() >= 2 || s2.length() - s1.length() >= 2) {
            return false;
        } else if (s1.length() == s2.length()) {
            return isOneAwaySameLength(s1, s2);
        } else if (s1.length() > s2.length()) {
            return isOneAwayDiffLengths(s1, s2);
        } else {
            return isOneAwayDiffLengths(s2, s1);
        }
    }

    public static Boolean isOneAwaySameLength(String s1, String s2) {
        int countDiff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                countDiff += 1;
                if (countDiff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // Assumption: s1.length() == s2.length() + 1
    public static Boolean isOneAwayDiffLengths(String s1, String s2) {
        int i = 0;
        int countDiff = 0;
        while (i < s2.length()) {
            if (s1.charAt(i + countDiff) == s2.charAt(i)) {
                i += 1;
            } else {
                countDiff += 1;
            }
            if (countDiff > 1) {
                return false;
            }
        }
        return true;
    }
}

*/
