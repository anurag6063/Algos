/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/add-two-numbers/?envType=list&envId=ruypfpvi
[Pattern]: 2 pointers; dirrerent array
[Tips]: initiate ans, reset sum inside loop; don't reset carry,have 3 condition to sum, l1, l1 and carry
[Revision]: 1
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
		// this is initalized as 0 since when i start the sum it's 0; this is base case for sum
        int carry = 0;

		// these are 3 conditions in which i would have to sum somrthing to my sum variable.
        while(l1 != null || l2 != null || carry == 1){
			// sum needs to reser everytime, it's for a column only. ie parallel nodes
            int sum =0;
			
			// condition 1: for adding to SUM variable.
            if(l1 != null){
                sum = sum + l1.val;
                l1 = l1.next;
            }

			// condition 2:  for adding to SUM variable.
            if(l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
			
			// condition 3: for adding to SUM variable.
            sum = sum + carry;

			// Ans staring from here.
			// find carry and digit
            carry = sum/10; // we need the extra one here as carry forward
            System.out.println(sum + " "+ sum/10 + " "+ sum%10) ;
			
			// create node for answer
            ListNode node = new ListNode(sum%10); //the remainder gets written // 35+89 = 5+9 -> 4 14 so we will here write 1 and carry forward 4 so 14/10= 
			
			// move the current node.
            curr.next = node;
            curr = curr.next;
        }
    return ans.next;
	
    }




/*
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int carry = 0;
        while(l1 != null ||  l2 != null || carry ==1){
            int sum =0;
            // System.out.println(l1.val + " " + l2.val);

            if(l1 != null ){
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }

            sum = sum + carry;
            carry = sum/10;

            ListNode node = new ListNode(sum%10);
            curr.next = node;
            curr = curr.next;
        }


        return res.next;
    }
    */
}