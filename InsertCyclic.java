/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
   public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }
        Node p = head;
        Node maxNode = head;
        while (true) {
            if (p.val >= maxNode.val) {
                maxNode = p;
            }
            if (p.val <= insertVal && p.next.val >= insertVal) {
                Node next = p.next;
                p.next = new Node(insertVal, next);
                return head;
            } else {
                p = p.next;
            }
            if (p == head) {
                break;
            }
        }
        Node next = maxNode.next;
        maxNode.next = new Node(insertVal, next);
        return head;
    }
}