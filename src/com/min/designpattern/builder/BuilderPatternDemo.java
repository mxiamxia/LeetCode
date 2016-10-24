package com.min.designpattern.builder;

public class BuilderPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MealBuilder builder = new MealBuilder();
		Meal m1 = builder.buildMeatBurger();
		Meal m2 = builder.buildVegBurger();
		System.out.println(m1.getCost());
		System.out.println(m2.getCost());
	}

}
