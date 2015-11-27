package commons;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Initialize {

	public static final String default_username ="Test01";
	public static final String default_password ="12345678";
	public static final String default_site ="http://192.168.190.135:8888/Joomla_1.6.0/administrator";
	
	public WebDriver openAUT() {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(default_site);
        driver.manage().window().maximize();
        
        return driver;
	} 
	
	public WebDriver getDriver(WebDriver driver){
		//driver = this.driver;
		return driver;
	}

	public WebElement findAnElement (WebDriver driver, String control){
		if (control.contains("byID")) {
			element = driver.findElement(By.id(control));
		}
		else if (control.contains("byXPATH")){
			element = driver.findElement(By.xpath(control));
		}
		else {
		element = driver.findElement(By.tagName(control));
		}
		return element;
	}

	WebDriver driver;
	protected WebElement element;

}
