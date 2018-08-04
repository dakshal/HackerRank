class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int [] arr = new int[length];
        for(int i=0; i<updates.length; i++){
            arr[updates[i][0]] += updates[i][2];
            if(updates[i][1]<length-1)
                arr[updates[i][1]+1] += 0-updates[i][2];
            // printArr(arr);
        }
        int current = arr[0];
        for(int i=1; i<length; i++){
            current = arr[i-1];
            arr[i] = current + arr[i];
        }
        return arr;
    }
    // public void printArr(int[] arr){
    //     for(int i=0; i<arr.length; i++){
    //         System.out.print(arr[i]+" ");
    //     }
    //     System.out.println();
    // }
}