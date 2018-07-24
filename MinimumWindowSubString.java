class Solution {
    
    public String minWindow(String s, String t) {
        HashMap<Character, ArrayList<Integer>> pos = new HashMap<>();
        char[] charSet = s.toCharArray();
        char[] val = t.toCharArray();
        int min = -1, max = 100000, count = 0;
        int i=0, j=100000;
        for(int k=0; k < t.length(); k++){
            pos.put( val[k], new ArrayList<>());
        }

        boolean findMatch = false;
        for(int k=0; k < charSet.length; k++){
            findMatch =  pos.containsKey(charSet[k]);

            // System.out.println(findMatch+"\tch="+charSet[k]+"\tcount="+count+"\ti="+i+"\tj="+j+"\tk="+k+"\tmin="+min+"\tmax="+max);
            if (findMatch) {
                ArrayList<Integer> list = pos.get(charSet[k]);
                list.add(k);
                pos.put(charSet[k], list);
                if(list.size()==1) {
                    count++;
                }
                if(count>=val.length){
                    int range[] = findMax(pos);
                    // System.out.println("\tbefore\t"+"i="+i+"\tj="+j);
                    i = range[0];
                    j = range[1];
                    // System.out.println("\tafter\ti="+i+"\tj="+j);
                    if(Math.abs(j-i) < Math.abs(max - min) && (i!=-1)){
                        min = i;
                        max = j;
                    }
                }
            }
        }
        // System.out.println("before\t"+"i="+i+"\tj="+j);

        if(min == -1){
            int range[] = findMax(pos);
            min = range[0];
            max = range[1];
            if(min == -1) return "";
        }
        // System.out.println("before\t"+"i="+i+"\tj="+j);
        return s.substring(min, max+1);
    }
    public int[] findMax(HashMap<Character, ArrayList<Integer>> pos){
        int i = Integer.MAX_VALUE, j = -1;
        for(char c: pos.keySet()){
            ArrayList<Integer> list = pos.get(c);
            // System.out.println("\t\tsize="+list.size());
            if(list.size() <= 0){
                return new int[]{-1, -1};
            }
            int val = list.get(list.size()-1);
            if(i>val){
                i = val;
            }
            if(j<val){
                j = val;
            }
        }
        return new int[]{i, j};
    }
}