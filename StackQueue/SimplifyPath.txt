/*
https://leetcode.com/problems/simplify-path/?envType=list&envId=pheho7s5

1. split the path as per /
2. put each element in stack. - when it's not empty and is not a single dot.
2. while putting respect the .., when .. comes . pop the element.
4. form the path again, using a string builder. 
5. trim the last char if it's a / and length is larger than 1.
6. to trim use StrinBuilder.setLength(<LENGTH>)
*/

class Solution {
    public String simplifyPath(String path) {
        
// starts with /
// . current .. previous // - / ...- file name
// start with /
// dir seperator //
// no end /
// "/home//foo/"


    String[] parts = path.split("/");
    Stack<String> stack = new Stack<>();

    for(String part: parts){
        if(part.equals("..")){
            if(!stack.isEmpty()){
                stack.pop();
            }
        }else if(!part.isEmpty() && !part.equals(".")){ // push only if it's not empty and does not contains single dot. Else looks good push it. 
            stack.push(part);
        }
        System.out.println(part);
    }

    // now we have handled the dots and pushed the dir names. 
    // now recreate

    StringBuilder pathForm = new StringBuilder("/");

// #Note: When i simply loop the stack with a for loop without using peek it will read from bootm. Though better way is to use a ArrayDeque
    for(String dir: stack){
        pathForm.append(dir).append("/");
        System.out.println(pathForm.toString());
    }

    // remove trailing /
    if(pathForm.length() > 1){
        pathForm.setLength(pathForm.length()-1);
    }

    return pathForm.toString();


    }
}