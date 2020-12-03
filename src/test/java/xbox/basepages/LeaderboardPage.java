package xbox.basepages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;

import util.Page;
import util.Waiting;

public class LeaderboardPage extends Page {
	
	final static String gamertagLinksXPath = "(//div[contains(@class, 'col-lg')]//a[contains(@class, 'display-4')])";
	
	@FindAll({@FindBy(xpath = "//div[contains(@class, 'col-lg')]//a[contains(@class, 'display-4')]")})
	public List<WebElement> gamertag_links;
	
	public void waitPageLoad(int n) {
		Waiting.until(gamertag_links.get(n));
	}
	
	public String getGameText(int n) {
		return gamertag_links.get(n).getText();
	}
}
