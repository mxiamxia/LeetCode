package com.min.designpattern.observer;

public class OctalObserver extends Observer {

	public OctalObserver(Subject sub) {
		this.subject = sub;
		this.subject.attach(this);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("OctalObserver=" + Integer.toOctalString(this.subject.getState()));
	}
}
