package com.java.basic;

import java.util.Random;

import com.java.basic.Part_05_Static_Variable;

public class Part_07_Random_Data {

	
	public static void main(String[] args) {
	
	}
	
	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99);
	}

}
