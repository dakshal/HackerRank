class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder reformatedPlate = new StringBuilder();
        int count = 0;
        for(int i = S.length()-1; i>=0; i--){
            char c = S.charAt(i);
            if(c!='-'){
                if(count == K){
                    reformatedPlate.append("-"); 
                    count = 0;
                }
                reformatedPlate.append(Character.toUpperCase(c));
                count++;
            }
        }
        
        
        return reformatedPlate.reverse().toString();
    }
}