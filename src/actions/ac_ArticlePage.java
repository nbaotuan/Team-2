package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.Config;
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
		//click(driver, int_ArticlesPage.new_button);
		if (name != null)
			//driver.findElement(By.xpath(int_NewArtPage.title_texbox)).clear();
			clearText(driver, int_NewArtPage.title_texbox);
			enter(driver, int_NewArtPage.title_texbox, name);
		if (category != null){
			selectitems(driver, int_NewArtPage.category_dropdown, category);
			//Select select_category = new Select (driver.findElement(By.xpath(int_NewArtPage.category_dropdown)));
			//select_category.selectByVisibleText(category);
		}
		if (state != null){
			selectitems(driver, int_NewArtPage.status_dropdown, state);
			//Select select_state = new Select (driver.findElement(By.xpath(int_NewArtPage.status_dropdown)));
		    //select_state.selectByVisibleText(state);
		}			
		if (access != null){
			selectitems(driver, int_NewArtPage.access_dropdown, access);
			//Select select_access = new Select (driver.findElement(By.xpath(int_NewArtPage.access_dropdown)));
			//select_access.selectByVisibleText(access);
		}
		if (arttext != null)
			switchToFrame(driver, int_NewArtPage.arttext_frame_textbox);
			driver.findElement(By.xpath(int_NewArtPage.body_frame_textbox)).clear();
			enter(driver, int_NewArtPage.body_frame_textbox, arttext);
			switchBackDefaultframe(driver);
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
		verifyTrue(getitemPublishStatus(driver, int_ArticlesPage.publish_status_icon, title).equals(status));
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
	public void checkArticleIsPublic(String title, String access)
	{
		verifyTrue(getitemAccessStatus(driver, int_ArticlesPage.access_status, title).contains(access));
	}
	
	/**
	 * @author: Tuan Nguyen
	 * @edit by: 
	 */	
	public ac_ArticlePage selectToolbarButtons(String itemName, String button){
		selectToobarButton(driver, itemName, button);
		if (button =="publish"||button =="unpublish"||button =="archive"||button =="checkin"||button =="trash"){
			waitForControl(driver, int_ArticlesPage.message_header, Config.short_wait_time*10);
		}
		return this;
	}
	
	private WebDriver driver;
}
