package actions;

import org.openqa.selenium.WebDriver;

public class ac_LoginPage extends commons.AutoElements{
		
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
		enter(driver, interfaces.int_LoginPage.username_textbox, Username);
		enter(driver, interfaces.int_LoginPage.password_textbox, Password);
		click(driver,interfaces.int_LoginPage.login_button);
	}
	
	private WebDriver driver;
}
