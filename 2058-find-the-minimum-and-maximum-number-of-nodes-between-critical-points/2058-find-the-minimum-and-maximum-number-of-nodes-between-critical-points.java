/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int max=-1,min=Integer.MAX_VALUE;
        ListNode temp=head.next;
        ListNode prev=head;
        int idx=1,first=-1,last=-1;
        while(temp.next!=null){
            if((temp.val<prev.val && temp.val<temp.next.val) || (temp.val>prev.val && temp.val>temp.next.val)){
                if(first==-1){
                    first=idx;
                    
                    last=idx;
                }
                else{
                    min=Math.min(min,idx-last);
                    last=idx;
                }
            }
            idx++;
            prev=temp;
            temp=temp.next;
        }
        return (first==last)? new int[]{-1,-1}:new int[]{min,last-first};
    }
}