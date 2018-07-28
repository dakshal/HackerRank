class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j== 0) dp[i][j] = grid[i][j];
                else if(i==0) dp[i][j] = grid[i][j] + dp[i][j-1];
                else if(j==0) dp[i][j] = grid[i][j] + dp[i-1][j];
                else dp[i][j] = Math.min(grid[i][j] + dp[i-1][j], grid[i][j] + dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}