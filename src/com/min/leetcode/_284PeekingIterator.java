package com.min.leetcode;

import java.util.Iterator;

public class _284PeekingIterator implements Iterator<Integer> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Iterator<Integer> it;
    Integer next;

	public _284PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
	    if (it.hasNext()) {
	        next = it.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer ret = next;
	    next = it.hasNext() ? it.next() : null;
	    return ret;
	}

	@Override
	public boolean hasNext() {
	    if (next != null) {
	        return true;
	    }
	    return false;
	}

}
