package com.java.basic;

public class Part_12_Dynamic_Locator {

	static String DYNAMIC_MENU_PAGE_LINK = "//a[text()='%s']";

	// 1 tham so truyen vao
	public static void main(String[] args) {
		clickToMenu(DYNAMIC_MENU_PAGE_LINK, "Edit Customer");
		clickToMenu(DYNAMIC_MENU_PAGE_LINK, "Deposit");
		clickToMenu(DYNAMIC_MENU_PAGE_LINK, "Fund Transfer");
		clickToMenu(DYNAMIC_ROW_COUNTRY_TOTAL, "Afghanistan", "791312");
		clickToMenu(DYNAMIC_ROW_COUNTRY_TOTAL, "AFRICA", "24853148");
		clickToMenu(DYNAMIC_ROW_VALUES, "AFRICA", "24853148","1","2");
	}



	// 2 tham so truyen vao
	static String DYNAMIC_ROW_COUNTRY_TOTAL = "//td[@data-key='country' and text()='%s']/" + "following-sibling::td[@data-key='total' and text()='%s']";

	public static void clickToMenu(String locator, String... value) {
		locator = String.format(locator, (Object[]) value);
		System.out.println("Click to: " + locator);
	}
	
	//4 tham so truyen vao
	static String DYNAMIC_ROW_VALUES = "//td[text()='%s']//td[text()='%s']//td[text()='%s']//td[text()='%s']";

//	public static void clickToMenu(String locator, String value) {
//	locator = String.format(locator, value);
//	System.out.println("Click to: " + locator);
//}
}
