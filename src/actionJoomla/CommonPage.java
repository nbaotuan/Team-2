package actionJoomla;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonPage {
	//Set variable
	public static final String default_username ="Test01";
	public static final String default_password ="12345678";
	public static final String default_site ="192.168.190.135:8888/Joomla_1.6.0/administrator/index.php";
	
	//Driver home page
	public WebDriver driver;
		
	public void open_joomla(){
		driver.get(default_site);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void Click(String xpath){
		findElement(xpath).click();
	}

	public void Type(String xpath, String keys){
		findElement(xpath).sendKeys(keys);
	}

	public WebElement findElement (String xpathControl){
		WebElement returnElement;
		try {
			returnElement = driver.findElement(By.xpath(xpathControl));	
			return returnElement;		
		} catch (Exception e) {
			System.out.println("Element does not exist!");
			returnElement = null;
			return returnElement;	
		}
	}
}