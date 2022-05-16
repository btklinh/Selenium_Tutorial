package com.java.abstractt.interface1;

public interface iPage {
	int NUMBER =100;
	//public static final (constants)
	
	public static final String ADDRESS = "";
	//public static final (constants)
	
	static final String NAME ="";
	//public static final (constants)
	
	final String Phone ="";
	//public static final (constants)
	
	public abstract boolean isPageLoaded();
	
	abstract void clickToElement(String locator);  
	
	void sendKeyToElement(String locator, String value); 

}
