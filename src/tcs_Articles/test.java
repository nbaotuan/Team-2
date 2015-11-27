package tcs_Articles;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import actions.AdministratorPage;
import actions.LoginPage;


public class test extends commons.Initialize{

	@BeforeClass
	public void Setup() {
		driver = openAUT();
		LoginPage = new LoginPage(driver);
	}
	@Test
	public void TC01_Verify_Login(){
		LoginPage.Login(default_username, default_password);
		//LoginPage.CheckLoginSuccess();		
	}
	
	@AfterClass
	public void teardown(){
		AdminPage = new AdministratorPage(driver);
		AdminPage.Logout();		
		driver.quit();
	}
	
	private WebDriver driver;
	private LoginPage LoginPage;	
	private AdministratorPage AdminPage ;
}
