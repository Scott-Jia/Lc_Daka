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

     
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if (head == null) return null;
        
        ListNode prev = null;
        ListNode curr = head;
        
        // before left = 1, move forward one by one
        while (left > 1){
            prev = curr;
            curr = curr.next;
            left --;
            right --;
        }
        
        // A---B(new)---C
        // before reverse, set the end node of A as connection, in order to connect NEW B
        // set the curr(the start of OLD B) as tail, in order to connect C later
        ListNode connection = prev;
        ListNode tail = curr;
        
        // reverse
        while (right > 0) {
            ListNode next_temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next_temp;
            right --;
        }
        
        // A---B(new)---C
        // prev is end of OLD B(the head of NEW B), curr is start of C
        // do connection depends on if connect node is null
        if (connection != null){
            connection.next = prev;
        } else {
            head = prev;
        }
        
        // connect the end of NEW B to start of C
        tail.next = curr;
        
        return head;
        
    }
}