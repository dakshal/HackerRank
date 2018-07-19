class Solution {
    public int[] plusOne(int[] digits) {
        boolean increment = true;
        for(int i=digits.length - 1; i>=0; i--){
            if(increment){
                digits[i] = digits[i]+1;
                if(digits[i]>=10){
                    increment = true;
                    digits[i] = 0;
                } else {
                    increment = false;
                    break;
                }
            }
        }
        
        if(increment){
            int[] incremented = new int[digits.length+1];
            incremented[0] = 1;
            return incremented;
        } else {
            return digits;
        }
        
    }
}