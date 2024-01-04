/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/longest-common-prefix/
[Pattern]: Trick; Sort words; Compare first and last word's chars
[Tips]: Sort words; Compare first and last word's chars
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	for(int i=0; i< strs[0].length(); i++){
		if(strs[0].charAt(i) == strs[strs.length-1].charAt(i))
			result.append(strs[0].charAt(i));
		else
			break;
	}
[/Code]
[/Note]
*/

/*
 * https://leetcode.com/problems/longest-common-prefix/
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 


 */

// wrote myself
class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder result = new StringBuilder();
        // i wish to do vertical comparison so that i can find if the first element is present is all the words or not. But the issue is length of each word.
        Arrays.sort(strs);
        for(int i=0; i< strs[0].length(); i++){
            if(strs[0].charAt(i) == strs[strs.length-1].charAt(i))
                result.append(strs[0].charAt(i));
            else
                break;
        }

        return result.toString();
    }
}
// ----------------------------
import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) return "";
        if(strs.length == 1 ) return strs[0];
        Arrays.sort(strs);
        if(strs[0].length() == 0) return strs[0];
        if(strs[strs.length-1].length() == 0) return strs[strs.length-1];

        StringBuilder sb = new StringBuilder();

        for(int i=0; i< strs[0].length(); i++){
            if(strs[0].charAt(i) != strs[strs.length -1].charAt(i))
            {   System.out.println(sb.toString());
                return sb.toString();}
            else
            {sb.append(strs[0].charAt(i));
             System.out.println(": "+sb.toString()); }
        
        }

        return sb.toString();
       
    }
}
        /*
        int count = 0;
        // loop over all the strings in list. 
        for(int i=1; i< strs.length ; i++){
            String text = strs[i];
            int sizeLarge = Math.max(strs[i].length(), strs[i-1].length);
            while( text.hasNext() != null){
                System.out.println("x");
            }

            if(strs[i].charOf(0) != strs[i].charOf(0)){
                return count;
            }
        }

        while()
        */

        // StringBuilder prifix = new StringBuilder();
        //      for(int i=0 ; i< strs.length-1 ; i++){
        //         char a = strs[0].charAt(i);
        //         for(int j=0; j< strs[i].length(); j++){
        //             char t = strs[i].charAt(j);
        //             if(strs[i].charAt(j) != a){
        //                 return prifix.toString();
        //             }
        //         }
        //         prifix.append(a) ;
                

        //      }

        // return prifix.toString();




        
//     }
// }
