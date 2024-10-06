/**
 * https://www.educative.io/courses/grokking-coding-interview-patterns-java/reverse-words-in-a-string
 * 
 * Reverse Words in a String

 */

import java.util.*;

public class Main{
    public static String reverseWords(String sentence) {

        String[] words = sentence.split(" ");
        // Replace this placeholder return statement with your code

    // 2 pointer approach.
    // initialize: left and right to 0 and len-1.
    // do till:  while( left < right)
    // break and return if: Do swap the words
    // change: left ++ and right --;


        int left = 0;
        int right = words.length-1;

        while(left < right){
                 
            // System.out.println( "\""+words[left] +":"+ words[right]+"\"");
            // swap 
            String tmp = words[right].trim();
            words[right] = words[left].trim();
            words[left] = tmp;

            left++;
            right--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i< words.length; i++){

            // if the split word had a space, we need to skip it. 
            if( !(words[i].equalsIgnoreCase(" ") || words[i].equalsIgnoreCase("") ))
            sb.append(words[i]+ " ");
        
        }
        return sb.toString().trim();
    }
}

