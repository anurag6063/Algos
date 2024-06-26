
// 

import java.util.*;

class Solution {
		
        static void solution(int[] arr, int size) {
            
           // here we will do from the backside.
           // use a stack to know the lrgest element.
           // i am using stack because the sequence/order is important 
           // doing from back becasuse it's to the right algo needed. 
           
           
            int[] ans = new int[size];
            System.out.println(ans.length);
            Stack<Integer> stack = new Stack<>();
            // @Important direction of loop got reversed here. 
            for(int i = 0; i < size ; i ++){
                // think when to insert in the stack. and when to pop
                // if empty then ans has to -1
                if(stack.isEmpty()){ans[i] = -1; }
                // if element in stack is larger, that's the answer
                else if( stack.peek() > arr[i] ){ ans[i] = stack.peek(); }
                // if the stack has element is smaller, then we need to find an element which is greater
                // or else the stack becomes empty
                else if(arr[i] >= stack.peek()){
                    //@Important keep popping till the stack goes empty & the stack has a lower number. 
                    while(!stack.isEmpty() && arr[i] >= stack.peek() ){
                        stack.pop();
                    }
                    // now after the process if empty set -1
                    if(stack.isEmpty()){ ans[i] = -1;}
                    else{
                    // else we have found our answer. 
                        ans[i]= stack.peek();
                    }
                }
                
                stack.push(arr[i]);
                
                System.out.printf("comparing %d , %d %n", arr[i], stack.peek());
                System.out.println("-");
            }
            
          Arrays.stream(ans).forEach(s -> System.out.print(s+ " "));
          System.out.println();
  
			
		}
	
}


public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        int arr[] = { 1,3,2,4 };
        System.out.println("Before processing array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
      //  Solution.solutionBrute(arr, n);
        Solution.solution(arr, n);
        System.out.println("After processing array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}