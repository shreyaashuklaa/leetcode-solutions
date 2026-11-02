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

    // Merge two sorted linked lists
    public ListNode merge(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(list1 != null && list2 != null) {

            if(list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            }
            else {
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }

        if(list1 != null) {
            temp.next = list1;
        }
        else {
            temp.next = list2;
        }

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {

        // Base case
        if(head == null || head.next == null) {
            return head;
        }

        // Find middle using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Break the linked list into two halves
        prev.next = null;

        // Recursive calls
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // Merge both sorted halves
        return merge(left, right);
    }
}