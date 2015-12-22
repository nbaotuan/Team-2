package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.Config;
import interfaces.int_ArticlesPage;
import interfaces.int_NewArtPage;
import interfaces.int_WeblinksPage;

public class ac_WeblinksPage extends commons.AutoElements {
	
	public ac_WeblinksPage() {
		// TODO Auto-generated constructor stub
		
	}
	
	public ac_WeblinksPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public ac_WeblinksPage getWeblinksPage(WebDriver driver)
	{
		return new ac_WeblinksPage(driver);
	}
	/**
	 * @author: Hang Tran
	 * @edit by: 
	 */
	public void fillInfoWeblinks(String name, String url, String status, String saveoption){
		//click(driver, int_ArticlesPage.new_button);
		if (name != null)
			//driver.findElement(By.xpath(int_NewArtPage.title_texbox)).clear();
			clearText(driver, int_WeblinksPage.title_texbox);
			enter(driver, int_WeblinksPage.title_texbox, name);
		if (url != null)
				//driver.findElement(By.xpath(int_NewArtPage.title_texbox)).clear();
				clearText(driver, int_WeblinksPage.url_texbox);
				enter(driver, int_WeblinksPage.url_texbox, url);
		if (status != null){
			selectitems(driver, int_WeblinksPage.status_dropdown, status);
			//Select select_state = new Select (driver.findElement(By.xpath(int_NewArtPage.status_dropdown)));
		    //select_state.selectByVisibleText(state);
		}		
		
		if (saveoption == "save")
			click(driver, int_WeblinksPage.save_button);
		else if (saveoption == "save & close")
			click(driver, int_WeblinksPage.saveclose_button);
		else if (saveoption == "save & new")
			click(driver, int_WeblinksPage.savenew_button);
		else if (saveoption == "cancel")
			click(driver, int_WeblinksPage.cancel_button);
	}
	
	 public void checkWeblinksArchived(String message, String title)
	{
		verifyTrue(doesTextPresent(driver, message));
		selectitems(driver, int_WeblinksPage.status_filter_dropdown, "Archived");
		verifyTrue(doesitemExist(driver, title));
	}
	/**
	 * @author: Giang Nguyen
	 * @edit by: 
	 */
	public void checkWeblinksTrashed(String message, String title)
	{
		verifyTrue(doesTextPresent(driver, message));
		clearText(driver, int_WeblinksPage.filter_textbox);
		selectitems(driver, int_WeblinksPage.status_filter_dropdown, "Trashed");
		verifyTrue(doesitemExist(driver, title));
	}
	
	
	/**
	 * @author: Tuan Nguyen
	 * @edit by: 
	 */	
	public ac_WeblinksPage selectToolbarButtons(String itemName, String button){
		selectToobarButton(driver, itemName, button);
		if (button =="publish"||button =="unpublish"||button =="archive"||button =="checkin"||button =="trash"){
			waitForControl(driver, int_WeblinksPage.message_header, Config.short_wait_time*10);
		}
		return this;
	}
	
	private WebDriver driver;
}

