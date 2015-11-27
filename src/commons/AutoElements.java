package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public void navigatemenu(WebDriver driver, String menuitem1, String menuitem2, String menuitem3 ){
		element = findAnElement(driver, menuitem1);
		element.click();
		if (menuitem2 != null){			
			element = findAnElement(driver, menuitem2);
			element.click();
		}
		else if (menuitem3 != null) {
				element = findAnElement(driver, menuitem3);
				element.click();
		}
			
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
