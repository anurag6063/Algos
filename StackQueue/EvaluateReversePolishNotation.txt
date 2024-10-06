/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?envType=list&envId=pheho7s5
[Pattern]: Min Stack
[Tips]: Using String and Integer .valueOf for conversion, assume if not 4 valid symbol its a number.
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

/*
https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?envType=list&envId=pheho7s5

*/
/**
 * My solution using extra space of a stack but much simplifies and straight
 * 
 */
class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<String> st = new Stack<>();

        for(String x : tokens){
            System.out.println(" x "+ x);
            // char x = tokens[i];
            // check the token type
            // chekc for special chars first. Since it said only 4 valid char types will be there
            // at end i am assuming to be no and pushing in
            if(x.equalsIgnoreCase("/")){
                System.out.println("in / ");
// #Note: lot of Integer.valueOf and String.valueOf being used for conversion
                int a = Integer.valueOf(st.pop());
                int b = Integer.valueOf(st.pop());
                int res = b/a;
                st.push(String.valueOf(res));
                System.out.println("res : " + res);
            }else if( x.equalsIgnoreCase("+")){
                System.out.println("in + ");
                int a = Integer.valueOf(st.pop());
                int b = Integer.valueOf(st.pop());
                int res = a+b;
                st.push(String.valueOf(res));
                System.out.println("res : " + res);
            }else if( x.equalsIgnoreCase("-")){
                System.out.println("in - ");
                int a = Integer.valueOf(st.pop());
                int b = Integer.valueOf(st.pop());
                int res = b-a;
                st.push(String.valueOf(res));
                System.out.println("res : " + res);
            }else if( x.equalsIgnoreCase("*")){
                System.out.println("in * ");
                int a = Integer.valueOf(st.pop());
                int b = Integer.valueOf(st.pop());
                int res = b*a;
                st.push(String.valueOf(res));
                System.out.println("res : " + res);
            }else{
                st.push(x);
            }
        }

        return Integer.valueOf(st.peek());
    }
}

// --- 

class Solution {

    class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<String> st = new Stack<>();

        for(String x : tokens){
            System.out.println(" x "+ x);
            // char x = tokens[i];
            if(x.equalsIgnoreCase("/")){
                System.out.println("in / ");
                int a = Integer.valueOf(st.pop());
                int b = Integer.valueOf(st.pop());
                int res = b/a;
                st.push(String.valueOf(res));
                System.out.println("res : " + res);
            }else if( x.equalsIgnoreCase("+")){
                System.out.println("in + ");
                int a = Integer.valueOf(st.pop());
                int b = Integer.valueOf(st.pop());
                int res = a+b;
                st.push(String.valueOf(res));
                System.out.println("res : " + res);
            }else if( x.equalsIgnoreCase("-")){
                System.out.println("in - ");
                int a = Integer.valueOf(st.pop());
                int b = Integer.valueOf(st.pop());
                int res = b-a;
                st.push(String.valueOf(res));
                System.out.println("res : " + res);
            }else if( x.equalsIgnoreCase("*")){
                System.out.println("in * ");
                int a = Integer.valueOf(st.pop());
                int b = Integer.valueOf(st.pop());
                int res = b*a;
                st.push(String.valueOf(res));
                System.out.println("res : " + res);
            }else{
                st.push(x);
            }
        }

        return Integer.valueOf(st.peek());
    }
}
    public int evalRPN(String[] tokens) {
        int ans = 0;
        int n = tokens.length;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i< n; i++){
            // if digit
           if( stack.size() >= 2 && tokens[i].equalsIgnoreCase("+")){
                     int a = stack.pop();
                    int b = stack.pop();
                    ans = b + a; 
                    stack.push(ans);           
            }else if(stack.size() >= 2 && tokens[i].equalsIgnoreCase("-")){
                    int a = stack.pop();
                    int b = stack.pop();
                    ans = b - a; 
                    stack.push(ans);                              
            }else if(stack.size() >= 2 && tokens[i].equalsIgnoreCase("*")){
                     int a = stack.pop();
                    int b = stack.pop();
                    ans = b * a; 
                    stack.push(ans);                                
            }else if(stack.size() >= 2 &&tokens[i].equalsIgnoreCase("/")){
                    int a = stack.pop();
                    int b = stack.pop();
                    ans = b / a;     
                    System.out.println("ans"+ ans);    
                    stack.push(ans);                      
            }else{
                stack.push(Integer.parseInt(tokens[i]));
                System.out.println(tokens[i] + " :  "+ stack.size() );
            }
        }

        return stack.pop();
    }
}


// chatGPT

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                // If the token is an operator, pop two operands and perform the operation
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, token);
                stack.push(result);
            } else {
                // If the token is an operand, push it onto the stack
                stack.push(Integer.parseInt(token));
            }
        }

        // The final result should be on the top of the stack
        return stack.pop();
    }

    private boolean isOperator(String token) {
        // Check if the token is one of the valid operators
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int performOperation(int operand1, int operand2, String operator) {
        // Perform the operation based on the operator
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluator = new EvaluateReversePolishNotation();
        String[] tokens = {"2", "1", "+", "3", "*"};
        int result = evaluator.evalRPN(tokens);
        System.out.println("Result: " + result);  // Output: 9
    }
}


// fastest approach:
class Solution {
   public int evalRPN(String[] tokens) {
 int[] ls = new int[tokens.length/2+1];
    int index = 0;
    for (String token : tokens) {
        switch (token) {
            case "+":
                ls[index - 2] = ls[index - 2] + ls[index - 1];
                index--;
                break;
            case "-":
                ls[index - 2] = ls[index - 2] - ls[index - 1];
                index--;
                break;
            case "*":
                ls[index - 2] = ls[index - 2] * ls[index - 1];
                index--;
                break;
            case "/":
                ls[index - 2] = ls[index - 2] / ls[index - 1];
                index--;
                break;
            default:
                ls[index++] = Integer.parseInt(token);
                break;
        }
    }
    return ls[0];
}
}