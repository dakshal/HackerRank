class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0;
        int i=0;
        int remainingLength = cols, lastRem = -2;
        while(i<rows){
            int j=0;
            while(j<sentence.length && i<rows){
                if(remainingLength >= sentence[j].length()){
                    remainingLength -= sentence[j].length();
                    remainingLength --;
                    j++;
                } else {
                    remainingLength = cols;
                    i++;
                }
            }
            if(j == sentence.length)
                count++;
            
            if(remainingLength < sentence[0].length()){
                break;
            }
            
            if(lastRem == -2){
                lastRem = remainingLength;
            }
        }
        // System.out.println(count+"\t"+(i+1));
        if(i< rows)
            count = (count*rows)/(i+1);
        
        return count;
    }
}