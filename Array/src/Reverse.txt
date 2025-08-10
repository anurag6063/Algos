/*
# Algos
[Note]
[Reference]: https://www.youtube.com/watch?v=twuC1F6gLI8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=4
[Problem]: https://leetcode.com/problems/reverse-string/
[Pattern]: recursion
[Tips]: l++ and r-- was not working so i did seperatley
[Revision]: 0
[Confidence]: 80%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.
 */

class SolutionSimple {
    public void reverseString(char[] s) {
         
        int l =0;
        int r = s.length -1;
        while(l < r){
            // swap;
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
            
        }
        
        System.out.println(s);
    }
}

class Solution {
    public void reverseString(char[] s) {
         
        int l = 0;
        int r = s.length-1;
        reverse(s, l, r);
    }

    private static void reverse(char[] s , int l, int r){
        System.out.printf(" l %d , r %d \n", l , r);
        if(l > r) return;

        swap(s, l, r);
        l = l +1;
        r = r -1;        
        reverse(s, l, r);
        
    }

    private static void swap(char[] s, int l, int r){
           char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
        
    }
}