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

    class ListNode {
        int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public void reorderList(ListNode head) {
        if (head == null) return;
        
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null, curr = slow, next_temp;
        
        while (curr != null){
            next_temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next_temp;
        }
        
        ListNode first = head, second = prev;
        
        while (second.next != null){
            next_temp = first.next;
            first.next = second;
            first = next_temp;
            
            next_temp = second.next;
            second.next = first;
            second = next_temp;
        }
        
    }
}