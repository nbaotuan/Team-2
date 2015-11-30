package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AutoElements extends commons.Initialize {
	public void click(WebDriver driver, String control){
		element  = findAnElement(driver, control);
		element.click();
	}
	
	public void enter(WebDriver driver, String control, String value){
		element  = findAnElement(driver, control);
		element.sendKeys(value);
	}
	
	public boolean doesControlExist(WebDriver driver, String control){
		element = findAnElement(driver, control);
		return element.isDisplayed();
	}
	public void selectitems(WebDriver driver, String xpath, String item) {
		 Select element= new Select (findAnElement (driver, xpath));
		 element.selectByVisibleText(item);
	}
	
	public void switchframe (WebDriver driver,String control, String framename){
		WebElement bodyIframe = findAnElement (driver, control);
		driver.switchTo().frame(bodyIframe);
		element.sendKeys(framename);
		driver.switchTo().defaultContent();		
	}
	
	/**
	 * @author: 
	 * @edit by: 
	 */
	public void navigatemenu(WebDriver driver, String menuitem1, String menuitem2, String menuitem3 ){
		String menuitem1_path = "//a[text()='" + menuitem1 + "']"; 
		String menuitem2_path = menuitem1_path + "/../ul/li/a[text()='" + menuitem2 + "']";
		String menuitem3_path = menuitem2_path + "/../ul/li/a[text()='" + menuitem3 + "']";
		String temp = "";
		Actions action = new Actions(driver);
		if (menuitem1 != "")
		{
			action.moveToElement(driver.findElement(By.xpath(menuitem1_path)));
			temp = menuitem1_path; 
		}
		if (menuitem2 != "")
		{
			action.moveToElement(driver.findElement(By.xpath(menuitem2_path)));
			temp = menuitem2_path; 
		}
		if (menuitem3 != "")
		{
			action.moveToElement(driver.findElement(By.xpath(menuitem3_path)));
			temp = menuitem3_path; 
		}
		action.build().perform();
		click(driver, temp);					
	}	
	
	protected boolean verifyTrue(boolean condition, boolean halt) {
		boolean pass = true;
		if (halt == false) {
			try {
				Assert.assertTrue(condition);
			} catch (Throwable e) {
				pass = false;
			}
		} else {
			Assert.assertTrue(condition);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return verifyTrue(condition, true);
	}

	protected boolean verifyFalse(boolean condition, boolean halt) {
		boolean pass = true;
		if (halt == false) {
			try {
				Assert.assertFalse(condition);
			} catch (Throwable e) {
				pass = false;
			}
		} else {
			Assert.assertFalse(condition);
		}
		return pass;

	}

	protected boolean verifyFalse(boolean condition) {
		return verifyFalse(condition, false);
	}
	
	protected WebElement element;
}
