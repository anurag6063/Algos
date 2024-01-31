class StockSpanner {
    Stack<Integer> res = new Stack<Integer>();
    Stack<int[]> st ;
    public StockSpanner() {
        
        st = new Stack<>();
        
        // res.push(0);

    }
    
    public int next(int price) {
        // if price > st.peek then res.peek+1 
        // else res.put 1
        
        // if(price > st.peek()){
        //     int x = res.peek() + 1;
        //     res.push(x);
        // }else{
        //     res.push(1);
        // }
        // st.push(price);
        // return res.peek();

        // price
/*

        add in array
        loop and check from back to first till it breaks

*/

        int count = 1;
        
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

