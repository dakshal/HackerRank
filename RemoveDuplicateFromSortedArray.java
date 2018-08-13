class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null){
            return -1;
        }
        if(nums.length <= 1){
            return nums.length;
        }
        int j = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] != nums[i]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}