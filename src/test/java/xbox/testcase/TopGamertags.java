package xbox.testcase;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.SystemUtil;
import util.TestCaseBase;
import util.Waiting;
import xbox.basepages.GamerTagHomePage;
import xbox.basepages.LeaderboardPage;

public class TopGamertags extends TestCaseBase {
	
	@Test(groups = {"firefox", "ChromeWin32"})
	public void testGamertags() throws Exception {
		Properties PROPERTIES_RESOURCES = SystemUtil
				.loadPropertiesResources("/testdata_xbox.properties");
		final String[] gamertags = PROPERTIES_RESOURCES.getProperty("gamertag.top_gamertags").split(",");
		
		GamerTagHomePage homePage = new GamerTagHomePage();
		homePage.open();
		Waiting.until(homePage.leaderboards_link);
		LeaderboardPage leaderboards = homePage.openLeaderboardPage();
		Waiting.until(leaderboards.getNthgamertagLink(gamertags.length));
		
		for(int i=0; i<gamertags.length; i++) {
			Assert.assertEquals(gamertags[i], leaderboards.gamertag_links.get(i).getText());
		}
	}
}
