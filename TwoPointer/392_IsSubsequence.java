
/*
[Note]
[Reference]: https://just4once.gitbooks.io/leetcode-notes/content/leetcode/binary-search/392-is-subsequence.html
[Problem]: https://leetcode.com/problems/is-subsequence/
[Pattern]: 2 pointers, array
[Tips]: Use 2 pointers on each string, loop longer one
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: keep a pointer at each, string small and large, inerate the large one and find value in small. if found increase j++
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/


class Solution {
    
     public boolean isSubsequence(String s, String t) {
          if( s.length() == 0  ) return true;
         // if(s.length() > t.length() || t.length() == 0 ) return false;
        
         
         int j = 0;
         int i = 0;
         while(i < t.length() && j < s.length()){
             // System.out.println(t.charAt(i) + " "+ s.charAt(j));
             if(t.charAt(i) == s.charAt(j)){
                 j++;
             }
             i++;
         }
         System.out.println(j);
         return s.length() == j ? true : false;
         
     }
    
    public boolean isSubsequence1(String s, String t) {
        // char[] ss = s.toCharArray();
        // char[] tt = t.toCharArray();
        int count = 0;
        int k =0;
        for(int i=0; i< s.length(); i++){
            for(int j=k; j< t.length(); j++){
                // System.out.println("i: "+ i + "j "+ j + "k: "+ k);
                if(s.charAt(i) == t.charAt(j)){
                    // System.out.println("found"+ ss[i]);
                    count++;
                    k=j+1;
                    break;
                }
            }
        }

        if(count == s.length()){
            return true;
        }
        else return false;
      
      
      
      
      // here
    }
}

  // Arrays.sort(ss);
        // Arrays.sort(tt);
        // System.out.println(String.valueOf(ss));
        // System.out.println(String.valueOf(tt));

        // if(String.valueOf(tt).contains(String.valueOf(ss))){
        //     return true;
        // }
        // return false;