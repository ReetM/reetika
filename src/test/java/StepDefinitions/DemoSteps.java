package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;


import Page.BorrowDetailsPage;
import coreUtils.BrowserFactory;
import coreUtils.SeleniumCore;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSteps extends SeleniumCore {
	BorrowDetailsPage borrowDetailsPage=new BorrowDetailsPage();
	//WebDriver driver;
/*
	@Before
	public void initialize() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@After
	public void tierDown() {
		driver.quit();
	}*/
	@Given("Launch URL and Navigate to URL")
	public void launch_url_and_navigate_to_url() {
		driver.get("http://www.seleniumframework.com/Practiceform/");
		//driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	}

	@And("Enter Usename and Passoword")
	public void enter_usename_and_passoword() {
		By locator= By.xpath("//button[text()='New Browser Window']");
		clickElement(locator);
		//String Username=driver.findElement(RelativeLocator.with(By.tagName("p")).above(By.xpath("//input[@name='username']"))).getText();
	    
		//System.out.println("***********"+Username);
		// Write code here that turns the phrase above into concrete actions

	}

	@When("User is on Home Page")
	public void user_is_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Home Page defination");
	
	}

	@Then("Verify Home Page")
	public void verify_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Home Page defination2");

	}
}
