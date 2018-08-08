import java.util.*;

/**
 * 
 */

/**
 * @author dakshal
 *
 */
public class BinarySearchTree {

	public static void add(int val, Node root) {
		Node temp = root;

		while (true) {
			if (temp.val > val) {
				if (temp.left == null) {
					temp.left = new Node(val);
					return;
				}
				temp = temp.left;
			} else {
				if (temp.right == null) {
					temp.right = new Node(val);
					return;
				}
				temp = temp.right;
			}
		}
	}

	public static Node build123(int[] arr) {
		Node root = new Node(arr[0]);
		int i = 1;
		while (i < arr.length) {
			add(arr[i], root);
			i++;
		}
		return root;
	}

	public static int size(Node root) {
		if (root == null) {
			return 0;
		}

		return size(root.left) + size(root.right) + 1;
	}

	public static int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}

		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	
	public static int minValue(Node root) {
		if(root == null) {
			return -1;
		}
		Node temp = root;
		while(temp.left!= null) {
			temp = temp.left;
		}
		return temp.val;
	}
	
	public static void printTree(Node root) {
		if(root == null) {
			return;
		}
		
		printTree(root.left);
		System.out.print(root.val+"\t");
		printTree(root.right);
	}
	
	public static void postOrder(Node root) {
		if(root == null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val+"\t");
	}
	
	public static boolean hasPathSum(Node root, int val, int start) {
		if(root == null) {
			if(val == start) {
				return true;
			}
			return false;
		}
		
		return hasPathSum(root.left, val, start+root.val) || hasPathSum(root.right, val, start+root.val);
	}
	
	public static void printPath(Node root, ArrayList<Node> list) {
		
		if(root==null) {
			printList(list);
			return;
		}
		list.add(root);
		printPath(root.left, list);
		printPath(root.right, list);
		list.remove(root);		
	}
	public static void printList(ArrayList<Node> list) {
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i).val+"\t");
		}
		System.out.println();
	}
	
	public static Node mirror(Node root) {
		if(root == null) {
			return null;
		}
		Node temp = mirror(root.left);
		root.left = mirror(root.right);
		root.right = temp;
		return root;
	}
	
	public static Node doubleTree(Node root) {
		if(root == null) {
			return null;
		}
		Node temp = new Node(root.val);
		temp.left = root.left;
		root.left = temp;
		doubleTree(root.left.left);
		doubleTree(root.right);
		return root;
	}
	
	public static boolean checkTree(Node root1, Node root2) {
		if((root1!= null  || root2!=null) && (root1==null  || root2==null)) {
			return false;
		} else if(root1==null && root2==null) {
			return true;
		}
		if(root1.val == root2.val) {
			return checkTree(root1.left, root2.left) && checkTree(root1.right, root2.right);
		} else {
			return false;
		}
	}
	

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 6, 1, 5, 2, 8, 9, 7, 4 };
		Node root = build123(arr);

		System.out.println(size(root));
		System.out.println(maxDepth(root));
		System.out.println(minValue(root));
		printTree(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		
		System.out.println("has sum of 7:- "+hasPathSum(root, 7, 0));
		System.out.println("has sum of 0:- "+hasPathSum(root, 6, 0));
		
		printPath(root, new ArrayList<Node>());
		
		Node mirror = mirror(root);
		printTree(mirror);
		System.out.println();
		
		Node dtree = doubleTree(mirror(root));
		printTree(root);
		System.out.println();
		
		Node root2 = build123(new int[] {3, 6, 1, 5, 2, 8, 9, 7, 4, 10});
		Node root3 = build123(new int[] {3, 6, 1, 5, 2, 8, 9, 7, 4});
		System.out.println("tree status:- "+checkTree(root, root));
		System.out.println("tree status:- "+checkTree(root, root2));
		System.out.println("tree status:- "+checkTree(root, root3));
	}

	static class Node {
		int val;
		Node left;
		Node right;

		Node() {

		}

		Node(int val) {
			this.val = val;
		}
	}
}
