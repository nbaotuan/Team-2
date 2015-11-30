package interfaces;

public class int_ContactsPage {
	//toolbar button
	public static final String new_button = "//li[@id='toolbar-new']";
	public static final String edit_button = "//li[@id='toolbar-edit']";
	public static final String publish_button = "//li[@id='toolbar-publish']";
	public static final String unpublish_button = "//li[@id='toolbar-unpublish']";
	public static final String archive_button = "//li[@id='toolbar-archive']";
	public static final String checkin_button = "//li[@id='toolbar-checkin']";
	public static final String trash_button = "//li[@id='toolbar-trash']";
	public static final String help_button = "//li[@id='toolbar-help']";
	
	//search option
	public static final String filter_textbox = "//input[@id='filter_search']";
	public static final String search_button ="//button[text()='Search']";
	public static final String clear_button ="//button[text()='Clear']";
	
	//filter dropdown
	public static final String state_dropdown = "//select[@name='filter_published']";
	public static final String category_dropdown = "//select[@name='filter_category_id']";
	public static final String access_dropdown = "//select[@name='filter_access']";
	public static final String language_dropdown = "//select[@name='filter_language']";
	
	//paging option
	public static final String paging_dropdown = "//select[@id='limit']";
	
	//table adminlist
	
}
