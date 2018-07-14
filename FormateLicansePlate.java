class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        String reformatedPlate = "";
        int count = 0;
        for(int i = S.length() -1; i>=0; i--){
            if(count == K){
                reformatedPlate = "-" + reformatedPlate; 
                count = 0;
            }
            if(S.charAt(i)!='-'){
                reformatedPlate = S.charAt(i) + reformatedPlate;
                count++;
            }
        }
        
        return reformatedPlate;
    }
}