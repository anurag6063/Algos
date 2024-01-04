/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/longest-substring-without-repeating-characters/
[Pattern]: Unique Character tracking; HashSet
[Tips]: Use HashSet to keep track of unique string; If a char is repeated - clear the HashSet; Finally return only the longest subString use max value;
[Revision]: 1
[Confidence]: 50%
[Next]: Practice 
[Steps]: Use a hashSet; for each letter -> if set contains the char; set set.clear() and result = 0; if not then ass the char to the set and increment the result. Outsise the if/else; find the max b/w earlier max substringand the current length of substring.
[Code]	
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
[/Code]
[/Note]
*/

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


// -----------------------------
// INCORRECT ANSWER, BUT ALWAYS COMES TO MIND

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int max = 0;

        int left = 0;
        int right = 1;  // here if not starting from one, the if condition below will always satisfy as true and keep incrementing. it can work well btw when we want to find repeating characters. 
        
        int n = s.length();
       // this did not work because the right moved on without checking if that word was there in the window. So it had non unique characrters. 
        while(right < n){
            max = Math.max(max, right-left);
            System.out.println(max + " "+ left + " "+ right);
            if(left < n && s.charAt(left) == s.charAt(right)){
                while(left < n && s.charAt(left) == s.charAt(right)){
                    left++;
                    System.out.println("left");
                }
            }
            right++;
        }
        return max;

    }
}

// ------------------------------
// OPTIMIZED

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int max = 0;
        Set<Character> set = new HashSet<Character>();

        int left = 0;
        int right =0;

        while(right < s.length()){
            // if it does not contains
            if(!set.contains(s.charAt(right))){
                // as we have found a unique character the window length increases
                max = Math.max(max, right - left+1);
            //    System.out.println("not repeated- left: "+ left + " right: "+ right);

            }else {
                // System.out.println("repeated - left: "+ left + " right: "+ right);

                // we need to check for right and remove char left from the set irrespective of positin because the dupicate can be at any place in the window. 
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            right++;
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
