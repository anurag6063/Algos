import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {
    
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Accumulate the digits to form the number
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                // push and reset
                // Push the current number and current string onto the stacks
                System.out.println("x "+currentString);
                numStack.push(num); // pushing the current number.
                strStack.push(currentString); // pushing the prvious string.
                num = 0; // Reset the number
                currentString = new StringBuilder(); // Reset the current string
            } else if (ch == ']') {
                // build
                // Pop the previous number and string from the stacks
                int repeatTimes = numStack.pop(); // we need to use current no
                StringBuilder decodedString = strStack.pop(); // need to append to the previous string

                // Append the current string repeated by the number
                for (int i = 0; i < repeatTimes; i++) { 
                    decodedString.append(currentString); // append the current string to the decoded string as many no of times as it's said.
                }

                // Update the current string to the decoded string, so that this becomes the previous one and also get's stored in stack.
                currentString = decodedString; 
            } else {
                // Append characters to the current string
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(decodeString("3[a]2[bc]")); // Output: "aaabcbc"
        System.out.println(decodeString("3[a2[c]]")); // Output: "accaccacc"
        System.out.println(decodeString("2[abc]3[cd]ef")); // Output: "abcabccdcdcdef"
    }
}


// as submitted in leetcode
class Solution {
    public String decodeString(String s) {
        // create 2 stack.
        // 4 conditions
        // if digin push to num stack
        // if [ starts, push the previous string and current no of stack and reset
        // if ] build the final string , use no from stack, now set previous as current.
        // if char itself kepe building.
// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"
        Stack<StringBuilder> charStack = new Stack<>(); // empty/
        Stack<Integer> numStack = new Stack<>(); // empty
        int num =0; // 0
        StringBuilder sb = new StringBuilder(); // "" 4.=aaa
        char[] chars = s.toCharArray(); // 3,[,a,],2,b,c,]
        
        for(char x: chars){ // loop
        // 1.a -> 2.[ -> 3.]
            if(Character.isDigit(x)){ // 1.yes 
                num = num * 10 + (x - '0'); //0*10 + 112 -100 = 0+2 =2
            }else if(x == '['){ // 2.yes
                charStack.push(sb); // ""
                numStack.push(num); // 2

                sb = new StringBuilder(); // ""
                num = 0; // 0
            }else if(x == ']'){ // 4.yes
                int nums = numStack.pop(); // 2 = numStack=""
                StringBuilder prev = charStack.pop(); //prev="" 

                for(int i=0; i<nums; i++){
                    prev.append(sb);  // ""+a -> a+"a"
                }

                sb = prev;  // 
            }else { // 3.yes
                sb.append(x);
            }

        }

        return sb.toString();
    }
}