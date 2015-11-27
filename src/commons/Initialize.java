package commons;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Initialize {
public WebDriver openAUT() {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.190.135:8888/Joomla_1.6.0/administrator");
        driver.manage().window().maximize();
        
        return driver;
	} 
	
	public WebDriver getDriver(WebDriver driver){
		//driver = this.driver;
		return driver;
	}

	public WebElement findAnElement (WebDriver driver, String control){
		if (control.contains("byID")) 
			element = driver.findElement(By.id(control));
		else 
			element = driver.findElement(By.xpath(control));
			
		return element;
	}

	WebDriver driver;
	protected WebElement element;

}