
// https://www.geeksforgeeks.org/problems/sort-a-stack/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=sort-a-stack



package org.example.recursion;

public class SortStackUsingRecursion {

  public Stack<Integer> sort(Stack<Integer> s) {
    // add code here.

    if(s.size()==1)return s;

    int temp=s.pop();

    return insert(sort(s),temp);

  }
  public Stack<Integer> insert(Stack<Integer> s,int element){
    if(s.size()==0){
      s.push(element);
      return s;
    }
    if(s.peek()>element){
      int temp=s.pop();
      insert(s,element);
      s.push(temp);
      return s;
    }
    s.push(element);
    return s;

  }
}
