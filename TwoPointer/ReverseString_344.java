


/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/reverse-string
[Pattern]: 2 pointersl; reverse direction	
[Tips]: keep incrementing and decrementing left++ and right--
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/
class Solution {
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


