package com.java.basic;

public class Part_05_Static_Variable {
	
	public static String address = "Automation FC";

	public static void setAddress(String address) {
		Part_05_Static_Variable.address = address;
	}
	//neu ko phai bien static -> co the su dung this.address
	//neu la bien tinh -> [ten class].address

}
