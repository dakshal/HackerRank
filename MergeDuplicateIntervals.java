/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals== null || intervals.size()<=1){
            return intervals;
        }
        int start = -1, end;
        int max = 0, min = Integer.MAX_VALUE;
        int k = -1;
        PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if(i1.start>i2.start) {
                    return 1;
                } else if(i1.start<i2.start) {
                    return -1;
                } else {
                    if(i1.end>i2.end) {
                        return 1;
                    } else if(i1.end<i2.end) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        for(int i=0; i<intervals.size(); i++){
            queue.add(intervals.get(i));
        }
        
        List<Interval> list = new ArrayList<>();
        Interval interval = queue.poll();
        start = interval.start;
        end = interval.end;
        while(!queue.isEmpty()){
            interval = queue.poll();
            if(end>=interval.start){
                end = Math.max(end, interval.end);
            } else {
                list.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        
        list.add(new Interval(start, end));
        
        return list;
    }
}