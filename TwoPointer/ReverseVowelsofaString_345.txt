
/*
[Note]
[Reference]: https://walkccc.me/LeetCode/problems/0345/
[Problem]: https://leetcode.com/problems/reverse-vowels-of-a-string/
[Pattern]: 2 pointers,  reverse, + inner while; swap
[Tips]: use inner while loop to skip non vowels; use "aeiouAEIOU".indexOf(c) != -1; to check vowels. 
[Revision]: 1
[Confidence]: 30%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s = "hello"
Output: "holle"
*/

class Solution {
    public String reverseVowels(String s) {
        // s = s.toLowerCase();
        int l = 0;
        int r = s.length()-1;
        char[] str = s.toCharArray();
        
        while(l < r){
  // use while too to skip till i find a volwels          
            System.out.println(l + " "+ r);
            // sometime if i know i am looking for a small no of values like here it's vowels in emglish, i can simple put them
            // in a string and find a index of to search if present or not.
            while(l < r && !( "aeiouAEIOU".indexOf(str[l]) != -1 )) {
                System.out.println(l + " L "+ r);
                l++;
            }
            
            while(l < r && !("aeiouAEIOU".indexOf(str[r]) != -1)) {
                System.out.println(l + " R "+ r);
                r--;
            }
            
            // swap
            char temp = str[l];
            str[l] = str[r];
            str[r] = temp;
            
            l++;
            r--;
        }
        
        System.out.println(str);
// #Note: To convert any char array to string - String.value.Of(<charArray>)
        return String.valueOf(str);
    }
}