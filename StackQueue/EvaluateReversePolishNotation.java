/*
https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?envType=list&envId=pheho7s5

*/
class Solution {
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