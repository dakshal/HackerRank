public class ZigzagIterator {
    
    List<Integer> v1, v2;
    int i=0, j=0;
    boolean status = true;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        int val = -1;
        if(status){
            if(i < v1.size()){
                val = v1.get(i++);
            } else if(j < v2.size()) {
                val = v2.get(j++);
            }
            status = !status;
        } else {
            if(j < v2.size()) {
                val = v2.get(j++);
            } else if(i < v1.size()){
                val = v1.get(i++);
            }
            status = !status;
        }
        return val;
    }

    public boolean hasNext() {
        if(i<v1.size()){
            return true;
        } else if(j<v2.size()) {
            return true;
        }
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */