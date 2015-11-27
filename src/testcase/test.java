package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import actions.ac_AdministratorPage;
import actions.ac_LoginPage;


public class test extends common.Initialize{

	private WebDriver driver;
	private ac_LoginPage LoginPage;	
	private ac_AdministratorPage AdminPage ;
	
	@BeforeClass
	public void Setup() {
		driver = openAUT();
		LoginPage = new ac_LoginPage(driver);
	}
	@Test
	public void TC01_Verify_Login(){
		LoginPage.Login("admin", "admin");
		//LoginPage.CheckLoginSuccess();
	}
	@AfterClass
	public void teardown(){
		AdminPage = new ac_AdministratorPage(driver);
		AdminPage.Logout();		
		driver.quit();
	}
	
}
