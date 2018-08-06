class Solution {
    class Node{
        int x,y;
        @Override
        public int hashCode(){
            return x+2000*y;
        }
        
        @Override
        public boolean equals(Object obj){
			Node n = (Node) obj; 
            int s1 = this.x + this.y;
            int s2 = n.x + n.y;
            return s1 > s2;
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        // int[] un1 = new int[nums1.length];
        // int[] un2 = new int[nums2.length];
        
        int a = 0, b = 0;
        int sum = 0, maxSum = nums1[0] + nums2[0], count = 0;
        int i=0, j=0;
        int l=0, m=0;
        List<int[]> list = new ArrayList<>();
        
        while(i+1<nums1.length && nums1[i] == nums1[i+1]) {
            l++;
            i++;
        }
        
        while(j+1<nums2.length && nums2[j] == nums2[j+1]) {
            m++;
            j++;
        }
        i=0; 
        j=0;
        boolean valid = true;
        while(count<k) {
            sum = nums1[i] + nums2[j];
            System.out.println("sum="+sum + "\tmax="+maxSum+"\tcount="+count+"\ti="+i+"\tj="+j+"\ta="+a+"\tb="+b+"\tl="+l+"\tm="+m);
            if(sum<=maxSum && valid) {
                list.add(new int[]{nums1[i], nums2[j]});
                count++;
                j++;
                if(j>m && i<nums1.length) {
                    i++;
                    if(i>(l+1)){
                        valid = false;
                        j--;
                        continue;
                    }
                    if(i<=a) {
                        j = b;
                    } else {
                        j = 0;
                    }
                } else if(j>=nums2.length) {
                    valid = false;
                    j--;
                }
                // System.out.println(j);

            } else {
                if((l+1<nums1.length && m+1>=nums2.length) || nums1[l+1]+nums2[m] < nums1[l] + nums2[m+1]) {
                    a = l+1;
                    b = m;
                    while(i+1<nums1.length && nums1[i] == nums1[i+1]) {
                        l++;
                        i++;
                    }
                    if(l+1 == a && l<nums1.length) {
                        l++;
                    } else {
                        l--;
                    }
                    i=a;
                    j=0;
                    maxSum = nums1[l] + nums2[m];
                    System.out.println("a="+a+"\tl="+l+"\tm="+m+"\tmax="+maxSum);
                } else if((l+1>=nums1.length && m+1<nums2.length) || nums1[l+1]+nums2[m] >= nums1[l] + nums2[m+1]) {
                    a = l;
                    b = m+1;
                    while(j+1<nums1.length && nums2[j] == nums2[j+1]) {
                        m++;
                        j++;
                    }
                    if(m+1 == b && m<nums2.length) {
                        m++;
                    } else {
                        m--;
                    }
                    i=0;
                    j=b;
                    maxSum = nums1[l] + nums2[m];
                    System.out.println("b="+b+"\tl="+l+"\tm="+m+"\tmax="+maxSum);
                } else {
                    return list;
                }
                valid = true;
            }
        }
        
        return list;
    }
}