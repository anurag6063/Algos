/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/longest-substring-without-repeating-characters
[Pattern]: Sliding Window - variable size
[Tips]: Remember to add the right char in else condition too; non repeating chars, use HashSet, if chars dont match simple add the right, else while set contains the element first remove char in left, then add it into it. SubString -> slidingWindow; NonRepeatig Character -> HashSet ; No window size given -> dynamic wondow
[Revision]: 2
[Confidence]: 70%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/
/*
Intution: 
HS is used to control the window. 
The window size is determined by boundary set by left and right, do a +1 since we have 0 indexed DS.
While the HS has the character i saw on right, then remove it from the HS. 

else always i need to put char at right in HS 
and find the max window i can see. 


*/

import java.util.HashSet;
import java.util.Set;

// my clear solution.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // substring = sliding window - no k, dynamic window size
        // repeating char = hashset

        int left = 0;
        int right = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<Character>();

        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));          
            }else{
                while(set.contains(s.charAt(right))){ // needed for string like "pwwkew"
                    set.remove(s.charAt(left)); // remove from set element that's there in left. and do left++
                    left++;
                }      
                set.add(s.charAt(right));        
            }
            maxLen = Math.max(maxLen, right-left+1); // becuse 0 indexed
            right++;
            
        }

        return maxLen;
    }
}



class Solution {
    public int lengthOfLongestSubstring(String s) {

        int ans = 0;
        int maxSize = 0; // will work since there will not be any negative value.

        Set<Character> set = new HashSet<>();
        // dynamic sliding window
        int left =0;
        int right =0;
        while(right < s.length()){

            // no k so both will move dynamically
            // condition to move is substing with NO REPEATING character
            // how to maintain that? HashSet
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                // find the max
                maxSize = Math.max(maxSize, right-left+1);
                right++;
            }else{
                // if the incoming right character is present in set, i will have to remove all the elements to the left of this repeated character
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
                // will not do the max here becuase it will never be the answer. 
                set.add(s.charAt(right));
                right++;
            }

            
        }

    return maxSize;
    }
}

import java.util.*;

class Solution {
    
	public int lengthOfLongestSubstring_explained(String s) {
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
                // we need this since the the duplicate characted may not be the first left character
                // to reach and remove everything till the character occurs, i am using a while loop. 
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



/*
A better solution with less line, saw earlier code and made it simpler.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left = 0;
        int maxLen = 0;

        HashSet<Character> hs = new HashSet<>();

        for(int right = 0; right < s.length(); right++){

            while(hs.contains(s.charAt(right))){
                hs.remove(s.charAt(left));
                left++;
                System.out.println(s.charAt(right));
            }

            maxLen = Math.max(maxLen, right - left +1);
            hs.add(s.charAt(right));
        }
        
        return maxLen;
    }
}
