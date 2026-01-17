//package java.org.example.heap;
package BasicsDSASheet.src.main.java.org.example.heap;
import java.lang.invoke.StringConcatFactory;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/convert-infix-expression-to-postfix-expression/
 */
public class InfixToPostfix {

  int precedence(char c){
    // BODMAS
    if(c == '^') return 3;
    if(c == '/' || c == '*') return 2;
    if(c == '+' || c == '-') return 1;
    else return -1;
  }

  private String toPostfix(String exp){
    StringBuilder ans = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for(int i=0; i< exp.length(); i++){
      char c = exp.charAt(i);
      if(Character.isLetterOrDigit(c)){
        ans.append(c);
      }else if(c == '('){
        stack.push('(');
      } else if (c == ')'){
        while(stack.peek() != '('){
          ans.append(stack.pop());
        }
        stack.pop();
      } else {
        while (!stack.isEmpty() && (precedence(c) <= precedence(stack.peek()))) {
          ans.append(stack.pop());
        }
        stack.push(c);
      }
    }


    while(!stack.isEmpty()){
      ans.append(stack.pop());
    }

    return ans.toString();
  }
  public static void main(String[] args) {
    InfixToPostfix gfg = new InfixToPostfix();
    String exp = "a+b*(c^d-e)^(f+g*h)-i";
    System.out.println(gfg.toPostfix(exp));
  }
}
