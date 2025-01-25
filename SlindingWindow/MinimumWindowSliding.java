https://leetcode.com/problems/minimum-window-substring/description/

/**
 Question:
 2 string, s and t.
 lenght , and n respectively.
 return min window substring, every char is t including duplicate is included in window.
 else ""

 Understand:
 t needs be wound in s
 t may have repeated chars.
 minimum window needs to be found. So that means the chars can be apart.

 simple check:
 len s should be greater than t.
 its a window so they need to be consecutive.

 first window will be formed when i find all the chars.
 now from this time.
 if i find any needed char again. then it needs to be the starting of window char.
 if yes reduce it.


 */

class Solution {

  /*
  simple way is to start from i index and find all the chars if dound store the start and end.
  then find the min.
  */
  public String minWindow(String s, String t) {
    // setup
    int[] arr = new int[128];
    int count = 0;
    for(char c: t.toCharArray()){
      x[c]++;
      count++;
    }

    // now the arr will have the frequency of all the chars of t. that needs to be found.
    // now if it count becomes 0 gain that means all the elements have been found.

    int begin = 0, end =0; dis= Integer.MAX_VALUE, head = 0, ans = Integer.MAX_VALUE;

    while(end < s.length()){
      if(x[s.getCharAt(end)] > 0){
        counter++;
        x[s.getCharAt(end)--];
      }

      while(counter == 0){
        dis = end - begin;
        ans = Math.min(ans, dis);
        head = begin;

        if(x[s.charAt(begin)] == 0){
          counter++;
        }
      }
    }


    while(end < s.length()){
      if(x[s.charAt(end++)-- > 0]){ // found one char
        counter--;
      }

      while(counter == 0 ){
        if(end - begin < d){
          d = end-begin;
          head = begin;
        }

        if(x[s.charAt(begin++)++] == 0){
          counter ++;
        }
      }
    }

    return d = Integer.MAX_VALUE?"": s.substring(head, head+d);

  }
}