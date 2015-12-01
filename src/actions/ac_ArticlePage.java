package actions;

import org.openqa.selenium.WebDriver;

import interfaces.int_NewArtPage;

public class ac_ArticlePage extends commons.AutoElements {
	
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
	public void createNewArticle(String option, String name, String category, String state, String access, String arttext, String saveoption){
		click(driver, option);
		if (name != null)
			enter(driver, int_NewArtPage.title_texbox, name);
		if (category != null)
			selectitems(driver, int_NewArtPage.category_dropdown, category);
		if (state != null)
			selectitems(driver, int_NewArtPage.status_dropdown, state);
		if (access != null)
			selectitems(driver, int_NewArtPage.access_dropdown, access);
		if (arttext != null)
			switchframe(driver, int_NewArtPage.arttext_frame_textbox, int_NewArtPage.body_frame_textbox, arttext);
		click(driver, saveoption);
	}
	
	/**
	 * @author: Giang Nguyen
	 * @edit by:
	 */
	public void checkArticleExist(String message, String title)
	{
		verifyTrue(doesTextPresent(message));
		verifyTrue(doesitemExist(title));
	} 
	
	private WebDriver driver;
}
