package xbox.basepages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;

import util.Page;
import util.TestCaseBase;
import util.Waiting;

public class GamerTagSearchPage extends Page {
	
	final static String gameLinksXPath = "(//div[contains(@class, 'game-card-container')]//a)";
	
	@FindAll({@FindBy(xpath = gameLinksXPath)})
	public List<WebElement> game_links;
	
	public void waitUntilLoad(int n) {
		Waiting.until(game_links.get(n));
	}
	
	public String getGameText(int n) {
		return game_links.get(n).getText().trim();
	}

}
