class Solution {
    public boolean isNumber(String s) {
        char[] word = s.toCharArray();
        int j = 0, dot = 0, e=0, s1 = 0, s2 = 0, r = 0;
        for(int i=0; i<word.length; i++){
            if((word[i]>47 && word[i] < 58)){
                j++;
                if(s2>0){
                    return false;
                }
                r = 0;
            } else if(word[i] == 32 ){
                if(i==0 || s1 == i){
                    s1 = i+1;
                } else if(s2 == 0){
                    s2 = i+1;
                } else if(s2 == i){
                    s2 = i+1;
                } else {
                    return false;
                }
                r=0;
            } else if(word[i] == 46){
                if(s2>0){
                    return false;
                }
                if(dot>0){
                    return false;
                } else if(dot == 0 && e==0){
                    dot = j+1;
                }  else {
                    return false;
                }
                r=0;
            } else if((word[i] == 101 || word[i] == 69)){
                if(s2>0){
                    return false;
                } else if(e == 0 && j>0){
                    e = j;
                } else if(e==0 && (j==0)) {
                    return false;
                } else {
                    return false;
                }
                r = 1;
            } else if(word[i] == 45 || word[i] == 43){
                if((j==0 && e==0 && dot == 0) || r==1){
                    
                } else {
                    return false;
                }
                
            } else {
                return false;
            }
        }
        if(j>0 && j>e)
            return true;
        else 
            return false;
    }
}