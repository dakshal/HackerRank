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
            // System.out.println("head is null:");
            return new Node(insertVal, null);
        }
        
        if(head.next == head){
            // System.out.println("head is same as next");
            head.next = new Node(insertVal, head);
            return head;
        }
        
        Node next = head.next;
        Node prev = head;
        Node least = head;
        Node highest = head;
        // System.out.println("Initial Params:- "+prev.val+"\t"+next.val+"\t"+insertVal);
        
        while((next != head) && ((prev.val < insertVal && next.val < insertVal) || (prev.val > insertVal && next.val > insertVal))){
        // System.out.println("Moving Next:- "+prev.val+"\t"+next.val+"\t"+insertVal);
            if(least.val > next.val) {
                least = next;
            }
            if(highest.val < next.val) {
                highest = next;
            }
            prev = next;
            next = next.next;
        }
        // System.out.println("Done with While:- "+prev.val+"\t"+next.val+"\t"+head.val+"\t"+insertVal);
        if(next == head) {
            Node nextNode = new Node(insertVal, highest.next);
            highest.next = nextNode;
            return head;
        } else {
            if(next.val < insertVal){
                Node nextNode = new Node(insertVal, next.next);
                next.next = nextNode;
                return head;
            } else {
                Node nextNode = new Node(insertVal, prev.next);
                prev.next = nextNode;
                return head;
            }
        }
    }
}