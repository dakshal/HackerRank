class Solution {
    public int numDecodings(String s) {        
        char[] ch = s.toCharArray();
        int dp[] = new int[s.length()+1];
        dp[ch.length] = 1;
        // dp[ch.length-1] = 1;
        for(int i=ch.length-1; i>=0; i--){
            if(ch[i]>48 && ch[i]<58) {
                if(i<ch.length -1){
                    int num = Integer.parseInt(ch[i]+""+ch[i+1]);
                    if(num>=27){
                        dp[i] = dp[i+1];
                    } else {
                        dp[i] = dp[i+1] +dp[i+2];
                    }
                } else {
                    dp[i] = dp[i+1];
                }
            } else {
                // dp[i] = dp[i+1];
            }
        }
        
        int count = dp[0];
        return count;
    }
    
}