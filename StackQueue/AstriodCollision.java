/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/asteroid-collision/?envType=list&envId=pheho7s5
[Pattern]: Stack + cond
[Tips]: Always consider the sigh, direction first as a case for collision and then the size value of N. Here if a value being
 pushed is +ve no issues, only when -ve think. When collision starts it can continue for the other existing ones too. 
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
need to revisit. - ans fails in submit.


We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, 
negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. 
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<Integer>();
//  10, 2, -5
        for(int i=0; i< asteroids.length; i++){ // [0] [1] [2]
           
            if(stack.size() == 0 || asteroids[i] > 0)// [0] 1,10 [1]// is moving right or empty 
            { // 
                stack.push(asteroids[i]); // [0] stack = 10 [1] stack = 10,2
            }
            else{
                // we know it's  negative, for collosion we want the stack top to be postive
                while(!stack.isEmpty() && stack.peek() > 0){  // stack = 10,2 // stack = 10,-5
                    int pop = stack.pop(); // pop = 2
                    if(pop == Math.abs(asteroids[i])){ // 2 == 5
                        break;
                    }
                    else if(pop > Math.abs(asteroids[i])){ // 2 > 5 
                        stack.push(pop); // stack = 10,-5
                        break;
                    }
                }
            }
        }
        
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}

import java.util.Stack;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            // If the stack is empty or the asteroid is moving to the right, add it to the stack
            if (stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
            } else {
                // Handle collisions with asteroids moving to the left
                while (!stack.isEmpty() && stack.peek() > 0) {
                    // Compare the absolute values of the asteroids
                    int topAsteroid = stack.pop();
                    if (topAsteroid == Math.abs(asteroid)) {
                        // Both asteroids explode if they are of the same size
                        break;
                    } else if (topAsteroid > Math.abs(asteroid)) {
                        // The current asteroid is destroyed, so push the topAsteroid back to the stack
                        stack.push(topAsteroid);
                        break;
                    }
                }
            }
        }

        // Convert the stack to an array for the final result
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        int[] result = asteroidCollision(asteroids);

        // Print the result
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}

