package com.min.designpattern.factory;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeFactory factory = new ShapeFactory();
		Shape s1 = factory.getShape("circle");
		Shape s2 = factory.getShape("square");
		s1.draw();
		s2.draw();
	}

}
