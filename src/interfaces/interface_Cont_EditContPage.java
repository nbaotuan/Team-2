package interfaces;

public class interface_Cont_EditContPage {
	//toolbar button
	public static final String save_button = "//li[@id='toolbar-apply']";
	public static final String save_close_button = "//li[@id='toolbar-save']";
	public static final String save_new_button = "//li[@id='toolbar-save-new']";
	public static final String save_copy_button = "//li[@id='toolbar-save-copy']";
	public static final String cancel_button = "//li[@id='toolbar-cancel']";
		
	//Information option
	public static final String name_textbox = "//input[@id='jform_name']";
	public static final String alias_textbox = "//input[@id='jform_alias']";
	public static final String category_dropdown = "//select[@id='jform_catid']";
	public static final String state_dropdown = "//select[@id='jform_published']";
	public static final String access_dropdown = "//select[@id='jform_access']";
	public static final String language_dropdown = "//select[@id='jform_language']";
	public static final String featured_dropdown = "//select[@id='jform_featured']";
	public static final String image_button = "//div[@class='image']";	
}
