import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	static class Node {
		HashMap<String, Node> childs = new HashMap<>();

		public HashMap<String, Node> getChilds() {
			return childs;
		}

		public void setChilds(HashMap<String, Node> childs) {
			this.childs = childs;
		}
	}
    
    public static void printTree(Node root, String str){
        if(root.getChilds().size() == 0){
            System.out.println(str);
            return;
        }
        for(String child: root.getChilds().keySet()){
            printTree(root.getChilds().get(child), str + child);
        }
    }

	public static void buildDictionary(Node root, String op, String contact) {
        // printTree(root, "");
		if (op.equals("add")) {
			for (int i = 0; i < contact.length(); i++) {
				if (!root.getChilds().containsKey("" + contact.charAt(i))) {
					root.getChilds().put("" + contact.charAt(i), new Node());
					root = root.getChilds().get("" + contact.charAt(i));
				} else {
					root = root.getChilds().get("" + contact.charAt(i));
				}
			}
			root.getChilds().put("\0", new Node());
		} else {
			int count = 0, i = 0;
			for (i = 0; i < contact.length(); i++) {
				// System.out.println(contact.charAt(i) + "\t" + root.getChilds().size());
				if (!root.getChilds().containsKey("" + contact.charAt(i))) {
					break;
				} else {
					root = root.getChilds().get("" + contact.charAt(i));
				}
			}
			if (i == contact.length()) {
				ArrayList<Node> stack = new ArrayList<>();
				stack.add(root);
				while (stack.size() != 0) {
					Node last = stack.get(stack.size() - 1);
					// System.out.println(last.getChilds().size());
					if (last.getChilds().size() != 0) {
						stack.addAll(last.getChilds().values());
					} else {
						count++;
					}
					stack.remove(last);
				}
				System.out.println(count);
			} else {
				System.out.println("0");
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		Node root = new Node();

		for (int nItr = 0; nItr < n; nItr++) {
			String[] opContact = scanner.nextLine().split(" ");

			String op = opContact[0];

			String contact = opContact[1];

			buildDictionary(root, op, contact);

		}

		scanner.close();
	}
}
