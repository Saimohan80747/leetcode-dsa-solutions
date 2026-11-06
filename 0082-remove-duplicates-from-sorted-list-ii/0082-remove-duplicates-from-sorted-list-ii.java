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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
       
        ListNode p1=head;
        ListNode p2=head.next;
        while(p2.next!=null){
            if(p1.val!=p2.val){
               if(p2.val!=p2.next.val){
                   if(p1.next==p2){
                    p1=p1.next;
                    p2=p2.next;
                   }
                   else{
                    p2=p2.next;
                    p1.next=p2;
                   }
               }
               else{
                 p2=p2.next;
               }
            }
            else{
               if(p2.next==null){
                  return null;
               }
               else if(p2.next.next==null){
                  if(p2.val==p2.next.val){
                      return null;
                  }
                  else{
                     return p2.next;
                  }
               }else{
                  if(p2.val==p2.next.val)  p2=p2.next;
                  else{
                    p1=p2.next;
                    p2=p1.next;
                    head=p1;
                  }
               }
            }
           
        }
        if(head.next.next==null){
            if(head.val==head.next.val) return null;
            return head;
        }
         if(p1.next!=p2){
                p1.next=p2.next;
            }
        return head;

    }
}