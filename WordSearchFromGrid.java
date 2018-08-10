class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        HashMap<Character, String> startChar = new HashMap<>();
        
        for(int i=0; i<words.length; i++){
            char ch = words[i].charAt(0);
            if(startChar.containsKey(ch)) {
                startChar.put(ch, startChar.get(ch)+":"+words[i]);
            } else {
                startChar.put(ch, words[i]);
            }
        }
        
        HashSet<String> list = new HashSet<>();
        int[][] usage = new int[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(startChar.containsKey(board[i][j])){
                    String temp[] = startChar.get(board[i][j]).split(":");
                    for(String st:temp){
                        boolean found = findMatch(board, st.toCharArray(), 0, i, j, usage);
                        if(found){
                            list.add(st);
                        }
                    }
                }
            }
        }
        
        return new ArrayList<String>(list);
        
    }
    
    public boolean findMatch(char[][] board, char[] word, int pos, int i, int j, int[][] usage){
        if(pos>=word.length){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return false;
        }
        if(usage[i][j] == 1) return false;
        if(board[i][j] != word[pos]){
            return false;
        }
        
        usage[i][j] = 1;
        boolean status = false;
        if(findMatch(board, word, pos+1, i-1, j, usage) || findMatch(board, word, pos+1, i+1, j, usage) || findMatch(board, word, pos+1, i, j-1, usage) || findMatch(board, word, pos+1, i, j+1, usage)) {
            status = true;
        }
        usage[i][j] = 0;
        return status;
        
    }
}