package com.min.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	List<Observer> observers = new ArrayList<Observer>();
	private int state;
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}
	
	public void attach(Observer ob) {
		this.observers.add(ob);
	}
	
	private void notifyAllObservers() {
		// TODO Auto-generated method stub
		for (Observer ob : observers) {
			ob.update();
		}
	}
}
