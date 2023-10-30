/*
https://leetcode.com/problems/find-the-highest-altitude/?envType=list&envId=ph9f65i7

*/

// class Solution {
//     public int largestAltitude(int[] gain) {
        
        // convert the height into altitudes. 
        // put height[0]=0;
        // for i-> n
            // h_t[i] = gain[i-1] - h_t[i-1]

        // find max of H_t[];

        // gain = [-5,1,5,0,-7]
        /* H_t[] = [0]


        i = 1
        -5 - 0 = -5
        H_t[] = [0,-5]

        // i=2



// cumulative sum
// max cum sum = 0
// cum sum = 0
// i= 0->n
max cum sum 




        */

    class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;
        
        for (int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i];
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }
        
        return maxAltitude;
    }
}

