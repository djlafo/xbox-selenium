package xbox.testcase;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.SystemUtil;
import util.TestCaseBase;
import xbox.basepages.GamerTagHomePage;
import xbox.basepages.GamerTagSearchPage;

public class TopGames extends TestCaseBase {

	@Test(groups = {"firefox", "ChromeWin32"})
	public void testGames() throws Exception {
		Properties PROPERTIES_RESOURCES = SystemUtil
				.loadPropertiesResources("/testdata_xbox.properties");
		final String gamertag = PROPERTIES_RESOURCES.getProperty("gamertag.search_name");
		final String[] topGames = PROPERTIES_RESOURCES.getProperty("gamertag.top_games").split(",");
		
		GamerTagHomePage homePage = new GamerTagHomePage();
		homePage.open();
		homePage.waitUntilLoad();
		GamerTagSearchPage searchPage = homePage.search(gamertag);
		searchPage.waitUntilLoad(topGames.length);
		
		for(int i=0; i<topGames.length; i++) {
			Assert.assertEquals(searchPage.getGameText(i), topGames[i]);
		}
	}
	
}
