class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashSet<String> vars = new HashSet<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        HashMap<String, ArrayList<Double>> val = new HashMap<>();
        int n = equations.length;
        
        for(int i=0; i<n; i++){
            if(equations[i][0]!=equations[i][1]){
                if(!map.containsKey(equations[i][0])){
                    ArrayList<String> mapping = new ArrayList<>();
                    mapping.add(equations[i][1]);
                    map.put(equations[i][0], mapping);
                    ArrayList<Double> value = new ArrayList<>();
                    value.add(values[i]);
                    val.put(equations[i][0], value);
                } else {
                    ArrayList<String> mapping = map.get(equations[i][0]);
                    mapping.add(equations[i][1]);
                    map.put(equations[i][0], mapping);
                    ArrayList<Double> value = val.get(equations[i][0]);
                    value.add(values[i]);
                    val.put(equations[i][0], value);
                }
                if(!map.containsKey(equations[i][1])){
                    ArrayList<String> mapping = new ArrayList<>();
                    mapping.add(equations[i][0]);
                    map.put(equations[i][1], mapping);
                    ArrayList<Double> value = new ArrayList<>();
                    value.add(1/values[i]);
                    val.put(equations[i][1], value);
                } else {
                    ArrayList<String> mapping = map.get(equations[i][1]);
                    mapping.add(equations[i][0]);
                    map.put(equations[i][1], mapping);
                    ArrayList<Double> value = val.get(equations[i][1]);
                    value.add(1/values[i]);
                    val.put(equations[i][1], value);
                }
            }
        }
        
        double[] div = new double[queries.length];
        
        for(int i=0; i<queries.length; i++){
            if(!map.containsKey(queries[i][0]) || !map.containsKey(queries[i][1])){
                div[i] = -1d;
                continue;
            }
            // System.out.println("----------------------start----------------------");
            HashSet<String> processed = new HashSet<>();
            processed.add(queries[i][0]);
            div[i] = solveQuery(map, val, queries[i][0], queries[i][1], processed);
            // System.out.println("val = "+div[i]);
            // System.out.println("-----------------------end---------------------");
        }
        return div;
    }
    
    public double solveQuery(HashMap<String, ArrayList<String>> map, HashMap<String, ArrayList<Double>> val, String start, String end, HashSet<String> processed) {
        // System.out.println("start--> "+start+"\t\tend--> "+end);
        if(start.equals(end)) {
            return 1d;
        }

        ArrayList<String> list = map.get(start);
        ArrayList<Double> valPair = val.get(start);
        int i = 0;
        while(i<list.size()){
            String next = list.get(i);
            // System.out.println("next= "+next+"\t"+valPair.get(i)+"\t\ti= "+i);
            if(!processed.contains(next)){
                processed.add(next);
                double value = solveQuery(map, val, next, end, processed);
                // System.out.println("after calculation:---> "+value+"\t\ts= "+next);
                if(value > 0d){
                    return value*valPair.get(i);
                }
                processed.remove(next);
            }
            i++;
        }
        return -1;
    }
}