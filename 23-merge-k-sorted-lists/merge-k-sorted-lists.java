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
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Add first node of every list
        for(ListNode node : lists) {
            if(node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(!pq.isEmpty()) {

            ListNode smallest = pq.poll();

            temp.next = smallest;
            temp = temp.next;

            if(smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }
}