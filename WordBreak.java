class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] ch = s.toCharArray();
        HashSet<String> dict = new HashSet<>();
        int max = 0;
        for(String word:wordDict){
            dict.add(word);
            if(max<word.length()){
                max = word.length();
            }
        }
        
        
        int [] match = new int[ch.length+1];
        match[ch.length] = 1;
        splitString(dict, ch, match, 0, max);
        // for(int i=0; i<match.length; i++){
        //     System.out.println(match[i]);
        // }
        return (match[0]==1)?true:false;
    }
    public boolean splitString(HashSet<String> dict, char[] ch, int[] match, int pos, int max) {
        // System.out.println(ch.length+"\t\t"+pos);
        if(pos >= ch.length){
            return true;
        }

        if(match[pos] == 1) {
            return true;
        } else if(match[pos] == 2){
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            boolean status = false;
            for(int i=pos; i<pos+max && i<ch.length; i++) {
                sb.append(ch[i]);
                // System.out.println(sb.toString()+"\t"+i+"\t"+pos+"\t"+max);
                if(dict.contains(sb.toString())) {
                    // System.out.println("find match");
                    status = splitString(dict, ch, match, i+1, max);
                    // System.out.println(status);
                    if(match[i+1]==1 && status) {
                        match[pos] = 1;
                        if(pos == 0)
                            return true;
                    } else {
                        match[pos] = 2;
                    }
                }
            }

        }
        return (match[pos]==1)?true:false;
    }
}