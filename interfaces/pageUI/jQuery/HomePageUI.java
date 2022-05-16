package pageUI.jQuery;

public class HomePageUI {
	
	public static final String DYNAMIC_TEXTBOX_BY_COLUMN_NAME = "//div[text()='%s']/parent::div/following-sibling::input";
	public static final String DYNAMIC_PAGING_BY_PAGE_NUMBER = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String DYNAMIC_PAGE_ACTIVED_BY_PAGE_NUMBER = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String DYNAMIC_DELETE_ICON_BY_COUNTRY_NAME = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-remove-row-btn']";
	public static final String DYNAMIC_EDIT_ICON_BY_COUNTRY_NAME = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-edit-row-btn']";
	public static final String DYNAMIC_ALL_INFO_AT_ROW = "//td[@data-key='females' and text()='%s']/"
			+ "following-sibling::td[@data-key='country' and text()='%s']/"
			+ "following-sibling::td[@data-key='males' and text()='%s']/"
			+ "following-sibling::td[@data-key='total' and text()='%s']";
	
	public static final String DYNAMIC_INDEX_BY_COLUMN_NAME="//td[text()='%s']/preceding-sibling::td";
	public static final String DYNAMIC_TEXTBOX_BY_COLUMN_AND_ROW_INDEX="//tr[%s]/td[%s]/input";
}
