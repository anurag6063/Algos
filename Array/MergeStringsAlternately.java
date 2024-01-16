/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/merge-strings-alternately/description/?envType=list&envId=ph9f65i7
[Pattern]: While Loop + length ; Merge till either one has length.
[Tips]: Check length and then append.
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: while i is word1.len || i is word2.len ; if either i has less then append ; finally i++
[Code]	
	  while (i < word1.length() || i < word2.length()) {
[/Code]
[/Note]
*/
/*
https://leetcode.com/problems/merge-strings-alternately/description/?envType=list&envId=ph9f65i7

You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.
*/

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
            i++;
        }
        return result.toString();
    }
}