
//Fast and slow pointers
//  ---------------------

public int fn(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    int ans = 0;

while(fast !=null && fast.next != null){
   // do some logic
slow = slow.next;
fast = fast.next.next;

}
return ans;
}


// Efficient String building
//   ------------------------

public String func(char[] arr){
StringBuilder sb = new StringBuilder();

for(char c: arr){
sb.append(c);
}

return c.toString();
}


// sliding window
//   -------------

/*This is ideally just 2 nested loops.

One loop is outside that moves the right pointer always by 1.
Other is an inner loop.
This moves the left pointer. Till it's condition is satisfied. Or doesn't moves it when not satisfied.

Steps:
1. Initialise the value of left, current and answer
2. For loop the right pointer and move it single steps.
3. Since we are moving and things are coming in.
4. We so operation on current. Current stores out current state.
5. Then we check do we need to move left pointer too.
6. If satisfied we move the left pointer.
7. While doing so the span is changing so. We decrease the value from current. And also change the value of left. Mostly move it to right.
8. Outside the while loop and inside the for loop update the value of answer.
9. When all the right steps are done.
10. Return the answer.

*/
// needs practice

public int func(int[] arr){

int left = 0; right =0; ans =0;

while(right< arr.length){

while(<CONDITION_TO_MOVE_WINDOW){
left++;
}
right++;
}

}

// same thing in for loop

public int func(int[] arr){
int left =0, ans =0, curr =0;

for(int right =0; right< arr.length[]; right++)
{
// do logic to update curr; this will temporarily hold ans;
// ans
while(<CONDITION>){
// Update te
left++;
}

//update answer

}

return ans;
}


// 2 pointers, 2 inputs, exhaust both
//   ---------------------------------


public int func(int[] arr1, int[] arr2){

// initialize all at the 0 the starting line, extreme left.
int i =0, j =0; ans = 0;

while(i < arr1.length && j < arr2.length)
{
// do something, like copy the element in a new array or sum or compare
if(<CONDITION>){
i++;
}else{
j++;
}
}

while(i < arr1.length)
{
// some logic
i++;
}

while(j< arr2.length)
{
j++;
}

return ans;
}


// 2 pointers 1 array, opposite end
//   --------------------------------

public int func( int[] nums){
 
int left = 0;
int right = nums.length - 1;
int ans = 0;

while(left<right){

// do something with left and right ex in pallindrom check
// if nums[left] == nums[right];
// ++ this moving of pointer i can do at my different logic too.
// ++ if we move them without any condition, it becomes like a for loop.

// now move the pointer
if( <CONDITION>){
left++;
}else{
right++;
}
}
return ans;
}


/*-----------------

  Java String compareTo() method - javatpoint

public class CompareToExample{  
public static void main(String args[]){  
String s1="hello";  
String s2="hello";  
String s3="meklo";  
String s4="hemlo";  
String s5="flag";  
System.out.println(s1.compareTo(s2));//0 because both are equal  
System.out.println(s1.compareTo(s3));//-5 because "h" is 5 times lower than "m"  
System.out.println(s1.compareTo(s4));//-1 because "l" is 1 times lower than "m"  
System.out.println(s1.compareTo(s5));//2 because "h" is 2 times greater than "f"  
}}  

*/
//--------------------

import java.util.*;

public class CycleDetection{
    public static boolean detectCycle(LinkedListNode head) {
   
    if(head == null) return false;
    LinkedListNode slow = head;
    LinkedListNode fast = head.next;

    while(fast != null && fast.next != null){
      if( fast == slow){
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }
}


//Same row and column count - matrix
/*
https://leetcode.com/problems/equal-row-and-column-pairs/solutions/?envType=study-plan-v2&envId=leetcode-75

1. 2 loops to find i and j that goes for 0 to n; this 2 loops gives all variation of row and col
2. now when we have value for row and col
3. loop for 0 to length in x
4. loop for grid[row][x] == grid[x][col]
5. if the condition is not satisfied; break and set flag as not same
6. if flag is notsame = false ; increase the count.


Unique occurrences of nums

https://leetcode.com/problems/unique-number-of-occurrences/submissions/?envType=study-plan-v2&envId=leetcode-75

1. loop and find count in hashSet
2. get the size of values in hashSet
3. get a set of values of hashSet.
4. compare size.


Merge overlapping interval

https://pega.udemy.com/course/blind-75-leetcode-questions-ace-algorithms-coding-interview/learn/lecture/36922776#overview

loops 3 times
1. before any overlap.
2. in overlap and keep updating start and end time
3. after the overlap.


max avg

https://leetcode.com/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75

need to do memorization optimization for this.
better trick is to just find max of sum and do the divide by K at last. Since if sum is more the divided value will also be more.

better is to find the initial sum
and then as we slide through - sum = minus old value and plus new value.


is string A subsequence of string B

https://leetcode.com/problems/is-subsequence/submissions/?envType=study-plan-v2&envId=leetcode-75

Have k =0; this keep a index till where we have seen string B
Count = 0; this is to track till now how many time did we get char of A in B. If their count of chars in A is equal to count then we found all.

1. Use 2 loops.
2. outer - from i to length of A
3. inner - from j=k
4. check if A.charAt(i) == B.charAt(j)
5. if found - count++ ; one more char found. also this is from where next J should start so, k=j+1 also since we found it. lets break in inner for loop. break;
6. outside both the loop.
7. if count == A.len return true
8. by default return false.


all 0s to end

https://leetcode.com/problems/move-zeroes/submissions/?envType=study-plan-v2&envId=leetcode-75

sliding window variation

1. intialize left right to 0
2. loop for right< length and do r++ at end. - this is like for loop with 1 increments.
3. when num is not 0 do
4. swap the no from right index to left index.
5. increment left counter
*/

//Invert tree

// https://pega.udemy.com/course/blind-75-leetcode-questions-ace-algorithms-coding-interview/learn/lecture/37109212#overview

class Solution{

public TreeNode invertTree(TreeNode root){
return dfs(root);
}

private TreeNode dfs(TreeNode root){
// base case
if(root == null)
{ return null;}
}

TreeNode left = dfs(root.left);
TreeNode right = dfs(root.right);

root.left = right;
root.right = left;
return root;
}
}


// Is identical tree

// https://pega.udemy.com/course/blind-75-leetcode-questions-ace-algorithms-coding-interview/learn/lecture/36922798#overview

// same tree - recursive

class Solution{

public boolean isSameTree(TreeNode p, TreeNode q){

return dfs(p, q);
}

public boolean dfs(TreeNode root1, TreeNode root2){
if(root1 == null && root2 == null) return true;
if( root1 == null || root2 == null) return false;
if( root1.val != root2.val) return false;
boolean left = dfs(root1.left, root2.left);
boolean right = dfs(root1.right, root2.right)

return left && right;

}
}


// In-Order tree traversal

// https://www.geeksforgeeks.org/inorder-traversal-of-binary-tree/

 // Function to print inorder traversal
    public static void printInorder(Node node)
    {
        if (node == null)
            return;
 
        // First recur on left subtree
        printInorder(node.left);
 
        // Now deal with the node
        System.out.print(node.data + " ");
 
        // Then recur on right subtree
        printInorder(node.right);
    }


//count no of 1s - bits


// https://leetcode.com/problems/number-of-1-bits/submissions/

  int count = 0;
        int mask = 1;
        for (int i=0; i< 32 ; i++){
           
            if( (n & mask) != 0){
                count ++;
            }
            mask = mask << 1;
        }
        return count;


// Leetcode - from where i picked most questions


// https://leetcode.com/problems/two-sum/


// Sum of 2 Nos without operands - use bits

// https://pega.udemy.com/course/blind-75-leetcode-questions-ace-algorithms-coding-interview/learn/lecture/36922770#overview

// given 2 nos a and b

while( b != 0){
        int carry = a & b;
        a = a ^ b;
        b = carry << 1;
        }

return a;

/*
Note:
carry - kind of carries the extra
so first find carry using & operator - AND
find A , where A = A XOR B
now b needs to absorb the value of carry,
b = carry << 1
if it completely absorbs it will become 0
till then repete.

*/

/*
-------------
XOR - like normal OR
AND - like normal AND
<< - shift left
1. when we have negative no - first find it;s 2 complement
2. Add the bits now.
*/

//Convert Infix expression to Postfix expression - GeeksforGeeks

// https://www.geeksforgeeks.org/convert-infix-expression-to-postfix-expression

// Use stack for operator and string for variables


// Minimum Number of Platforms Required for a Railway/Bus Station - GeeksforGeeks

// https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/

// Sorting method is better

/*
K'th Non-repeating Character - GeeksforGeeks

https://www.geeksforgeeks.org/kth-non-repeating-character/


Reverse Integer


long reverseNum = 0;
reverseNum = reverseNum * 10 + givenNum % 10;


Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

-----

it will form a Fibonacci series.

MEMOTIZATION:
  public int climbStairs(int n) {
   
    Map<Integer, Integer> memo = new HashMap<>();
    return climbStairs(n, memo);
   
    }

    private int climbStairs(int n, Map<Integer, Integer> memo){

        if(n ==0 || n==1){
            return 1;
        }

        if(!memo.containsKey(n)){
            memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
        }

        return memo.get(n);
    }   

_______________________
BRUTE FORCE:

        if(n==0 || n==1)
        {
            return 1;
        }

        return climbStairs(n-1) + climbStairs(n-2);


Longest Common Prefix

Sort all the string array Array.sort(String[] strs);
pick the first and the last element (n-1)

start comparing the alphabets now.
Use a stringBuilder to keep appending.
convert the prefix SB to String and return.

https://www.youtube.com/watch?v=wtOQaovlvhY


better approach i feel. It uses the word instead and from the back.

https://www.youtube.com/watch?v=5nug0L9y1h4


Anagram


it's s frequency problem.

int freq[] = new int[26];
        // we decrease and increase the frequency count in one loop itself.
        for(int i=0; i< size ; i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int i=0; i< freq.length ; i++){
            if(freq[i] != 0)
                return false;
        }


Remove Duplicates from Sorted Array

def removeDuplicates(self, nums):
        replace = 1
        for i in range(1, len(nums)):
            if nums[i-1] != nums[i]:
                nums[replace] = nums[i]
                replace += 1
        return replace

1) Start at 1, sometimes this is better option
2) till n-1,
3) if dupicate is found we anyways can't do anything, we want a unique one. so go ahead till you find a unique one.
4) If you find a unique one.
5) replace that with my element at replace index.
6) return the index of replace.


Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Note:
Don't think of preprocessing it. just skip the step when i encounter a non alphanumeric char.


Merge Sorted Array

Still not understood:

Merge and sort: simple O(m+n) log(m+n))
1) copy both the arrays in one - m+n size
2) sort them

2 pointer approach - from back
Since we know the size and in the problem we have to stop at m and n,
better to start from there.
1) initialize pointers at m-1, n-1 and m+n-1
2) iterate them and copy to num1.


Contains Duplicate

Brute force: 2 array n^2
Hash Map - O(n)
Hash Set - O(n)
Array of size of the min to max number - too large array
Sort the array and then it should not repete. - nLogn


Best Time to Buy and Sell Stock

It's a clear sliding window kind of problem.
The data in the series have a relationship with their neighbors.

the only thing if we need to leave left at the minimum and shift right till the difference keeps maximizing.


Valid Parentheses

We use a stack DS to solve this issue.
When we find the left one we push it, when we find it's right to check if it's left is on top and pop it. If we don't find it's error.


Longest Substring Without Repeating Characters

This is a medium complexity problem.
These problems i guess needs two tricks to solve the problem.

1) Sliding Window.
Have a left and a right pointer/index. This makes it a window.
Now I need to decide when do i move the pointers.

If I have seen the element earlier, them move the left pointer to the place where the right is. That is the window is 0. NO:
we loop and move the left counter till the time we keep finding the right pointer's value in the existing window.

If I have not seen earlier just move the right pointer.

Now to store the data that has already been seen. We can use.
a) Charcter Set
b) Unorders Map
c) Array - 128 size, since it will only have the alph numeric values.


Sum of 2 Nos

Brute Force: 2 loops i -> n-1 and j=i -> n-1 O(n^2);

2 Pass Hash Table:
Pass 1 - store element's value as key and their index as value.
Pass 2 - for each element find it's complement directly by lookup in hashtable.
The hastable decreased the loop. We sacrificed space for time.

One Pass Hashtable:

Loop and try to put values in HashTable, while setting this value, lookup the hashtable and find it's complement.


Seat change Bug

Brute Force:

Sort the passangers
Sort the empty seats.
find the difference

*/