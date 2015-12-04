package testsuite_Articles;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import actions.ac_AdministratorPage;
import actions.ac_ArticlePage;
import actions.ac_LoginPage;
import commons.Config;
import interfaces.int_ArticlesPage;

public class TM_JOOMLA_ARTICLE_1to8 extends ac_ArticlePage {
	
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
	public String message_archive = "1 article archived.";
	public String message_trash = "1 article trashed.";
	public String state_unpublish = "Unpublished";
	public String state_publish = "Published";
	public String message_publish = "1 article published.";
	public String message_unpublish = "1 article unpublished.";
	
	@BeforeClass
	public void Setup() {
		driver = openAUT();
		LoginPage = new ac_LoginPage(driver);
		LoginPage.Login(Config.default_username, Config.default_password);
	}
	
	@Test
	//Verify user can create new article with valid information
	public void TC_JOOMLA_ARTICLE_001()
	{
		ArticlePage = new ac_ArticlePage(driver);
		ArticlePage.navigatemenu(driver, "Content", "Article Manager", null);
		ArticlePage.click(driver, int_ArticlesPage.new_button);
		ArticlePage.fillInfoArticle(title, category, null, null, arttext, "save & close");
		/*
		 * VP
		 * 1. "Article successfully saved" message is displayed
		 * 2. Created article is displayed on the articles table
		 */
		ArticlePage.checkArticleExist(message_create, title);
	}
	
	//@Test
	//Verify user can edit an article
	public void TC_JOOMLA_ARTICLE_002()
	{
		ArticlePage.selectCheckboxItem(driver, title);
		ArticlePage.click(driver, int_ArticlesPage.edit_button);
		ArticlePage.fillInfoArticle(title_modified, category, null, null, arttext_modified, "save & close");
		
		/*
		 * VP
		 * 1. "Article successfully saved" message is displayed
		 * 2. Edited article is displayed on the articles table
		 */
		ArticlePage.checkArticleExist(message_create, title_modified);
	}
	/*
	 *Tuan nguyen 12-03	 
	 *Verify user can publish an unpublished article				
	 */
	@Test
	public void TC_JOOMLA_ARTICLE_003()
	{
		ArticlePage.click(driver, int_ArticlesPage.new_button);
		ArticlePage.fillInfoArticle(title_modified, category, state_unpublish, null, arttext_modified, "save & close");
		ArticlePage.selectToolbarButtons(title_modified, interfaces.int_AdminstratorPage.toolbar_unpublish);
		/*
		 * VP
		 * 1. "Article successfully saved" message is displayed
		 * 2. Verify the article is published successfully
		 */		
		ArticlePage.checkArticleExist(message_publish, title_modified);
		
	}
	/*
	 *Tuan nguyen 12-03	 
	 *Verify user can publish an unpublished article				
	 */
	//@Test
	public void TC_JOOMLA_ARTICLE_004()
	{
		ArticlePage.selectToolbarButtons(title_modified, interfaces.int_AdminstratorPage.toolbar_publish);
		/*
		 * VP
		 * 1. "Article successfully saved" message is displayed
		 * 2. Verify the article is unpublished successfully
		 */
		ArticlePage.checkArticleExist(message_unpublish, title_modified);
	}
	
	//@Test
	//Verify user can move an article to the archive
	public void TC_JOOMLA_ARTICLE_005()
	{
		ArticlePage.selectCheckboxItem(driver, title_modified);
		ArticlePage.click(driver, int_ArticlesPage.archive_button);
		/*
		 * VP
		 * 1. The "1 article archived" message is displayed
		 * 2. The archived article is displayed on the table grid
		 */
		ArticlePage.checkArticleArchived(message_archive, title_modified);
	}
	
	//@Test
	//Verify user can move an article to trash section
	public void TC_JOOMLA_ARTICLE_007()
	{
		ArticlePage.selectCheckboxItem(driver, title_modified);
		ArticlePage.click(driver, int_ArticlesPage.trash_button);
		/*
		 * VP
		 * 1. The "1 article successfully trashed" message is displayed
		 * 2. The deleted article is displayed on the table grid
		 */
		ArticlePage.checkArticleTrashed(message_trash, title_modified);
	}
	
	@AfterClass
	public void teardown(){
		AdminPage = new ac_AdministratorPage(driver);
		AdminPage.Logout();		
		driver.close();
	}
}
