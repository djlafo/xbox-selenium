package xbox.basepages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;

import util.Page;
import util.TestCaseBase;

public class GamerTagSearchPage extends Page {
	
	final static String gameLinksXPath = "(//div[contains(@class, 'game-card-container')]//a)";
	
	@FindAll({@FindBy(xpath = gameLinksXPath)})
	public List<WebElement> game_links;
	
	public WebElement getNthgameLink(int n) {
		return TestCaseBase.threadDriver.get().findElement(By.xpath(gameLinksXPath + "[" + n + "]"));
	}

}
