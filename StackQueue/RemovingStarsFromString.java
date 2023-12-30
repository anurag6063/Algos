/*
https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=list&envId=pheho7s5
*/

class Solution {
    public String removeStars(String s) {
// input string has words and start
// with a star we remove the work too. 
// it always gets removed from the start it. almost like a stack.
// leet**code*e
// using stack - leet* - lee - lee* - le - lecod* - leco - lecoe

// when i find a start as input just pop an element from the stack. 

char[] chars = s.toCharArray();
Stack<Character> st = new Stack<Character>();

    for(char c: chars){
        if(c != '*'){
            st.push(c);
        }else if(!st.isEmpty()){
            st.pop();
        }
    }
    StringBuilder sb = new StringBuilder();
    for(char c: st){
        sb.append(c);
    }
    return sb.toString();
    }
}