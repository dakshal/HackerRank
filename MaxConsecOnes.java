class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, secCount = 0, max = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
                secCount++;
            } else if(nums[i] == 0){
                if(count != secCount){
                    if(count>max){
                        max = count;
                    }
                    count = secCount;
                    secCount = 0;
                } else {
                    count++;
                }
            }
        }
        if(max<count){
            max = count;
        }
        return max;
    }
}