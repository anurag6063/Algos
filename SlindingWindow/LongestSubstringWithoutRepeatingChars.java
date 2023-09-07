import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
System.out.println("not repeated- left: "+ left + " right: "+ right);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                    System.out.println("repeated - left: ");
                }
                charSet.add(s.charAt(right));
                System.out.println("repeated - left: "+ left + " right: "+ right);
            }
        }
        
        return maxLength;
    }
}