/*
question: 'https://leetcode.com/problems/is-subsequence/'
problemStatement: |
  If string s is found in string t, by relative position.
  i.e., all characters in s should be found in t in the given order.
intuition: >
  Need to loop over the s char array and t char array simultaneously,
  increase count when I find the character to be matching.
  Since I need to find all the chars in s, I will increase the counter of s only
  when there is a match,
  but for t, I will increase its counter value regardless.
  Old: Keep a pointer at each, string small and large, iterate the large one and find value in small. if found increase j++
diagram: ''
pattern:
  - 2 pointers
  - loop both at once
solutionReference: 'https://just4once.gitbooks.io/leetcode-notes/content/leetcode/binary-search/392-is-subsequence.html'
*/

public class IsSubsequence {
    
     public boolean isSubsequence(String s, String t) {
          if( s.length() == 0  ) return true;
          if(s.length() > t.length() || t.length() == 0 ) return false;
         int j = 0;
         int i = 0;
         while(i < t.length() && j < s.length()){
             if(t.charAt(i) == s.charAt(j)){
                 j++;
             }
             i++;
         }
         System.out.println(j);
         return s.length() == j ? true : false;
         
     }
    
    public boolean isSubsequenceNested(String s, String t) {
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
    }
}