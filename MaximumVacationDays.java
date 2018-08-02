class Solution {
    public int findMax(int a, int b, int c){
        return Math.max(a, Math.max(b,c));
    }
    
    public int countDays(int[][] flights, int[][] days, int[][] dp, int k, int n){
        if(k == days[0].length){
            return 0;
        }
        if(dp[n][k]!= 0){
            return dp[n][k];
        }
        int max = 0, day=0;
        
        for(int i=0; i<flights.length; i++){
            if(i==n || flights[n][i] == 1){
                day = countDays(flights, days, dp, k+1, i) + days[i][k];
            }
            if(day > max){
                max = day;
            }
        }
        dp[n][k] = max;
        
        return max;
        
    }
    
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int t = days[0].length;
        
        int[][] dp = new int[n+1][t+1];
        return countDays(flights, days, dp, 0, 0);
    }
}