package com.java.basic;

import com.java.accessModifier.Class_01;

//class test de thu cac ham
public class Part_01_SystemProperties {
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		Part_2_Car car = new Part_2_Car();
		car.getCar();

	}

}
