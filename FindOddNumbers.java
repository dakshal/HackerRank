    /*
     * Complete the oddNumbers function below.
     */
    static int[] oddNumbers(int l, int r) {
                
        int[] oddNum = new int[((r-l)/2)+1];
        
        for(int i=l; i <=r; i++){
            if(i%2==1){
                oddNum[(i-l)/2] = i;
            }
        }
        
        return oddNum;
    }

