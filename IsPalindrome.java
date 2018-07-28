class Solution {
    public boolean isPalindrome(String s) {
        char[] word = s.toCharArray();
        int i=0, j = word.length -1;
        
        while(i<j){
            if(word[i]<48 || (word[i]>57 && word[i]<65) || (word[i]>90 && word[i]<97) || word[i]>122) {
                i++;
                continue;
            }
            if(word[j]<48 || (word[j]>57 && word[j]<65) || (word[j]>90 && word[j]<97) || word[j]>122){
                j--;
                continue;
            }
            // System.out.println(word[i]+"\t"+word[j]+"\t"+i+"\t"+j);
            if(word[i] == word[j] || (word[i] - 32 == word[j] && word[j]>64) || (word[j] - 32 == word[i] && word[i]>64)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}