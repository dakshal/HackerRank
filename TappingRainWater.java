class Solution {
    public int trap(int[] height) {
        int switched = 0;
        int[] maxHeight = new int[3];
        int[] heightPos = new int[3];
        
        if(height.length<2){
            return 0;
        }
        if(height[0] > height[1]) switched = 2;
        else switched = 1;
        
        int water = 0;
        int blocks = 0;
        
        for(int i=1; i<height.length; i++){
            boolean trigger = false;
            if(height[i]<height[i-1] && switched!=2){
                switched = 2;
                trigger = true;
            } else if(height[i]>height[i-1] && switched != 1) {
                switched = 1;
                trigger = true;
            }
            if(switched == 1){
                if(maxHeight[1] < heigth[i]){
                    maxHeight[1] = height[i];
                    heightPos[1] = i;
                }
                if(maxHeight[0] < height[i]){
                    maxHeight[0] = height[i];
                    heightPos[0] = i;
                }
            } else {
                blocks += 
            }
            if(trigger && switched == 2){
                water += Math.min(height[2], height[1])*(heightPos[1] - heightPos[0]);
            }
        }
    }
}