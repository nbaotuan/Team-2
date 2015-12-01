package interfaces;

public class int_ArticlesPage {
	
	
	public static final String new_icon = "//li[@id='toolbar-new']/a/span";
	public static final String edit_icon= "//li[@id='toolbar-edit']/a/span";
	public static final String publish_icon= "//li[@id='toolbar-publish']/a/span";
	public static final String unpublish_icon= "//li[@id='toolbar-unpublish']/a/span";
	public static final String archive_icon= "//li[@id='toolbar-archive']/a/span";
	public static final String checkin_icon= "//li[@id='toolbar-checkin']/a/span";
	public static final String trash_icon= "//li[@id='toolbar-trash']/a/span";
	public static final String help_icon= "//li[@id='toolbar-help']/a/span";
	
	
	public static final String filter_textbox = "//input[@id='filter_search']";
	public static final String search_button = "//button[@type='submit']";
	public static final String state_filter_dropdown = "//select[@name='filter_published']";
	public static final String category_filter_dropdown = "//select[@name='filter_category_id']";
	public static final String access_filter_dropdown = "//select[@name='filter_access']";
	public static final String author_filter_dropdown = "//select[@name='filter_author_id']";
	
	public static final String row_checkbox = "//a[contains(text(),'%s')]/../preceding-sibling::td/input";
	public static final String article_link = "//a[contains(text(),'%s')]";
	
	
	
}
