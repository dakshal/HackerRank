class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        HashSet<Integer> list1 = new HashSet<>();
        HashSet<Integer> list2 = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();
        int n = Math.max(nums1.length, nums2.length);
        for(int i=0; i<n; i++){
            if(i<nums1.length){
                list1.add(nums1[i]);
                if(list2.contains(nums1[i])){
                    intersection.add(nums1[i]);
                }
            }
            if(i<nums2.length) {
                list2.add(nums2[i]);
                if(list1.contains(nums2[i])){
                    intersection.add(nums2[i]);
                }
            }
        }
        int[] inter = new int[intersection.size()];
        int k=0;
        for(Integer val:intersection) {
            inter[k++] = val;
        }
        return inter;
    }
}