class Solution {
    public int numDecodings(String s) {
        char[] ch = s.toCharArray();
        int dp[] = new int[s.length()+1];
        dp[ch.length] = 1;
        for(int i=ch.length; i>=0; i++){
            if(s[i]>48 && s[i]<58) {
                dp[pos]+=count;
            } else {
                dp[i] = dp[i+1]
            }
        }
        
        int count = decodeString(ch, 0, dp);
        return count;
    }
    
    public int decodeString(char[] s, int pos, int dp[]) {
        if(pos>=s.length){
            return 1;
        }
        
        if(s[pos]>48 && s[pos]<58) {
            int count = 0;
            if(pos < s.length -1) {
                int num = Integer.parseInt(s[pos]+""+s[pos+1]);
                if(num<27 && (num!=10 && num!=20)){
                    if(dp[pos+2]!=0){
                        count+=dp[pos+2];
                    } else {
                        count += decodeString(s, pos+2, dp);
                    }
                    if(dp[pos+1]!=0){
                        count+=dp[pos+1];
                    } else {
                        count += decodeString(s, pos+1, dp);
                    }
                } else if(num == 10 || num == 20){
                    if(dp[pos+2]!=0){
                        count+=dp[pos+2];
                    } else {
                        count += decodeString(s, pos+2, dp);
                    }
                } else {
                    if(dp[pos+1]!=0){
                        count+=dp[pos+1];
                    } else {
                        count += decodeString(s, pos+1, dp);
                    }
                }
            } else {
                if(dp[pos+1]!=0){
                    count+=dp[pos+1];
                } else {
                    count += decodeString(s, pos+1, dp);
                }
            }
            dp[pos]+=count;
            return count;
        } else {
            return 0;
        }
        
    }
}