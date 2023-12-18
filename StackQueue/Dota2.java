/*
https://leetcode.com/problems/dota2-senate/?envType=list&envId=pheho7s5


*/
class Solution {
    public String predictPartyVictory(String senate) {
        
        LinkedList<Integer> R = new LinkedList<>();
        LinkedList<Integer> D = new LinkedList<>();

        int n = senate.length();

        // put all the senates in respective queue.
        for(int i=0; i< n; i++){
            if(senate.charAt(i) == 'R'){
                R.add(i);
            }else{
                D.add(i);
            }
        }

        while(R.size()>0 && D.size() >0){
            if(R.peek() < D.peek()){
                R.add(n++);
            }else{
                D.add(n++);
            }
            R.removeFirst();
            D.removeFirst();
        } 

        return R.isEmpty()? "Dire": "Radiant";
    }
}