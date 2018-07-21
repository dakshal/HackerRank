import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSort {

	static class TreeNode implements Comparable<TreeNode> {

		int val, index, array;
//		TreeNode next;

		TreeNode() {
		}

		TreeNode(int val, int index, int array) {
			this.val = val;
			this.index = index;
			this.array = array;
		}

		TreeNode(int val) {
			this.val = val;
		}

		public int compareTo(TreeNode node) {
			if (val < node.val)
				return -1;
			if (val > node.val)
				return 1;
			return 0;
		}

	}

	public static int[] mergeSort(int[][] arr) {

		PriorityQueue<TreeNode> queue = new PriorityQueue<TreeNode>();
		int size = 0;

		for (int i = 0; i < arr.length; i++) {
			size+= arr[i].length;
			TreeNode node = new TreeNode(arr[i][0], 0, i);
			queue.add(node);
		}


		int sorted[] = new int[arr.length * arr[0].length];
		int count = 0;

		while (!queue.isEmpty()) {
			TreeNode root = queue.poll();
			sorted[count] = root.val;
			if (root.index+1<arr[root.array].length) {
				queue.add(new TreeNode(arr[root.array][root.index+1], root.index+1, root.array));
			}
			count++;
		}

		return sorted;

	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int arr[][] = new int[][] { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };

		printArray(mergeSort(arr));

	}

}
