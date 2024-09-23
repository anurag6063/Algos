

// https://leetcode.com/problems/generate-parentheses/solutions/2542620/python-java-w-explanation-faster-than-96-w-proof-easy-to-understand

// https://leetcode.com/problems/generate-parentheses/description/
 package org.example.recursion;

public class GenerateParantheses {

  public List<String> generateParenthesis(int n) {

    List<String> ans = new ArrayList<String>();
    generate(ans, 0, 0, "", n);
    return ans;

  }

  public void generate(List<String> ans, int left, int right, String data, int n){

    if(data.length() == n*2){
      ans.add(data);
      return;
    }

    if(left < n){
      generate(ans, left+1, right, data+"(", n);
    }

    if(right < left){
      generate(ans, left, right+1, data + ")", n);
    }


  }
}