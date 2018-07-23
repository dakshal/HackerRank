class HeapSort {
	
	public void sort(int[] arr, int n){
		createMaxHeap(arr, n);

		for(int i=n-1; i>=0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			heapify(arr, i-1);
		}
	}

	public void createMaxHeap(int[] arr, int n){
		int temp = 0, parent = 0;
		for(int i=n-1; i>0; i--){
			parent = Math.floor((i-1)/2);
			if(arr[i] > arr[parent]){
				temp = arr[i];
				arr[i] = arr[parent];
				arr[parent] = temp;
			}
		}
	}

	public void heapify(int[] arr, int n){
		int temp = 0, i=0;

		while(i<n){
			int left = arr[2*i+1];
			int right = arr[2*i+2];
			if(left>right && left>arr[i]){
				temp = left;
				left = arr[i];
				arr[i] = temp;
				i = 2*i+1;
			} else if(right>left && right>arr[i]){
				temp = arr[i];
				arr[i] = right;
				right = temp;
				i = 2*i+2;
			} else {
				break;
			}
		}
	}

	public static void main(String[] args){
		int arr[] = new int[]{3, 5, 2, 6, 4, 9, 1, 8, 7};
		sort(arr, arr.length);
	}

}