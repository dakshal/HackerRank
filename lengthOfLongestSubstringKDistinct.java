class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k<=0){
            return 0;
        } 
        char[] ch = s.toCharArray();
        int max = 0;
        
        for(int i=0; i<ch.length; i++){
            HashSet<Character> list = new HashSet<>();
            int j=i;
            for(; j<ch.length; j++){
                // System.out.println(j+"\t"+ch[j]+"\t"+k+"\t"+list.size());
                if(!list.contains(ch[j])){
                    list.add(ch[j]);
                    // System.out.println("found match:---> "+j+"\t"+ch[j]+"\t"+k+"\t"+list.size());
                    if(list.size()>k){
                        break;
                    }
                }
            }
            if((j-i)>max){
                max = j-i;
            }
        }

        return max;
    }
}