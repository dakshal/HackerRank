class PeekingIterator implements Iterator<Integer> {
		
		ArrayList<Integer> list = new ArrayList<>();
		int pos = 0;

		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
			while(iterator.hasNext()) {
				list.add(iterator.next());
			}
		}

	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
			return list.get(pos);	        
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
			return list.get(pos++);		    
		}

		@Override
		public boolean hasNext() {
			if(pos<list.size()) {
				return true;
			}
			return false;		    
		}
	}