class WiggleSort{

	public static int[] wiggleSort(int [] arr, int n){
		for(int i=1; i<n; i++){
			if(i%2 != 0){
				if(arr[i] < arr[i-1]){
					int temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
				}
			} else {
				if(arr[i] > arr[i-1]){
					int temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
				}
			}
		}
		return arr;
	}

	public static void printArr(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}

	public static void main(System[] args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		printArr(wiggleSort(arr, n));
	}
}