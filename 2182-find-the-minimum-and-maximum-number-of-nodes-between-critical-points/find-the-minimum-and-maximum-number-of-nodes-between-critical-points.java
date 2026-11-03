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
        if(head==null){
            return new int[]{-1,-1};
        }
        ListNode prev=head;
        ListNode curr=head.next;
        int i=1;
        List<Integer> cp=new ArrayList<>();

        while(curr!=null && curr.next!=null){
            //compare for local maxima
            if(curr.val>prev.val && curr.val>curr.next.val){
                cp.add(i);

            }
            //compare for local minima
            if(curr.val<prev.val && curr.val<curr.next.val){
                cp.add(i);
            }
            curr=curr.next;
            prev=prev.next;
            i=i+1;
        }

        if(cp.size()<2){
            return new int[]{-1, -1};
        }
        int minD=Integer.MAX_VALUE;
        for(int j=1;j<cp.size();j++){
            minD=Math.min(minD, cp.get(j)-cp.get(j-1));
        }
        int maxD=cp.get(cp.size()-1)-cp.get(0);
        return new int[]{minD, maxD};
    }
}