package testsuite_Articles;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import actions.ac_AdministratorPage;
import actions.ac_LoginPage;
import commons.Config;

public class TM_JOOMLA_ARTICLE_1to4 extends commons.AutoElements {
	@BeforeClass
	public void Setup() {
		driver = openAUT();
		LoginPage = new ac_LoginPage(driver);
		LoginPage.Login(Config.default_username, Config.default_password);
	}
	@Test
	public void TC_JOOMLA_ARTICLE_001(){
		//open new article
	}
	@AfterClass
	public void teardown(){
		AdminPage = new ac_AdministratorPage(driver);
		AdminPage.Logout();		
		driver.quit();
	}
	
	private WebDriver driver;
	private ac_LoginPage LoginPage;	
	private ac_AdministratorPage AdminPage;
}
