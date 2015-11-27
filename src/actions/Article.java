package actions;

import org.openqa.selenium.WebDriver;

public class Article extends commons.AutoElements {
	
	public Article(WebDriver driver) {
		// TODO Auto-generated constructor stub
		//driver = this.driver;
		this.driver = driver;
	}
	
	public Article getActiclePage(WebDriver driver)
	{
		return new Article(driver);
	}
	
	public void createNewArticle (String Titlename, String CategoryArt, String State, String Access, String Textbody, String Action ){
		enter(driver, interfaces.Art_NewArtPage.title_texbox, Titlename);
		selectitems(driver, interfaces.Art_NewArtPage.category_dropdown, CategoryArt);
		selectitems(driver, interfaces.Art_NewArtPage.state_dropdown, State);
		selectitems(driver, interfaces.Art_NewArtPage.access_dropdown, Access);
		switchframe(driver, interfaces.Art_NewArtPage.body_frame_textbox, Textbody);
	}
	
	private WebDriver driver;
}
