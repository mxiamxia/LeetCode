package com.min.designpattern.builder;

public class BuilderPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Meal m1 = new Meal();
		m1.addMeal(new VegBurger());
		m1.addMeal(new Coke());
		System.out.println(m1.getCost());
	}

}
