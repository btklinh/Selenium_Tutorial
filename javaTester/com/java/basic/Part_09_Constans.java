package com.java.basic;

public class Part_09_Constans {
	public static String browserName = "chrome";
	
	public enum Browser{
		CHROME, FIREFOX, IE;
	}
	
	public static void main (String[] args) {
		System.out.println(browserName);
		System.out.println(browserName.toUpperCase());
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		System.out.println(browser);
	}

}
