// https://www.geeksforgeeks.org/problems/reverse-a-stack/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-stack


package org.example.recursion;

public class ReverseStack {

  static void reverse(Stack<Integer> s)
  {
    // add your code here
    if(s.isEmpty()){
      return;
    }

    int element = s.pop();
    reverse(s);

    insertAtBottom(s, element);
  }

  static Stack<Integer> insertAtBottom(Stack<Integer> s, int element){

    if(s.isEmpty()){
      s.push(element);
      return s;
    }

    int temp = s.pop();
    insertAtBottom(s, element);
    s.push(temp);

    return s;
  }
}
