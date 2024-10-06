
/*
[Note]
[Reference]: https://www.youtube.com/watch?v=onLoX6Nhvmg&list=PLgUwDviBIf0rBT8io74a95xT-hDFZonNs
[Problem]: https://leetcode.com/problems/3sum/?envType=list&envId=ecumdrrd
[Pattern]: 2 pointers, opp end
[Tips]: instead of 3, use 2 pointers to reduce one inside loop, sort the values. use while loop to skip same number since we don't want dupicate nums. Use a linkedList; keep sum = 0 - nums[i] i.e A, 
[Revision]: 1
[Confidence]: 30%
[Next]: Practice 
[Steps]: Use a linked lis
[Code]	
	ans.add(Arrays.asList(nums[i], nums[left], nums[right]))
[/Code]
[Tags]: 
[/Note]
*/


class Solution {

     public List<List<Integer>> threeSum(int[] nums) {

         // brute force use 3 loops
        // a+b+c = 0 or a = - (b+c)
       
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);

        for(int i=0; i< nums.length-2; i++){
        // 2 pointers here
        if( i == 0 || ( i > 0 && nums[i] != nums[i-1])){
            int left = i+1;
            int right = nums.length-1;
            int sum = 0 - nums[i]; // this is what i will want to achieve below. 
            
            while(left < right){
                
                if(nums[left] + nums[right] == sum){
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));   
                    while(left < right && nums[left] == nums[left+1]) left++ ;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if( nums[left] + nums[right] < sum) {left++; }
                else{ right--;
                }
            } 
        }
            

        }
        return ans;
     }

}
 /* 
 /*   public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();
        Arrays.sort(nums);
       
       // it's better to have left and right really as next to each other else it's hard to initialize something and maintainf in bewtween them

       for(int i=0; i< arr.length ; i++){
           left = i+1;
           right = n-1;
           while(l < r){
               int sum = arr[i] + 
               if()
           }
       }



        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;

        //======================================



        // List<List<Integer>> a = new ArrayList<>();
        // Arrays.sort(nums);
        

        // int l = 0;
        // int r = nums.length-1;
        // System.out.println(Arrays.toString(nums));

        // while(l<r){
        //     if(nums[l] + nums[r]+ nums[l+1] == 0 )
        //         a.add(Arrays.asList(nums[l], nums[r], nums[l+1]));
        //     if(nums[l] + nums[r]+ nums[r-1] == 0 )
        //         a.add(Arrays.asList(nums[l], nums[r], nums[r-1]));

        //     l = l+1;
        //     r = r-1;

            
        // }

        // return a;

  
  
  
  
  
  
    }
    
}

*/


  
  
//      /*   // List<Integer> a = new ArrayList<>();
//         List<List<Integer>> a = new ArrayList<>();
//         for(int i=0; i< nums.length;i++){
//             for(int j=i+1; j< nums.length ; j++){
//                 for(int k=j+1; k< nums.length; k++){
//                     if(nums[i]+ nums[j]+ nums[k] == 0){
//                         a.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                     }
//                 }
//             }
//         }

//         return a;/*
//     }
// }