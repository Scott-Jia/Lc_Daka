import java.util.*;

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
class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        
        // convert the LinkedList to an ArrayList
        ListNode curr = head;
        while (curr != null){
            vals.add(curr.val);
            curr = curr.next;
        }
        
        // to check if it is palindrome
        int front = 0;
        int back = vals.size() - 1;
        
        while (front < back){
            if (! vals.get(front).equals(vals.get(back))){
                return false;
            }
            
            front ++;
            back --;
        }
        
        return true;
    }
}