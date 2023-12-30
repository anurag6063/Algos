
/*
https://leetcode.com/problems/number-of-recent-calls/?envType=list&envId=pheho7s5*/
class RecentCounter {

    int counter = 1;
    Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> res = new Stack<Integer>();
    
    public RecentCounter() {

        st.push(0);
        res.push(null);
    }

     public int ping(int t) {
       st.add(t);
       System.out.println(st.toString());
       while(st.peek() < t-3000){
           st.pop();
       }
    return st.size();
    }
    
   /* public int ping(int t) {
        int a =  st.peek();
        System.out.println("got "+ t +" compare "+ a );
        if(st.peek() + 3000 > t || st.isEmpty() || t - st.peek() < 0  ){
            System.out.println("in");
            st.push(t);
            return counter++;
            // res.push(counter++);
        }
    st.push(t);
    return counter;
    }*/
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */