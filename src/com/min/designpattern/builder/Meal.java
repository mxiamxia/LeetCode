package com.min.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	private List<Item> meals = new ArrayList<Item>();
	
	public void addMeal(Item item) {
		meals.add(item);
	}
	
	public float getCost() {
		float cost = 0;
		for (Item it : meals) {
			cost += it.price();
		}
		return cost;
	}
	
	public void showItems() {
		if (meals.size() > 0) {
			for (Item it : meals) {
				System.out.println(it.name());
			}
		}
	}

	public List<Item> getMeals() {
		return meals;
	}

	public void setMeals(List<Item> meals) {
		this.meals = meals;
	}
}
