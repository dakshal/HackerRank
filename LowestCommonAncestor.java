    /*
    class Node 
        int data;
        Node left;
        Node right;
    */
    public static Node lca(Node root, int v1, int v2) {        
        ArrayList<Node> parentV1 = new ArrayList<>();
        ArrayList<Node> parentV2 = new ArrayList<>();
        
        Node temp = root;
        parentV1 = findParents(root, v1, parentV1);
        parentV2 = findParents(root, v2, parentV2);
//         for(int i=0; i<parentV1.size(); i++){
//             System.out.print("-->"+parentV1.get(i).data);
//         }
//         System.out.println();
//         for(int i=0; i<parentV2.size(); i++){
//             System.out.print("-->"+parentV2.get(i).data);
//         }
//         System.out.println();
        
        int i=0;
        Node node = parentV1.get(0);
        while((i)<parentV1.size() && (i)<parentV2.size()){
            if(parentV1.get(i) != parentV2.get(i)){
                break;
            } else {
                node = parentV1.get(i);
            }
            i++;
        }
        
        return node;
    }

    public static ArrayList<Node> findParents(Node node, int v1, ArrayList<Node> parents) { 
        if(node.data == v1){
            parents.add(node);
            return parents;
        }
        if(node.left!=null){
            parents.add(node);
            if(findParents(node.left, v1, parents)==null){
                parents.remove(node);
            } else {
                return parents;
            }
        } 
        if(node.right != null){
            parents.add(node);
            if(findParents(node.right, v1, parents)== null){
                parents.remove(node);
            } else {
                return parents;
            }
        }
        return null;
    }


