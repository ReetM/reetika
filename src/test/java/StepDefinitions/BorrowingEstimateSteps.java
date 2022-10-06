package StepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Page.BorrowDetailsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import MyHooks.MyHooks;
public class BorrowingEstimateSteps extends BorrowDetailsPage{
	WebDriver driver= MyHooks.driver;
	BorrowDetailsPage borrowDetailsPage=new BorrowDetailsPage();
	
	@Given("Navigate to Calculator Home Page")
	public void Navigate_to_Calculator_Home_Page() {
		driver.navigate().to("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
	}
	@And("Validate Page Loaded Successfully")
	public void validate_page_loaded_successfully(){
		String title=driver.getTitle();
		String expectedTitle="Home loan borrowing power calculator | ANZ";
		Assert.assertEquals("Page not loaded",title, expectedTitle);
	}

	@Given("^User enters Personal details (.*)$")
	public void User_enters_Personal_details(String NumberOfDependent) throws InterruptedException {
		Thread.sleep(10000);
		borrowDetailsPage.enterPersonaldetails(driver,NumberOfDependent);

	}

	@And("^Enter your earnings (.*) and (.*)$")
	public void enter_your_earnings(String income,String otherIncome) {
		borrowDetailsPage.enterEarnings(driver,income,otherIncome);


	}

	@And("^Enter your expenses (.*),(.*),(.*),(.*) and (.*)$")
	public void enter_your_expenses(String livingExpenses,String homeloanRepayments,String otherloanRepayments,String othercommitments,String totalCreditCardLimit) {
		System.out.println(" Search page");
		borrowDetailsPage.enterexpenses(driver,livingExpenses,homeloanRepayments,otherloanRepayments,othercommitments,totalCreditCardLimit);

	}

	@When("Click on workout how much I could borrow Button")
	public void Click_on_workout_how_much_I_could_borrow_Button() {
		borrowDetailsPage.estimateBorrowAmount(driver);
	}

	@Then("^Verify borrowing estimate (.*)$")
	public void Verify_borrowing_estimate(String ExpectedAamount) throws InterruptedException {
		Thread.sleep(10000);
		String amount=driver.findElement(By.xpath("//span[@class='borrow__result__text']/span")).getText();
		System.out.print(amount);
		Assert.assertEquals("Estimated Amount doesn't Matched",amount, ExpectedAamount);

	}
	@Given("^User has calculated borrowing estimate(.*),(.*),(.*),(.*),(.*),(.*),(.*) and (.*)$")
	public void user_has_calculated_borrowing_estimate(String NumberOfDependent,String income,String otherIncome,String livingExpenses,String homeloanRepayments,String otherloanRepayments,String othercommitments,String totalCreditCardLimit) {
		borrowDetailsPage.enterPersonaldetails(driver,NumberOfDependent);
		borrowDetailsPage.enterEarnings(driver,income,otherIncome);
		borrowDetailsPage.enterexpenses(driver,livingExpenses,homeloanRepayments,otherloanRepayments,othercommitments,totalCreditCardLimit);
		borrowDetailsPage.estimateBorrowAmount(driver);

	}
	@When("User hit start over to clear form")
	public void User_hit_start_over_to_clear_form() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='result__restart']/button[@class='start-over']")).click();
	}
	@Then("Form should clear")
	public void form_should_clear() throws InterruptedException {
		Thread.sleep(10000);
		borrowDetailsPage.verifyClearForm(driver);
	}

	@Given("^User has calculated borrowing estimate with living expenses(.*)$")
	public void User_has_calculated_borrowing_estimate_with_living_expenses(String livingExpenses) {
		borrowDetailsPage.enterLivingexpenses(driver,livingExpenses);
	}
	@When("Click on workout how much I could borrow button")
	public void click_on_workout_how_much_i_could_borrow_button() throws InterruptedException {
		Thread.sleep(8000);
		borrowDetailsPage.estimateBorrowAmount(driver);
	}

	@Then("Verify the Error Message on Screen")
	public void Verify_the_Error_Message_on_Screen() throws InterruptedException{
		Thread.sleep(4000);

		String msg=driver.findElement(By.className("borrow__error__text")).getText();
		System.out.println(msg);
	}
}
