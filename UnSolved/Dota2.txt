/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/dota2-senate/?envType=list&envId=pheho7s5
[Pattern]: 2 Stack
[Tips]: 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[Intution]: 
"""
action: cancel the next guy
action: check which remains at last
action: remove the one that has lower index
action: add the remaining one to last.

need two queues, here better to use LL queue so that i can insert at end and get element from front. 
"""
[/Intution]
[QuestionNote]: 
"""
- Cancel means remove.
- 
"""
[QuestionNote]
[/Note]
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