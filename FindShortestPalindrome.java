class Solution {
    public String shortestPalindrome(String s) {
        if(s.length() <=1){
            return s;
        }
        char[] word = s.toCharArray();
        int n= word.length;
        int mid = (0+n)/2;
        int count=0, center=0, type = 2;
        while(mid-1>=0){
            int c1 = findPalindrome(word, mid, true, 1);
            int c2 = findPalindrome(word, mid, false, 1);
            if((mid-c2+1)<0){
                count = c2;
                center = mid;
                type = 1;
                break;
            } else if(mid-c1<0){
                count = c1;
                center = mid;
                type = 0;
                break;
            } 
            mid -= 1;
        }
        StringBuilder sb = new StringBuilder();
        if(count == 0 && center==0){
            for(int i=n-1; i>1; i--){
                sb.append(word[i]);
            }
            if(word[0]!=word[1]){
                sb.append(word[1]);
            } 
        } else {
            // System.out.println(center+"\t\t"+count+"\t\t"+type);
            for(int i=n-1; i>=(center+count); i--){
                sb.append(word[i]);
            }
        }
        for(int i=0; i<n; i++){
            sb.append(word[i]);
        }
        return sb.toString();
    }
    
    public int findPalindrome(char[] word, int start, boolean type, int count) {
        if(type){
            if(start-count<0 || start+count>=word.length) {
                return count;
            }
            if(word[start-count] == word[start+count]) {
                return findPalindrome(word, start, type, count+1);
            } else {
                return count;
            }
        } else {
            if(start-count+1<0 || start+count>=word.length) {
                return count;
            }
            if(word[start-count+1] == word[start+count]) {
                return findPalindrome(word, start, type, count+1);
            } else {
                return count;
            }
            
        }
    }
}