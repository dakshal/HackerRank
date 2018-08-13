import java.util.*;

public class RemoveDuplicate {
	
	public static void removeDuplicate(Node root) {
		HashSet<Integer> list = new HashSet<>();
		Node unique = root;
		list.add(root.val);
		Node temp = root.next;
		while(temp.next!=null) {
			if(!list.contains(temp.val)) {
				list.add(temp.val);
				unique.next = temp;
				unique = temp;
			}
			temp = temp.next;
		}
		unique.next = null;
	}
	
	public static void print(Node root) {
		Node temp = root;
		while(temp.next!= null) {
			System.out.print(temp.val+" --> ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1, 1, 4, 2, 6, 2, 7, 3, 5, 9, 7};
		
		final Node root = new Node(arr[0]);
		Node temp = root;
		
		for(int i=1; i<arr.length; i++) {
			Node n = new Node(arr[i]);
			temp.next = n;
			temp = n;
		}
		print(root);
		removeDuplicate(root);
		print(root);
	}

}

class Node{
	Node next;
	int val;
	
	public Node() {
		
	}
	
	public Node(int val) {
		this.val = val;
	}
	
}