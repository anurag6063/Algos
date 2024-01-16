/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/valid-anagram/
[Pattern]: Counter
[Tips]: mainitain a counter for all the possible chars, increase, decrease, for anangram all should be 0 finally.
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: convert to charArray, if only aplhabets stores, size of a int[] -> 'z' - a + 1; now in this counter add, remove and check if anything left. This same thing can be done using a hMap. 
[Code]	
	int size = 'z'-'a'+1;
    int[] note = new int[size];
[/Code]
[Tags]: 
[/Note]
*/

/**
 * https://leetcode.com/problems/valid-anagram/
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 */

// own code

// using char array counter
class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int size = 'z'-'a'+1;
        int[] note = new int[size];

        for(int i=0; i< sArr.length; i++){
            // System.out.println(sArr[i]-'a');
            note[sArr[i]-'a'] = note[sArr[i]-'a']+1;
        }
        for(int i=0; i< tArr.length; i++){
            note[tArr[i]-'a'] = note[tArr[i]-'a']-1;
        }
        for(int i=0; i< note.length; i++){
            if(note[i] != 0){
                return false;
            }
        }
        return true;
    }
}



// Using sorting
/*class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        String sA = new String(sArr);
        String tA = new String(tArr);
        if(sA.toString().equalsIgnoreCase(tA.toString())){
            return true;
        }
        return false;
    }
}
*/

// -------------------------

// assumption: that all have valid alphabets with no special characters. 
// add and minus from one array. 
// at last check for any element still having non 0. 

 class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()){
            return false;
        }

        int size = s.length();
        // char[] sArr = s.toCharArray();
        // char[] tArr = t.toCharArray();

        int freq[] = new int[26];
        
        for(int i=0; i< size ; i++){
            System.out.println( 'x' - 'a');
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int i=0; i< freq.length ; i++){
            if(freq[i] != 0)
                return false;
        }
         return true;
    }
}
