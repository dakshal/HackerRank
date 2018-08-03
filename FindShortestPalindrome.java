class Solution {
    public String shortestPalindrome(String s) {
        if(s.length() <=1){
            return s;
        }
        char[] word = s.toCharArray();
        int n = word.length;
        int start = 0, end = n-1;
        StringBuilder sb = new StringBuilder();
        
        for(int i=n-1; i>=0; i--) {
            if(word[start] == word[i]) start++;
        }
        if(start == n) return s;
        for(int i=n-1; i>=start; i--) {
            sb.append(word[i]);
        }
        
        return sb.toString() + shortestPalindrome(s.substring(0, start)) + s.substring(start);
    }
}