package com.min.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class _281ZigzagIterator {
	Iterator<Integer> it1;
	Iterator<Integer> it2;
	int turns = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public _281ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		it1 = v1.iterator();
		it2 = v2.iterator();
	}

	public int next() {
		if (!hasNext()) {
			return 0;
		}
		turns++;
		if ( (turns % 2 == 1 && it1.hasNext()) || !it2.hasNext()) {
			return it1.next();
		} 
		if ( (turns % 2 == 0 && it2.hasNext()) || !it1.hasNext() ) {
			return it2.next();
		}
		return 0;
	}
	
	public boolean hasNext() {
		if (it1.hasNext() || it2.hasNext()) {
			return true;
		}
		return false;
	}
	
	// K list zigzag
	public class ZigzagIterator implements Iterator<Integer> {
	    
	    List<Iterator<Integer>> itlist;
	    int turns;

	    public ZigzagIterator(List<Iterator<Integer>> list) {
	        this.itlist = new LinkedList<Iterator<Integer>>();
	        // 将非空迭代器加入列表
	        for(Iterator<Integer> it : list){
	            if(it.hasNext()){
	                itlist.add(it);
	            }
	        }
	        turns = 0;
	    }

	    public Integer next() {
	        if(!hasNext()){
	            return 0;
	        }
	        Integer res = 0;
	        // 算出本次使用的迭代器的下标
	        int pos = turns % itlist.size();
	        Iterator<Integer> curr = itlist.get(pos);
	        res = curr.next();
	        // 如果这个迭代器用完，就将其从列表中移出
	        if(!curr.hasNext()){
	            itlist.remove(turns % itlist.size());
	            // turns变量更新为上一个下标
	            turns = pos - 1;
	        }
	        turns++;
	        return res;
	    }

	    public boolean hasNext() {
	        return itlist.size() > 0;
	    }
	}
}
