/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/?envType=list&envId=ph9f65i7
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */


// not working yet

class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.length() == 0) return -1;
        if(needle.length() ==1 && haystack.length() ==1 && needle.equalsIgnoreCase(haystack)){ 
             return 0;
            }
        int index = -1;
        for(int i=0; i< haystack.length()- needle.length() ; i++){
            // System.out.println(haystack.substring(i,haystack.length()));
            // if(haystack.substring(i,haystack.length()).startsWith(needle)){
            // return i;
            // }
            System.out.println("for "+haystack.charAt(i) + " "+ i);
            boolean match = true;
            for(int j=i; j < needle.length(); j++)
            {
                if(haystack.charAt(j) != needle.charAt(j)){
                    System.out.println("not "+needle.charAt(i));

                    match = false;
                }else{
                    System.out.println("matched "+needle.charAt(i));

                }
            }
            if(match){
            System.out.println(i + "pass");
                return i;}

        }

        return index;
    }
}