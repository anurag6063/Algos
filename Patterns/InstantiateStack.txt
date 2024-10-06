package patterns;

import java.util.Stack;

public class InstantiateStack {
    public static void main(String[] args) {
        // create a stack DS and push values in it.
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // create a static method and call it from here.
        System.out.println(functionCall(stack, stack.size()));
        // we can normally print the stack, since it's a collection.
        // only the primitive array needs Arrays.toString separate call.
        System.out.println(stack);

    }

    private static int functionCall(Stack stack, int size) {
        System.out.println("Calling function");
        return 78;
    }
}