    /*
     * Complete the findNumber function below.
     */
    static String findNumber(int[] arr, int k) {
        boolean found = false;
        for(int i=0 ;i < arr.length; i++){
            if(arr[i] == k){
                found = true;
                break;
            }
        }
        
        if(found){
            return "YES";
        } else {
            return "NO";
        }
    }

