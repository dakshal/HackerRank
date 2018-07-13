class Solution {
    public void gameOfLife(int[][] board) {
        int width = board.length, height = board[0].length;
        int [][] newBoard = new int[width][height];
        // System.out.println(width+"\t"+height);
        
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                int rule = 0, count = 0;
                for(int k = -1; k<=1; k++){
                    for(int l = -1; l<=1; l++){
                        if(k==0 && l==0)
                            continue;
                        // System.out.println(i+"\t"+j+"\t"+k+"\t"+l);
                        if(i+k>=0 && j+l>=0 && i+k<width && j+l<height){
                            count+=board[i+k][j+l];
                        }
                    }
                }
                newBoard[i][j] = count;
            }
        }
        
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                int rule = 0, count = newBoard[i][j];
                
                // System.out.println(i+"\t"+j+"\t"+count);

                if(board[i][j] == 0){
                    if(count == 3){
                        rule = 3;
                    } else {
                        rule = 4;
                    }
                } else {
                    if(count < 2){
                        rule = 0;
                    } else if(count <=3){
                        rule = 1;
                    } else {
                        rule = 2;
                    }
                }
                switch(rule){
                    case 0:
                        board[i][j] = 0;
                        break;
                    case 1:
                        board[i][j] = 1;
                        break;
                    case 2:
                        board[i][j] = 0;
                        break;
                    case 3:
                        board[i][j] = 1;
                        break;
                }
            }
        }
    }
}