class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if(len == 1) return nums[0];
        return Math.max(helper(nums, 0, len-2), helper(nums, 1, len-1));
    }
    
    private int helper(int[] nums, int start, int end){
        int curr = 0, prev = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            curr = Math.max(prev2 + nums[i], prev);
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }
}