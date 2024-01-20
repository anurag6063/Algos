
/*
[Note]
[Reference]: https://walkccc.me/LeetCode/problems/0345/
[Problem]: https://leetcode.com/problems/reverse-vowels-of-a-string/
[Pattern]: 2 pointers,  reverse, + inner while
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

class Solution {
    public String reverseVowels(String s) {
        // s = s.toLowerCase();
        int l = 0;
        int r = s.length()-1;
        char[] str = s.toCharArray();
        
        while(l < r){
            
            System.out.println(l + " "+ r);
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
        
        return String.valueOf(str);
    }
}