/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/valid-parentheses/description/?envType=list&envId=pheho7s5
[Pattern]: stack
[Tips]: handle 6 cases, 3 to insert and 3 to pop and delete
[Revision]: 0
[Confidence]: 80%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 * 
 * /
 
 /**
  * 
  * here i have only 3 brackets to handle
  * total 6 cases
  * in 6 cases, 3 have insert, 3 ie closinf, just pop and check for starter being present
  * while popping what the edge case. 
  * it can be empty, so check that.
  * 
  * Also before starting if count is odd it's anyways invalid.
  */

class Solution {
    public boolean isValid(String s) {
        System.out.println(s);

        // return simpleOne(s);

        return stackOne(s);

    
    }

    boolean stackOne(String s){

        if(s.length() < 2){
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stackChar = new Stack<Character>();

        for(char x: chars){

            if(x == '('){
                stackChar.push(x);
            }

            if(x == ')'){
                // stackChar.pop();
                if(stackChar.empty() ){                    
                   
                    return false;
                }else{
                     if(stackChar.pop() != '('){
                        return false;
                    }
                }
            }

             if(x == '['){
                stackChar.push(x);
            }

            if(x == ']'){
                // stackChar.pop();
                if(stackChar.empty() ){                    
                   
                    return false;
                }else{
                     if(stackChar.pop() != '['){
                        return false;
                    }
                }
            }

              if(x == '{'){
                stackChar.push(x);
            }

             if(x == '}'){
                // stackChar.pop();
                if(stackChar.empty() ){                    
                   
                    return false;
                }else{
                     if(stackChar.pop() != '{'){
                        return false;
                    }
                }
            }
        }

        return stackChar.empty();
    }

    boolean simpleOne(String s){
            char[] c =  s.toCharArray();
        int len = c.length;
        int i= 0;
        while(i < len){
             System.out.println(c[i] + " : "+ c[i+1]);
             System.out.println(s.charAt(i) == s.charAt(i+1));
          
            if(c[i] == '('){
                if(!(c[i+1] == ')')){
                    return false;
                }

            }

             if(c[i] == '['){
                if(!(c[i+1] == ']')){
                    return false;
                }

            }

             if(c[i] == '{'){
                if(!(c[i+1] == '}')){
                    return false;
                }

            }
            i = i+2 ;
        }
    
        return true;
    }
}

