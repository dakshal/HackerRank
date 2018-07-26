class Solution {
    public int minDistance(String word1, String word2) {
        char[] init = word1.toCharArray();
        char[] newWord = word2.toCharArray();
        int[][] dp = new int[init.length+1][newWord.length+1];
        
        for(int i=0; i<=init.length; i++){
            for(int j=0; j<=newWord.length; j++){
                if(i==0) {
                    dp[i][j] = j;
                } else if(j==0) {
                    dp[i][j] = i;
                } else{
                    if(init[i-1] == newWord[j-1]) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    }
                }
            }
        }
        return dp[init.length][newWord.length];
    }
}