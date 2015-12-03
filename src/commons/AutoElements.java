package commons;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AutoElements extends commons.Initialize {
	public void click(WebDriver driver, String control)
	{
		element  = findAnElement(driver, control);
		element.click();
	}
	
	public void enter(WebDriver driver, String control, String value)
	{
		element  = findAnElement(driver, control);
		element.sendKeys(value);
	}
	public void clearText(WebDriver driver, String control)
	{
		driver.findElement(By.xpath(control)).clear();
	}
	public boolean doesControlExist(WebDriver driver, String control)
	{
		element = findAnElement(driver, control);
		return element.isDisplayed();
	}
	public void selectitems(WebDriver driver, String xpath, String item) 
	{
		 Select element= new Select (findAnElement (driver, xpath));
		 element.selectByVisibleText(item);
	}
	public void selectCheckboxItem(WebDriver driver, String item) 
	{
		searchItem(driver, item);
		driver.findElement(By.xpath("//td[a[contains(text(),'" + item+ "')]]/../td/input[@type='checkbox']")).click();
	}
	
	public static String randUniqueString(String basestring) 
	{

		int day, month, year;
		int second, minute, hour;
		Calendar date = Calendar.getInstance();

		day = date.get(Calendar.DAY_OF_MONTH);
		month = date.get(Calendar.MONTH);
		year = date.get(Calendar.YEAR);

		second = date.get(Calendar.SECOND);
		minute = date.get(Calendar.MINUTE);
		hour = date.get(Calendar.HOUR);

		return basestring + day + month + year + second + minute + hour;
	}
	/**
	 * @author: Tuan Nguyen
	 * @edit by: Giang Nguyen
	 */
	public void switchToFrame (WebDriver driver, String control){
		WebElement bodyIframe = findAnElement (driver, control);
		driver.switchTo().frame(bodyIframe);	
	}
	/**
	 * @author: Giang Nguyen
	 * @edit by: 
	 */
	public void switchBackDefaultframe (WebDriver driver){
		driver.switchTo().defaultContent();		
	}
	/**
	 * @author: Giang Nguyen
	 * @edit by: 
	 */
	public void navigatemenu(WebDriver driver, String menuitem1, String menuitem2, String menuitem3 )
	{
		String menuitem1_path = "//a[text()='" + menuitem1 + "']"; 
		String menuitem2_path = menuitem1_path + "/../ul/li/a[text()='" + menuitem2 + "']";
		String menuitem3_path = menuitem2_path + "/../ul/li/a[text()='" + menuitem3 + "']";
		String temp = null;
		Actions action = new Actions(driver);
		if (menuitem1 != null)
		{
			action.moveToElement(driver.findElement(By.xpath(menuitem1_path)));
			temp = menuitem1_path; 
		}
		if (menuitem2 != null)
		{
			action.moveToElement(driver.findElement(By.xpath(menuitem2_path)));
			temp = menuitem2_path; 
		}
		if (menuitem3 != null)
		{
			action.moveToElement(driver.findElement(By.xpath(menuitem3_path)));
			temp = menuitem3_path; 
		}
		action.build().perform();
		click(driver, temp);					
	}	
	/**
	  * Verify condition is true
	  * @param condition
	  */
	 protected void verifyTrue(boolean condition) 
	 {
		 Assert.assertTrue(condition);
	 }

	 /**
	  * Verify condition is false
	  * @param condition
	  */
	 protected void verifyFalse(boolean condition) 
	 {
		 Assert.assertFalse(condition);
	 }

	 /**
	  * Verify whether actual result meets expectation
	  * @param actual
	  * @param expected
	  */
	 protected void verifyEquals(String actual, String expected) 
	 {
		 Assert.assertEquals(actual, expected);
	 }
	 
	 /**
	  * Verify True with parameter specific the test will be ended or continued
	  * @param condition
	  * @param iscontinue continue when test fail true/false
	  */
	 protected void verifyTrue(boolean condition, boolean iscontinue)
	 {
		 if ( iscontinue == true ) {
			 try {
	                Assert.assertTrue(condition);
	            } catch (Throwable e) {
	             Assert.fail("Condition is not matched");
	            }
	        } else {
	            Assert.assertTrue(condition);
	        }
	    }
	    
	 public boolean doesTextDisplay(WebDriver driver, String text)
	 {
		 String result = driver.findElement(By.tagName("body")).getText();
		 Boolean check = result.contains(text);
		 return check;
	 }
	 
	 public boolean doesElementExistByType(WebDriver driver, String type, String item) 
	 {
		 Boolean check = null;
		 if (type == "link") {
			 check = driver.findElement(By.linkText(item)).isDisplayed();
	  }
	  return check;
	 }
	 
	 public void searchItem(WebDriver driver, String searchtext) 
	 {
	  WebElement txtbox = driver.findElement(By.xpath(interfaces.int_ArticlesPage.filter_textbox));
	  String a = txtbox.getAttribute("value").toString(); 
	  if ( !a.equals(searchtext)) {
	   txtbox.clear();
	   waitForPageLoad(Config.short_wait_time);
	   txtbox.sendKeys(searchtext);
	   driver.findElement(By.xpath(interfaces.int_ArticlesPage.search_button)).click();
	  }
	 }
	 public void waitForPageLoad(long waittime){
	  try {
	   Thread.sleep(waittime*1000);
	  } catch (InterruptedException e) {
	   e.printStackTrace();
	  }
	 }
	 /**
	  * @author: TuanNguyen
	  * @edit by: Giang Nguyen, Hang Tran
	  */
	 public boolean doesTextPresent(WebDriver driver, String message)
	 {
		 return doesTextDisplay(driver, message);
	 }
	 
	 public boolean doesitemExist(WebDriver driver, String item)
	 {
		 searchItem(driver, item);
		 return doesElementExistByType(driver, "link", item);
	 }
	 /**
	  * @author: Giang Nguyen
	  * @edit by: 
	  */
	 public boolean doesitemPublish(WebDriver driver, String item, String status)
	 {
		 String xpath =  "//td[a[contains(text(),'" + item + "')]]/../td/a/span/span[contains(text(),'"+ status +"')]";
		 //String.format("//li[contains(text(),'%s')]", text);
		 //WebElement result = driver.findElement(By.xpath(xtext));
		 WebElement temp = driver.findElement(By.xpath(xpath));
		 String result = temp.getText();
		 Boolean check = result.contains(status);
		 return check;
	 }
	protected WebElement element;
}
