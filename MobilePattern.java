class Solution {
    int count = 0;
    int directNeighbour[][] = new int[][]{{2, 4, 5, 6, 8}, {1, 3, 4, 5, 6, 7, 9}, {2, 4, 5, 6, 8}, {1, 2, 3, 5, 7, 8, 9}, {1, 2, 3, 4, 6, 7, 8, 9}, {1, 2, 3, 5, 7, 8, 9}, {2, 4, 5, 6, 8}, {1, 3, 4, 5, 6, 7, 9}, {2, 4, 5, 6, 8}};
    int indirectNeighbour[][] = new int[][]{{23, 47, 59}, {58}, {21, 57, 69}, {56}, {}, {54}, {41, 53, 89}, {52}, {51, 63, 87}};
    public int numberOfPatterns(int m, int n) {
        int sum = 0;
        for(int i=0; i<9; i++){
            sum+=findPairs(m, n, new StringBuilder().append(i+1).toString());
        }
        
        // System.out.println(sum+"\t"+count);
        
        return sum;
    }
    
    public int findPairs(int m, int n, String p) {
        int sum = 0;
        if(p.length()>=m && p.length()<=n){
            sum++;
        } else if(p.length()>n){
            return sum;
        }
        
        // System.out.println(p);
        
        int last = Integer.parseInt(p.charAt(p.length() -1)+"") - 1;
        
        for(int i=0; i<directNeighbour[last].length; i++){
            if(!p.contains(directNeighbour[last][i]+"")){
                sum += findPairs(m, n, new StringBuilder(p).append(directNeighbour[last][i]).toString());
            }
        }
        
        for(int i=0; i<indirectNeighbour[last].length; i++){
            int nbr = indirectNeighbour[last][i];
            if(p.contains(nbr/10+"") && !p.contains(nbr%10+"") ){
                sum += findPairs(m, n, new StringBuilder(p).append(nbr%10).toString());
            }
        }
        return sum;
    }
}