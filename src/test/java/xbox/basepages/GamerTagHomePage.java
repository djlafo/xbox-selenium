package xbox.basepages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Page;
import util.SystemUtil;
import util.TestCaseBase;
import util.Waiting;

public class GamerTagHomePage extends Page {
	
	@FindBy(xpath = "//a[text()='Leaderboards']")
	public WebElement leaderboards_link;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement search_input;
	
	@FindBy(xpath = "//button[text()='Search']")
	public WebElement search_button;
	
	public GamerTagHomePage open() throws Exception {
		//read the url from property file
		Properties PROPERTIES_RESOURCES = SystemUtil
				.loadPropertiesResources("/testdata_xbox.properties");
		String URL = PROPERTIES_RESOURCES.getProperty("xbox.url");
		TestCaseBase.threadDriver.get().navigate().to(URL);
		
		return this;
	}
	
	public LeaderboardPage openLeaderboardPage() throws Exception {
		Waiting.until(leaderboards_link);
		leaderboards_link.click();
		
		return new LeaderboardPage();
	}
	
	public GamerTagSearchPage search(String name) throws Exception {
		Waiting.until(search_input);
		search_input.sendKeys(name);
		Waiting.until(search_button);
		search_button.click();
		
		return new GamerTagSearchPage();
	}
}
