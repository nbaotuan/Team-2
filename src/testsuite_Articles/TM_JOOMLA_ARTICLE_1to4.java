package testsuite_Articles;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import actions.ac_AdministratorPage;
import actions.ac_ArticlePage;
import actions.ac_LoginPage;
import commons.Config;
import interfaces.int_ArticlesPage;

public class TM_JOOMLA_ARTICLE_1to4 extends ac_ArticlePage {
	
	private WebDriver driver;
	private ac_LoginPage LoginPage;	
	private ac_AdministratorPage AdminPage;
	private ac_ArticlePage ArticlePage;
	
	public String title = randUniqueString("Test Article ");
	public String title_modified = randUniqueString("Test Article modified ");
	public String message_create = "Article successfully saved";
	public String arttext = "this is article content";
	public String arttext_modified = "this is article content modified";
	public String category = "Sample Data-Articles";
	public String state = "Unpublished";
	public String message_publish = "1 article published";
	public String message_unpublish = "1 article unpublished";
	
	@BeforeClass
	public void Setup() {
		driver = openAUT();
		LoginPage = new ac_LoginPage(driver);
		LoginPage.Login(Config.default_username, Config.default_password);
	}
	
	@Test
	public void TC_JOOMLA_ARTICLE_001()
	{
		ArticlePage = new ac_ArticlePage(driver);
		ArticlePage.navigatemenu(driver, "Content", "Article Manager", null);
		ArticlePage.click(driver, int_ArticlesPage.new_button);
		ArticlePage.fillInfoArticle(title, category, state, null, arttext, "save & close");
		//VP
		ArticlePage.checkArticleExist(message_create, title);
	}
	
	@Test
	public void TC_JOOMLA_ARTICLE_002()
	{
		ArticlePage.selectCheckboxItem(driver, title);
		ArticlePage.click(driver, int_ArticlesPage.edit_button);
		ArticlePage.fillInfoArticle(title_modified, category, null, null, arttext_modified, "save & close");
		//VP
		ArticlePage.checkArticleExist(message_create, title_modified);
	}
	
	@Test
	public void TC_JOOMLA_ARTICLE_003()
	{
		ArticlePage.selectCheckboxItem(driver, title_modified);
		ArticlePage.click(driver, int_ArticlesPage.publish_button);
		//VP
		ArticlePage.checkArticlePublishStatus(message_publish, title_modified, "Published");
	}
	
	@Test
	public void TC_JOOMLA_ARTICLE_004()
	{
		ArticlePage.selectCheckboxItem(driver, title_modified);
		ArticlePage.click(driver, int_ArticlesPage.publish_button);
		//VP
		ArticlePage.checkArticlePublishStatus(message_unpublish, title_modified, "Unpublished");
	}
	
	@AfterClass
	public void teardown(){
		AdminPage = new ac_AdministratorPage(driver);
		AdminPage.Logout();		
		driver.quit();
	}
}
