class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // System.out.println(nums.length);
        int count = 0, secCount = 0, max = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                count++;
                secCount++;
            } else if(nums[i] == 0) {
                // System.out.println(count+"\t"+secCount+"\t"+max);
                if(count != secCount) {
                    if(count>max){
                        max = count;
                    }
                    count = secCount+1;
                    secCount = 0;
                } else {
                    count++;
                    secCount = 0;
                }
            }
        }
        if(max<count) {
            max = count;
        }
        return max;
    }
}