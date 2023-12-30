
/*
https://leetcode.com/problems/score-of-parentheses/description/?envType=list&envId=pheho7s5

Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.

// can't use just the character, since they have value associated with them when we have nesting. 
*/

class Solution {
    public int scoreOfParentheses(String s) {
        

        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        char[] chars = s.toCharArray();
        for(char x: chars){
            if( x == '('){
                stack.push(ans);
                ans = 0;
            }else {
                ans = stack.pop() + Math.max(2*ans, 1);
            }
        }
        return ans;
    }
}

// "(()(()))"