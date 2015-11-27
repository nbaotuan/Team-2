package actions;

import org.openqa.selenium.WebDriver;

public class LoginPage extends commons.AutoElements{
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		//driver = this.driver;
		this.driver = driver;
	}
	
	public LoginPage getLoginPage(WebDriver driver)
	{
		return new LoginPage(driver);
	}
	
	public void Login (String Username, String Password){
		enter(driver, interfaces.Gen_LoginPage.username_textbox, Username);
		enter(driver, interfaces.Gen_LoginPage.password_textbox, Password);
		click(driver,interfaces.Gen_LoginPage.login_button);
	}
	
	private WebDriver driver;
}
