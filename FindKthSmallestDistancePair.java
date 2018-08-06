class Solution {
    class Point implements Comparable<Point>{
        int x;
        int y;
        int dist=0;
        int count = 0;
        Point(){}
        Point(int x, int y){
            this.x = x;
            this.y = y;
            this.dist = Math.abs(x-y);
        }
        @Override
        public int compareTo(Point a){
            if(a.dist<dist){
                return 1;
            } else if(a.dist>dist){
                return -1;
            } else {
                return 0;
            }
        }
        
    }
    public int smallestDistancePair(int[] nums, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        for(Integer i:map.keySet()){
            for(Integer j:map.keySet()){
                if(i==j && map.get(i)>1) {
                    Point point = new Point(i,j);
                    point.count = (map.get(i)*map.get(i)-1)/2;
                    queue.add(point);
                } else if(i!=j){
                    Point point = new Point(i,j);
                    point.count = (map.get(i)*map.get(j));
                    queue.add(point);
                }
            }
        }

        int count = 0, last=0;
        while(count<k){
            Point p = queue.poll();
            last = p.dist;
            count+=p.count;
        }
        return last;
    }
}


11111

1
3
6
10


13131

0-> 1, 2
2-> 1, 2, 3




