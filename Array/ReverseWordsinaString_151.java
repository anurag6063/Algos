/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/reverse-words-in-a-string/
[Pattern]: Array and reverse
[Tips]: to read in reverse direction use int i = array.length -1 and i >= 0
[Revision]: 1
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

class Solution {
    public String reverseWords(String s) {
        /*
        trim spaces 
        "the sky is blue" - split by space
        - the / sky / is / blue - read from back 
        - loop ad trim space
        
        */
        s = s.trim();
        String[] tokens = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i = tokens.length-1; i >= 0 ; i--){
            String token = tokens[i].trim();
            ans.append(token).append(" ");
        }
        
        return ans.toString().trim();
    }
}