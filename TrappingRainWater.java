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
        
        for(int i=0; i<height.length; i++){
            int closest = height.length+1;
            blocks = 0;
            for(int j=height.length-1; j>i; j--){
                blocks+= height[j];
                if((closest<height.length && height[j]>=height[closest] ) || height[j]>=height[i]){
                    closest = j;
                    blocks = 0;
                } else if(closest == height.length + 1 && height[j]>0){
                    closest = j;
                    blocks = 0;
                }                
            }
            if(closest < height.length + 1){
                int val = (Math.min(height[closest], height[i])*(closest-i-1)-blocks);
                water+=(val>0)?val:0;
                // System.out.println(i+"\t"+closest+"\t"+Math.min(height[closest], height[i])+"\t"+blocks+"\t"+water);
            }
            i = closest-1;
        }
        return water;
    }
}