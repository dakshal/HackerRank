class Solution{
	public static int countTuples(int[] arr, int start, int sum, int k){
		if(sum > k){
			return 0;
		}
		if(sum == k){
		 	return 1;
		}
		if(start == arr.length){
			return 0;
		}

		return countTuples(arr, start+1, sum + arr[start], k) + countTuples(arr, start+1, sum, k);
	}
}