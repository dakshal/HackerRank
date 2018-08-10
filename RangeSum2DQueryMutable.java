class NumMatrix {
    
    int[][] mat;
    int [][] matrix;
    int m=0,n=0;

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        mat = new int[m][n];
        
        for(int i=0; i<m; i++){
            mat[i][0] = matrix[i][0];
            for(int j=1; j<n; j++){
                // System.out.print(sum+" ");
                mat[i][j] += (mat[i][j-1] +matrix[i][j]);
            }
            // System.out.println();
        }        
    }
    
    public void update(int row, int col, int val) {
        if(matrix[row][col] == val){
            return;
        }
        int diff = matrix[row][col] - val;
        for(int i=col; i<n; i++){
            mat[row][i]-=diff;
        }
        matrix[row][col] = val;

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1; i<=row2; i++){
            sum+=(mat[i][col2]);
            if(col1-1>=0){
                sum-=mat[i][col1-1];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */