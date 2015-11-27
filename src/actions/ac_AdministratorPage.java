package actions;

import org.openqa.selenium.WebDriver;


public class ac_AdministratorPage extends common.AutoElements{
	
	private WebDriver driver;
	
	public ac_AdministratorPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		//driver = this.driver;
		this.driver = driver;
	}
	public ac_AdministratorPage getAdminPage(WebDriver driver)
	{
		return new ac_AdministratorPage(driver);
	}
	
	public void Logout(){		
		click(driver, interfaces.interface_AdminstratorPage.logout_icon);
	}
	
}
