class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                int sum = 0-A[i]-B[j];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                count+=map.getOrDefault(C[i]+D[j], 0);
            }
        }
        
        
        return count;
    }
}