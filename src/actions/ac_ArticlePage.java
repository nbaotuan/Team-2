package actions;

import org.openqa.selenium.WebDriver;

import interfaces.int_ArticlesPage;
import interfaces.int_NewArtPage;

public class ac_ArticlePage extends commons.AutoElements {
	
	public ac_ArticlePage() {
		// TODO Auto-generated constructor stub
		
	}
	
	public ac_ArticlePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		//driver = this.driver;
		this.driver = driver;
	}
	
	public ac_ArticlePage getActiclePage(WebDriver driver)
	{
		return new ac_ArticlePage(driver);
	}
	/**
	 * @author: TuanNguyen
	 * @edit by: Giang Nguyen
	 */
	public void fillInfoArticle(String name, String category, String state, String access, String arttext, String saveoption){
		if (name != null)
			clearText(driver, int_NewArtPage.title_texbox);
			enter(driver, int_NewArtPage.title_texbox, name);
		if (category != null)
			selectitems(driver, int_NewArtPage.category_dropdown, category);
		if (state != null)
			selectitems(driver, int_NewArtPage.status_dropdown, state);
		if (access != null)
			selectitems(driver, int_NewArtPage.access_dropdown, access);
		if (arttext != null)
			switchframe(driver, int_NewArtPage.arttext_frame_textbox, int_NewArtPage.body_frame_textbox, arttext);
		if (saveoption == "save")
			click(driver, int_NewArtPage.save_button);
		else if (saveoption == "save & close")
			click(driver, int_NewArtPage.saveclose_button);
		else if (saveoption == "save & new")
			click(driver, int_NewArtPage.savenew_button);
		else if (saveoption == "cancel")
			click(driver, int_NewArtPage.cancel_button);
	}
	
	/**
	 * @author: Giang Nguyen
	 * @edit by: 
	 */
	public void checkArticleExist(String message, String title)
	{
		verifyTrue(doesTextPresent(driver, message));
		verifyTrue(doesitemExist(driver, title));
	}
	/**
	 * @author: Giang Nguyen
	 * @edit by: 
	 */
	public void checkArticlePublishStatus(String message, String title, String status)
	{
		verifyTrue(doesTextPresent(driver, message));
		verifyTrue(doesitemPublish(driver, title, status));
	}
	/**
	 * @author: Giang Nguyen
	 * @edit by: 
	 */
	public void checkArticleArchived(String message, String title)
	{
		verifyTrue(doesTextPresent(driver, message));
		selectitems(driver, int_ArticlesPage.state_filter_dropdown, "Archived");
		verifyTrue(doesitemExist(driver, title));
	}
	/**
	 * @author: Giang Nguyen
	 * @edit by: 
	 */
	public void checkArticleTrashed(String message, String title)
	{
		verifyTrue(doesTextPresent(driver, message));
		clearText(driver, int_ArticlesPage.filter_textbox);
		selectitems(driver, int_ArticlesPage.state_filter_dropdown, "Trash");
		verifyTrue(doesitemExist(driver, title));
	}
	
	private WebDriver driver;
}
