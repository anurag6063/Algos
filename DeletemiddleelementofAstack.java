
/*
[Note]
[Reference]: https://www.youtube.com/watch?v=oCcUNRMl7dA&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=8
[Problem]: https://www.geeksforgeeks.org/delete-middle-element-stack/
[Pattern]: Resursion
[Tips]: It's like passing to myself to side, first remove all the elements, then add back except the middle one. 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

// Java code to delete middle of a stack
// without using additional data structure.
import java.io.*;
import java.util.*;

public class GFG {

	// Deletes middle of stack of size
	// n. Curr is current item number
	static void deleteMid(Stack<Character> st,
							int n, int curr)
	{
		
		// If stack is empty or all items
		// are traversed
		if (st.empty() || curr == n)
			return;
		
		// Remove current item
		char x = st.pop();
		
		// Remove other items
		deleteMid(st, n, curr+1);
		
		// Put all items back except middle
		if (curr != n/2)
			st.push(x);
	}
	
	// Driver function to test above functions
	public static void main(String args[]) 
	{
		Stack<Character> st =
				new Stack<Character>();
	
		// push elements into the stack
		st.push('1');
		st.push('2');
		st.push('3');
		st.push('4');
		st.push('5');
		st.push('6');
		st.push('7');
	
		deleteMid(st, st.size(), 0);
	
		// Printing stack after deletion
		// of middle.
		while (!st.empty())
		{
			char p=st.pop();
			System.out.print(p + " ");
		}
	}
}

// This code is contributed by 
// Manish Shaw (manishshaw1)
