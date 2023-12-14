/*
https://leetcode.com/problems/generate-parentheses/?envType=list&envId=pheho7s5

here stack is used automatically, it's not stack tather recursion.
remember the 3 conditions and how to use the result at the end

@Question: how the variations are created here?

*/

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, 0, 0, "", result);
        return result;
    }

    private static void generateParenthesisHelper(int n, int openCount, int closeCount, String current, List<String> result) {
        // Base case: If we have used all parentheses, add the combination to the result
        if (openCount == n && closeCount == n) {
            result.add(current);
            return;
        }

        // Add an open parenthesis if we haven't used all open parentheses
        if (openCount < n) {
            generateParenthesisHelper(n, openCount + 1, closeCount, current + "(", result);
        }

        // Add a close parenthesis if it is valid (i.e., there are open parentheses to match)
        if (closeCount < openCount) {
            generateParenthesisHelper(n, openCount, closeCount + 1, current + ")", result);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> combinations = generateParenthesis(n);
        
        System.out.println("Combinations of well-formed parentheses for n = " + n + ":");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}
