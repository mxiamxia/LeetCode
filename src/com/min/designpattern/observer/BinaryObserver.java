package com.min.designpattern.observer;

public class BinaryObserver extends Observer {

	public BinaryObserver(Subject sub) {
		this.subject = sub;
		this.subject.attach(this);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Binary Observer=" + Integer.toBinaryString(this.subject.getState()));
	}

}
