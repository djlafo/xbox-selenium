package xbox.basepages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;

import util.Page;
import util.TestCaseBase;

public class LeaderboardPage extends Page {
	
	final static String gamertagLinksXPath = "(//div[contains(@class, 'col-lg')]//a[contains(@class, 'display-4')])";
	
	@FindAll({@FindBy(xpath = "//div[contains(@class, 'col-lg')]//a[contains(@class, 'display-4')]")})
	public List<WebElement> gamertag_links;
	
	public WebElement getNthgamertagLink(int n) {
		return TestCaseBase.threadDriver.get().findElement(By.xpath(gamertagLinksXPath + "[" + n + "]"));
	}
}
