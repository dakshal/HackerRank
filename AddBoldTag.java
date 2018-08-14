class Solution {
    class Node{
        Node[] next;
        int size = 0;
        boolean done;
        
    }
    
    public String addBoldTag(String s, String[] dict) {
        if(dict.length == 0){
            return s;
        }
        Node root = new Node();
        root.next = new Node[128];
        for(int i=0; i<dict.length; i++) {
            char[] word = dict[i].toCharArray();
            Node node = root;
            for(int j=0; j<word.length; j++){
                if(node.next[word[j]]==null){
                    node.next[word[j]] = new Node();
                    node.next[word[j]].next = new Node[128];
                    node = node.next[word[j]];
                    // System.out.println(word[j]);
                } else {
                    node = node.next[word[j]];
                }
//                node.size = j+1;
//                System.out.print(word[j]+""+(j+1)+"\t");
            }
            node.done = true;
            node.size = word.length;
            // System.out.println();
            // System.out.println(node.done+"\t\t"+node.size);
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        char[] word = s.toCharArray();
        int j = 0, k=0, l=0;
        Node[] node = new Node[word.length];
        for(int i=0; i<word.length; i++) {
            node[l] = root;
            l++;
            for(j = l-1; j>=0; j--) {
                if(node[j].next[word[i]]!=null) {
                    node[j] = node[j].next[word[i]];
                    if(node[j].done) {
                        // System.out.println("find match \t"+(i-n.size)+"\t"+n.size);
                        map.put(i-node[j].size+1, node[j].size);
    //                    pos[k++] = i+1-n.size;
                    }
                } else {
                    if(l== j+1) {
                        node[j] = null;
                        l--;
                    } else {
                        node[j] = node[l-1];
                        node[l-1] = null;
                        l--;
                    }
                    continue;
                }
                // System.out.println("find match \t"+(i)+"\t"+n.size+"\t"+n.done);
            }
        }
        // System.out.println(map.size());
        if(map.size() == 0){
            return s;
        }
        int pos[] = new int[map.size()];
        j=0;
        for(int key:map.keySet()) {
        	pos[j] = key;
            // System.out.println(key+"\t"+map.get(key));
        	j++;
            
        }
        
        boolean start = false;
        Arrays.sort(pos);
        StringBuilder sb = new StringBuilder();
        j=0;
        int valid = 0;
        for(int i=0; i<word.length; i++) {
            if(j<pos.length && i == pos[j]){
                if(!start){
                    sb.append("<b>");
                    start = true;
                }
                valid = Math.max(i+map.get(i), valid);
                j++;
            }
            // System.out.println(i+"\t"+valid+"\t"+word[i]);
            if(valid == i && valid != 0) {
                sb.append("</b>");
                start = false;
            }
            sb.append(word[i]);
        }
        if(start){
            sb.append("</b>");
        }
        return sb.toString();
    }
}