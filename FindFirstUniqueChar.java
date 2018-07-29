class Solution {
    public int firstUniqChar(String s) {
        char[] word = s.toCharArray();
        int[] count = new int[26];
        int n = word.length;
        
        for(int i=0; i<n; i++){
            count[word[i]-'a'] += (n+i);
        }
        
        int min = 2*n;
        for(int i=0; i<26; i++){
            if(min>count[i] && count[i]>0){
                min = count[i];
            }
        }
        if(min==2*n){
            return -1;
        } else {
            return min-n;
        }
    }
}