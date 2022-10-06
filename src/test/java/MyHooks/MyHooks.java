package MyHooks;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import coreUtils.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyHooks {
	public static WebDriver driver;
	@Before
	public void initialize() {
		BrowserFactory.initializeBrowser();
	
	}
	@After
	public void tierDown() {
		BrowserFactory.quickBrowser();
	}

}
