class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k<=0){
            return 0;
        } 
        char[] ch = s.toCharArray();
        int max = 0;
        
        int[] map = new int[128];
        int i=0, j=0;
        int count = 0;
        int dist = 0;
        while(j<ch.length){
            // System.out.println(ch[j]+"\t"+j);
            map[ch[j]]+=1;
            count++;
            if(map[ch[j]] == 1)
                dist++;
            j++;
            
            while(dist>k && i<j){
                map[ch[i]]--;
                if(map[ch[i]] == 0){
                    dist--;
                }
                i++;
                count--;
            }
            if(count>max){
                max = count;
            }
        }
        


        return max;
    }
}