package com.java.factory;

public class User {

	public static void main(String[] args) {
		// view and drive Honda car
		Honda honda = new Honda();
		honda.view();
		honda.run();

		// view and drive Hyundai car
		Hyundai hyundai = new Hyundai();
		hyundai.view();
		hyundai.run();

		// view and drive Hyundai car
		Toyota toyota = new Toyota();
		toyota.view();
		toyota.run();
	}

}
