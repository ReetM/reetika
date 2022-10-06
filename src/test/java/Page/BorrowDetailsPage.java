package Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BorrowDetailsPage {

	By numberOfDependents=By.cssSelector("select[title='Number of dependants']");
	By annualIncome=By.xpath("//*[text()='Your annual income (before tax)']/following-sibling::div/input");
	By otherAnnualIncome=By.xpath("//*[text()='Your annual other income (optional)']/following-sibling::div/input");
	By monthlylivingExpenses=By.xpath("//*[text()='Monthly living expenses ']/following-sibling::div/input");
	By currenthomeloanRepayments=By.xpath("//*[contains(text(),'Current home loan ')]/following-sibling::div/input");
	By otherloanMonthlyRepayments=By.xpath("//*[contains(text(),'Other loan monthly repayments')]/following-sibling::div/input");
	By otherMonthlycommitments=By.xpath("//*[contains(text(),'Other monthly commitments')]/following-sibling::div/input");
	By totalCreditCardLimits=By.xpath("//*[contains(text(),'Total credit card limits')]/following-sibling::div/input");
	By btnEstimateborrow=By.id("btnBorrowCalculater");
	public void enterPersonaldetails(WebDriver driver,String NumberOfDependent) {
		   driver.findElement(By.id("application_type_single")).click();
		   Select s = new Select(driver.findElement(numberOfDependents));
		   s.selectByVisibleText(NumberOfDependent);
		   driver.findElement(By.id("borrow_type_home")).click();
	}
	public void enterEarnings(WebDriver driver,String income,String otherIncome) {
		driver.findElement(annualIncome).sendKeys(income);
		driver.findElement(otherAnnualIncome).sendKeys(otherIncome);

	}
	public void enterexpenses(WebDriver driver,String livingExpenses,String homeloanRepayments,String otherloanRepayments,String othercommitments,String totalCreditCardLimit) {
		driver.findElement(monthlylivingExpenses).sendKeys(livingExpenses);
		driver.findElement(currenthomeloanRepayments).sendKeys(homeloanRepayments);
		driver.findElement(otherloanMonthlyRepayments).sendKeys(otherloanRepayments);
		driver.findElement(otherMonthlycommitments).sendKeys(othercommitments);
		driver.findElement(totalCreditCardLimits).sendKeys(totalCreditCardLimit);
	}
	public void estimateBorrowAmount(WebDriver driver) {
		driver.findElement(btnEstimateborrow).click();

	}
	public void verifyClearForm(WebDriver driver)  {
	    Assert.assertTrue("Estimated Amount is not reset",driver.findElement(By.xpath("//span[@class='borrow__result__text']/span")).getText().equals("$0"));
		Assert.assertTrue("MonthlylivingExpenses Value is not cleared",driver.findElement(monthlylivingExpenses).getAttribute("value").equals("0") );
		
	}
	public void enterLivingexpenses(WebDriver driver,String livingExpenses) {
		driver.findElement(monthlylivingExpenses).sendKeys(livingExpenses);
	}
}
