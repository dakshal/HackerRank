// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> iterator;
    Integer cur = null;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.	  
        this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(cur == null){
            cur = iterator.next();
        }
        return cur;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(cur==null){
            return iterator.next();
        }
        Integer ret = cur;
        cur = null;
        return ret;
	}

	@Override
	public boolean hasNext() {
	    if(cur==null){
            return iterator.hasNext();
        }
        return true;
	}
}