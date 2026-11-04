/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        // Step 1: Insert copied nodes between original nodes
        Node temp = head;

        while (temp != null) {
            Node nextElement = temp.next;

            Node copy = new Node(temp.val);
            temp.next = copy;
            copy.next = nextElement;

            temp = nextElement;
        }

        // Step 2: Connect random pointers of copied nodes
        temp = head;

        while (temp != null) {
            Node copyNode = temp.next;

            if (temp.random != null) {
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }

            temp = temp.next.next;
        }

        // Step 3: Separate original and copied linked lists
        temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        while (temp != null) {

            // Creating the new list
            res.next = temp.next;
            res = res.next;

            // Disconnecting and restoring original LL
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}