package actions;

import org.openqa.selenium.WebDriver;

public class ac_LoginPage extends commons.AutoElements{
	
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
		enter(driver, interfaces.interface_Gen_LoginPage.username_textbox, Username);
		enter(driver, interfaces.interface_Gen_LoginPage.password_textbox, Password);
		click(driver,interfaces.interface_Gen_LoginPage.login_button);
	}
}
