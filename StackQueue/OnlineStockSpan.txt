/*
https://leetcode.com/problems/online-stock-span/?envType=list&envId=pheho7s5
class StockSpanner {
    Stack<Integer> res = new Stack<Integer>();
    Stack<int[]> st ;
    public StockSpanner() {        
        st = new Stack<>();
    }
    
    public int next(int price) {     
/*
        add in array
        loop and check from back to first till it breaks
*/
 // in this with price we need to store how many pops did we do to get here.  

        int count = 1; // itself     
        while(!st.isEmpty() && price >= st.peek()[0]){
            System.out.println(st.peek()[0]);
            // System.out.println(Arrays.deepToString(st.asList()));
            count += st.peek()[1];
            st.pop();
            
        }

    st.push(new int[]{price, count});
    return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */