package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import interfaces.*;
import org.openqa.selenium.WebElement;

public class ac_ContactPage extends commons.AutoElements {
	private WebDriver driver;
	
	public ac_ContactPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public ac_ContactPage() {
		// TODO Auto-generated constructor stub
		//this.driver = driver;
	}
	
//	public ac_ContactPage getContactPage(WebDriver driver)
//	{
//		return new ac_ContactPage(driver);
//	}
	/**
	 * @author: GiangNguyen
	 * @edit by:
	 */
	public void fillinfo(String name, String category, String state, String access, String otherinfo){
		if (name != null)
			enter(driver, int_NewContPage.name_textbox, name);
		if (category != null)
			selectitems(driver, int_NewContPage.category_dropdown, category);
		if (state != null)
			selectitems(driver, int_NewContPage.state_dropdown, state);
		if (access != null)
			selectitems(driver, int_NewContPage.access_dropdown, access);
		if (otherinfo != null)
			switchframe(driver, int_NewContPage.otherinfo_iframe, otherinfo);
			
	}

}