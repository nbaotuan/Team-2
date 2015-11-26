package actionJoomla;

import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonPage{

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	/**
	 * @author Tuan Nguyen
	 * @Login Login with Username and Password
	 */
	public void Login (String Username, String Password){
		Type(interfacesJoomla.LoginPage.username_textbox, Username);
		Type(interfacesJoomla.LoginPage.password_textbox, Password);
		Click(interfacesJoomla.LoginPage.login_button);
	}
	 
}

