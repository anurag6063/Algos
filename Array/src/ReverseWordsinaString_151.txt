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

class ReverseWordsinaString_151 {
    public String reverseWords(String s) {
        /*
        Task: reverse words , create line again and return
        Word? - non space characters, atleast one space is needed
        return? - string reverse seperated by 1 space
        Limit- s may. have white space is front and back
        */

        /*

        Limit - Trim
        Validate - s has length

        Work -
        - spilt by space
        - trim
        - read from back (for)
            - if has chars add to line with a trailing space

        - trim last space.
        */

        if(s == null) return "";
        s = s.trim();
        if(s.length() == 0 ) return "";

        String[] parts = s.split("\\s+");

        StringBuffer reversedLine = new StringBuffer();
        int len = parts.length;
        for(int i = 0 ; i < parts.length; i++){
            reversedLine.append(parts[len-i-1].trim() + " ");
        }

        return reversedLine.toString().trim();

    }
}