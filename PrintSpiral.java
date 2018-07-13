class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new ArrayList<>();
        }
        int matSize = matrix.length*matrix[0].length;
        List<Integer> spiral = new ArrayList<>();
        int count = 1;
        boolean increment = true, horizontal = true;
        int i=0, j=0;
        while(spiral.size()<matSize) {
            // System.out.println(i+"\t"+j+"\t"+matrix[i][j]+"\t"+matrix.length+"\t"+matrix[0].length+"\t"+increment+"\t"+horizontal+"\t"+count);
            spiral.add(matrix[i][j]);
            if(increment){
                if(horizontal){
                    j++;
                } else {
                    i++;
                }
            } else {
                if(horizontal){
                    j--;
                } else {
                    i--;
                }
            }
            switch(count%4){
                case 1:
                    if((matrix[0].length - j - 1) <= (count-1)/4){
                        horizontal = false;
                        increment = true;
                        count++;
                    }
                    break;
                case 2:
                    if((matrix.length - i - 1) <= (count-2)/4){
                        horizontal = true;
                        increment = false;
                        count++;
                    }
                    break;
                case 3:
                    if(j <= (count - 3)/4){
                        horizontal = false;
                        increment = false;
                        count++;
                    }
                    break;
                case 0:
                    if(i <= count/4){
                        horizontal = true;
                        increment = true;
                        count++;
                    }
                    break;
            }
            if(i<0){
                i=0;
                j--;
            }
            if(i>=matrix.length){
                i = matrix.length -1;
                j++;
            }
            if(j<0){
                j=0;
                i--;
            }
            if(j>=matrix[0].length){
                j = matrix[0].length -1;
                i++;
            }
        }
        return spiral;
    }
}