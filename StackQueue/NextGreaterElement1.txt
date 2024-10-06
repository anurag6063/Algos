class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // initialize
        int[] ans = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        for(int i= nums2.length-1; i>=0; i--){
            if(stack.empty()){
                map.put(nums2[i], -1);
            }else 
            if(nums2[i] < stack.peek() ){
                map.put(nums2[i], stack.peek());
            } else 
            if(nums2[i] > stack.peek()){
                while( !stack.isEmpty() && nums2[i] > stack.peek()){
                    stack.pop();
                }

                if(stack.isEmpty()) {map.put(nums2[i], -1);}
                else{ map.put(nums2[i], stack.peek());}
            }

            stack.push(nums2[i]);
        }

        // map.forEach( (k,v) -> System.out.println(k + " : "+ v));

    for(int i=0; i<nums1.length; i++){
        ans[i]= map.get(nums1[i]);
    }
        return ans;
    }
}