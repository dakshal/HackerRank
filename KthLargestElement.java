class Solution {
    static class ListComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1 < o2)
				return 1;
			if (o1 > o2)
				return -1;
			return 0;
		}

	}
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(nums.length, new ListComparator());
        int count = 1;
        int last = -1;
        for(int i=0; i<nums.length; i++){
            queue.add(nums[i]);
        }
        last = queue.poll();
        // System.out.println(last);
        while(count<k) {
            last = queue.poll();
            count++;
            // System.out.println(last);
        }
        return last;
    }
}