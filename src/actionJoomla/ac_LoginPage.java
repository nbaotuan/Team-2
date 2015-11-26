package actionJoomla;

import org.openqa.selenium.WebDriver;
import actionJoomla.ac_LoginPage;

public class ac_LoginPage extends common.AutoElements{
	
	//khai bao
	private WebDriver driver;
	
	public ac_LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		//driver = this.driver;
		this.driver = driver;
	}
	
	public ac_LoginPage getLoginPage(WebDriver driver)
	{
		return new ac_LoginPage(driver);
	}
	
	public void Login (String Username, String Password){
		enter(driver, interfacesJoomla.interface_LoginPage.username_textbox, Username);
		enter(driver, interfacesJoomla.interface_LoginPage.password_textbox, Password);
		click(driver,interfacesJoomla.interface_LoginPage.login_button);
	}
}
