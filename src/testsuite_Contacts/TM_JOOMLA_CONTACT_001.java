package testsuite_Contacts;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import actions.ac_ContactPage;
import actions.ac_LoginPage;
import commons.Config;


public class TM_JOOMLA_CONTACT_001 extends ac_ContactPage
{

	@BeforeClass
	public void Setup() {
		driver = openAUT();
		LoginPage = new ac_LoginPage(driver);
		LoginPage.Login(Config.default_username, Config.default_password);
	}
	@Test
	public void TC1()
	{
		//WebDriver driver = new FirefoxDriver();
		navigatemenu(driver,"Components","Banners","");
		//fillinfo("a",null,null,null,"bbbbb");
		
	}
	private WebDriver driver;
	private ac_LoginPage LoginPage;
}