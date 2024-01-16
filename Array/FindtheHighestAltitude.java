/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/find-the-highest-altitude/?envType=list&envId=ph9f65i7
[Pattern]: keep adding and always find the max
[Tips]: Find the next num and then find the max of the resulting till now. It's like find the max of all the all no till no will be stored in max, now when i see the new no, find the exact no and now compare if the newly formed no is the max or now. Very sismilar to what i would have done manually.
[Revision]: 1
[Confidence]: 50%
[Next]: Practice 
[Steps]: For loop, find the exact no, find the current max.
[Code]	
	
[/Code]
[/Note]

*/

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

