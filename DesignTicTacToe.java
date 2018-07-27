class TicTacToe {
    
    int rowCount[];
    int colCount[];
    int n;
    int dig[] = new int[2];

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rowCount = new int[n];
        colCount = new int[n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player==1){
            rowCount[row]+=1;
            colCount[col]+=1;
            if(rowCount[row] == n){
                return player;
            }
            if(colCount[col] == n){
                return player;
            }
            if(row == col) {
                dig[0]+=1;
                if(dig[0] == n){
                    return player;
                }
            }
            if(row+col == (n-1)) {
                dig[1]+=1;
                if(dig[1] == n){
                    return player;
                }
            }
            // System.out.println(row+"\t"+col+"\t"+rowCount[row] +"\t"+colCount[col]+"\t"+dig[0]+"\t"+dig[1]);
        } else {
            rowCount[row]-=1;
            colCount[col]-=1;
            if(rowCount[row] == (0-n)) {
                return player;
            }
            if(colCount[col] == (0-n)) {
                return player;
            }
            if(row == col) {
                dig[0]-=1;
                if(dig[0] == (0-n)) {
                    return player;
                }
            }
            if(row+col == (n-1)) {
                dig[1]--;
                if(dig[1] == (0-n)) {
                    return player;
                }
            }
            // System.out.println(row+"\t"+col+"\t"+rowCount[row] +"\t"+colCount[col]+"\t"+dig[0]+"\t"+dig[1]);
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */