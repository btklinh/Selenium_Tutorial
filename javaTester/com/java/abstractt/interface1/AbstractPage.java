package com.java.abstractt.interface1;

public abstract class AbstractPage {

	public abstract boolean isPageLoaded();
	//public abstract

	abstract void clickToElement(String locator);
	//default abstract

	void sendKeyToElement(String locator, String value) {
		
	};
	//default method
}
