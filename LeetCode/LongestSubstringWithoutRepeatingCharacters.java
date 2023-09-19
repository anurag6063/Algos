import java.util.HashSet;
import java.util.Set;



/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

// brute force - own
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int max =0;
        Set<Character> set = new HashSet<>();

            for(int i=0; i< s.length(); i++){
                if(set.contains(s.charAt(i))){
                    set.clear();
                    result = 0;
                }else{
                    set.add(s.charAt(i));
                    result++;
                    System.out.println(result);
                }
                // since we want to find the max length ever. Else it will give the length of the last substring with no repeating chars.
                max = Math.max(max, result);
            }

        return max;

    }
}

// ------------------------------
class Solution {
    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        // this is sliding window problem and even when i saw this second time i couldn't solve it.
        // so i need to repete and understand my seen solutions.
        
        
        // supplemenary dataset needed as Set.
        // initlaize the answer
        // intialize left at 0
        // right will be controlled by for loop.
        
        // for loop on right -> increment by 1 since right will always move.
        // left moves conditionally and with a while loop. 
            // check condition 
            // we need to find duplicate chars. so we are storing and checkin for it from Set.
                // if current right index char is found in set
                    // it's a duplicate so the window should shift from left till a unique value is found.
                    // while set contains (it has to contain chars between left and right that are unique) the new found right element.
                    // remove from set
                    // shift the left by 1
                // if not found
                    // add the right char to Set
                    // find the max length.
        // return max length


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
