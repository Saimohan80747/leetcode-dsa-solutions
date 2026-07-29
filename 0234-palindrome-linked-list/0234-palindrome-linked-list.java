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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        boolean isOdd=false;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast.next==null) isOdd=true;
        ListNode p1=slow.next;
        ListNode tmp=head,pre=null,nxt;
        while(pre!=slow){
            nxt=tmp.next;
            tmp.next=pre;
            pre=tmp;    
            tmp=nxt;
        }
        ListNode p2=slow;
        if(isOdd) p2=p2.next;
        while(p1!=null){
            if(p1.val!=p2.val) return false;
            p1=p1.next;
            p2=p2.next;
        }
        return true;



    }
}