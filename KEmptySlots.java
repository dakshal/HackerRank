class Solution {
    public int kEmptySlots(int[] flowers, int k) {
//         int[] growDay = new int[flowers.length];
//         for(int i=0; i<flowers.length; i++){
//             growDay[flowers[i]-1] = i+1;
            
//         }
//         for(int i: growDay){
//             System.out.print(i+"\t");
//         }
        // System.out.println();
        // System.out.println("d\tk\tgd\tstart\tend");

        return emptySlotFinder(flowers, 0, flowers.length+1, k, 0);
    }
    
    public int emptySlotFinder(int[] growDay, int start, int end, int k, int d){
        // System.out.println(d+"\t"+k+"\t"+"\t"+start+"\t"+end);
        if(end<=start){
            return -1;
        } else if((end-start-1) == k && start!= 0 && end != (growDay.length + 1)){
            return d;
        } else if((end-Math.max(start,0)-1)<=k){
            return -1;
        } else if(d>=growDay.length){
            return -1;
        }
        // System.out.println(d+"\t"+k+"\t"+growDay[d]+"\t"+start+"\t"+end);
        if(growDay[d]>end){
            return emptySlotFinder(growDay, start, end, k, d+1);
        } else if(growDay[d]<start){
            return emptySlotFinder(growDay, start, end, k, d+1);
        } else {
            int left = emptySlotFinder(growDay, start, growDay[d], k, d+1);
            int right = emptySlotFinder(growDay, growDay[d], end, k, d+1);
            if(left>0 && right>0){
                return Math.min(left, right);
            }
            return Math.max(left, right);
        }
    }
}