class MovingAverage {
    int count = 0, pos = 0;
    int size;
    int sum = 0;
    int[] arr;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        arr = new int[size];
    }
    
    public double next(int val) {
        sum += (val-arr[pos]);
        arr[pos] = val;
        pos = (pos+1)%size;
        if(count<size)
            count++;
        
        // System.out.println(sum+"\t\t"+count);
        return (double) sum/count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */