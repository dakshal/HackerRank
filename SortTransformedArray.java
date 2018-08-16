class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int sorted[] = new int[n];
        int i, j;
            i=0;
            j=n-1;
        
        int k=0;
        if(a>0){
            k = n-1;
        } else {
            k = 0;
        }
        
        while(i<=j) {
            int val1 = calculate(a, b, c, nums[i]);
            int val2 = calculate(a, b, c, nums[j]);
            if(a>0) {
                if(val1>val2) {
                    sorted[k] = val1;
                    i++;
                } else {
                    sorted[k] = val2;
                    j--;
                }
                k--;
            } else {
                if(val1<val2) {
                    sorted[k] = val1;
                    i++;
                } else {
                    sorted[k] = val2;
                    j--;
                }
                k++;
            }
        }
        
        return sorted;
   }
    
    public int calculate(int a, int b, int c, int val){
        return a*(val*val) + b*(val) + c;
    }
}