package actions;

import org.openqa.selenium.WebDriver;

public class ac_ArticlePage extends commons.AutoElements {
	
	public ac_ArticlePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		//driver = this.driver;
		this.driver = driver;
	}
	
	public ac_ArticlePage getActiclePage(WebDriver driver)
	{
		return new ac_ArticlePage(driver);
	}
	/**
	 * @author: TuanNguyen
	 * @edit by:
	 */
	public void createNewArticle (String Titlename, String CategoryArt, String State, String Access, String Textbody, String Action ){
		//enter value
		enter(driver, interfaces.int_NewArtPage.title_texbox, Titlename);
		selectitems(driver, interfaces.int_NewArtPage.category_dropdown, CategoryArt);
		selectitems(driver, interfaces.int_NewArtPage.state_dropdown, State);
		selectitems(driver, interfaces.int_NewArtPage.access_dropdown, Access);
		switchframe(driver, interfaces.int_NewArtPage.body_frame_textbox, Textbody);
	}
	
	private WebDriver driver;
}
