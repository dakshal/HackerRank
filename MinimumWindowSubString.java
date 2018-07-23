class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> pos = new HashMap<>();
        char[] charSet = s.toCharArray();
        char[] val = t.toCharArray();
        int min = 0;
        int i, j;
        for(int k=0; k < t.length(); k++){
            pos.put( val[k], 0);
        }
        for(int k=0; k < charSet.length; k++){
            // if()
        }
    }
}