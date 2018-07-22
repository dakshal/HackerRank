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
        if(head == null){
            return new Node(insertVal, null);
        }
        
        if(head.next == head){
            head.next = new Node(insertVal, head);
            return head;
        }
        
        while(!(head.val <= insertVal && head.next.val >= insertVal)){
            head = head.next;
        }
        Node nextNode = new Node(insertVal, head.next);
        head.next = nextNode;
        return head;
    }
}