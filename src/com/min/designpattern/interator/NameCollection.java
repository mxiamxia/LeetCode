package com.min.designpattern.interator;

public class NameCollection implements Container{

	public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};
	
	@Override
	public Interator interator() {
		// TODO Auto-generated method stub
		return new NameIterator();
	}
	
	private class NameIterator implements Interator {
		int index = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if (index < names.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if (this.hasNext()) {
				return names[index++];
			}
			return null;
		}
		
	}

}
