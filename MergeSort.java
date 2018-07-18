
import java.util.Scanner;

class MergeSort {

	public static int[] mergeSort(int[] arr, int n) {

		int[] temp = new int[n];

		divide(arr, temp, 0, n-1);

		return temp;

	}

	public static void divide(int[] arr, int[] temp, int start, int end) {
		if (start > end) {
			return;
		} else if(start == end){
			temp[start] = arr[start];
			return;
		}

		int mid = (end + start) / 2;

		divide(arr, temp, start, mid);
		divide(arr, temp, mid + 1, end);

		int i = start, j = mid + 1, k = start;

		while (i <= mid && j <= end) {
			if(arr[i]<arr[j]) {
				temp[k] = arr[i];
				i++;
				k++;
			}
			else {
				temp[k] = arr[j];
				j++;
				k++;
			}
		}
		
		while(i<=mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		while(j<=end) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		i = start;
		while(i<=end) {
			arr[i] = temp[i];
			i++;
		}
		return;
	}

	public static void printArray(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		int[] arr = new int[] {2, 5, 4, 3, 7, 6, 9, 1, 8};
		int n = arr.length;

//		for (int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}

		int[] result = mergeSort(arr, n);

		printArray(result, n);
	}
}