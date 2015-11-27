package actions;

import org.openqa.selenium.WebDriver;


public class AdministratorPage extends commons.AutoElements{
	
	private WebDriver driver;
	
	public AdministratorPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		//driver = this.driver;
		this.driver = driver;
	}
	public AdministratorPage getAdminPage(WebDriver driver)
	{
		return new AdministratorPage(driver);
	}
	
	public void Logout(){		
		click(driver, interfaces.Gen_AdminstratorPage.logout_icon);
	}
	
}
