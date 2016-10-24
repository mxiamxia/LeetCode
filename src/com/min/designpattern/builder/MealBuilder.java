package com.min.designpattern.builder;

public class MealBuilder {
	
	public Meal buildMeatBurger() {
		Meal m = new Meal();
		m.addMeal(new MeatBurger());
		m.addMeal(new Coke());
		return m;
	}
	
	public Meal buildVegBurger() {
		Meal m = new Meal();
		m.addMeal(new VegBurger());
		m.addMeal(new Pepsi());
		return m;
	}

}
