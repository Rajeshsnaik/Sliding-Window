//Pick Toys | An Interesting Sliding Window Problem
import java.util.HashMap;
import java.util.Map;

public class sw8 {
    public static void main(String[] args) {
        String s="abaccab";
        System.out.println("Maximum number of toys can be picked: "+ findMaxToysToPick(s));
    }
    
    public static int findMaxToysToPick(String s) {
    Map<Character, Integer> frequencyMap = new HashMap<>();
    int windowStart = 0, windowEnd = 0, maxLength = Integer.MIN_VALUE;

    while (windowEnd < s.length()) {
      char rightChar = s.charAt(windowEnd);
      frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);

      if (frequencyMap.size() < 2) {
        windowEnd++;
      } else if (frequencyMap.size() == 2) {
        maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        windowEnd++;
      } else {
        while (frequencyMap.size() > 2) {
          char leftChar = s.charAt(windowStart);
          frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);

          if (frequencyMap.get(leftChar) == 0) {
            frequencyMap.remove(leftChar);
          }
          windowStart++;
        }
      }
    }
    return maxLength;
  }
}
