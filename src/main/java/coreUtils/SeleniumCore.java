package coreUtils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCore extends BrowserFactory{
	WebDriverWait wait;
	LoggerUtil log;
	public SeleniumCore() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}	
	public WebElement finder(By Locator) {
		WebElement element=null;
		try {
			element=driver.findElement(Locator);
			
		}
		catch(NoSuchElementException e){
			logMessage("⚠ [ELEMENT NOT FOUND] : You might have to update the locator:-" + Locator);
		}
		catch(StaleElementReferenceException e) {
			logWarning("⚠ [Stale Element Exception!!] : Refinding the element after 5 seconds" + Locator);

		}
		return element;
	}
	public void clickElement(By locator) {
		WebElement element = finder(locator);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			log.info("✔ Clicked Element " + element + " Successfully!");
		} catch (StaleElementReferenceException ex1) {
			holdExecution(4000);
			element = finder(locator);
			element.click();
			log.warn("⚠ Clicked Element " + element + " after catching Stale Element Exception");
		} catch (WebDriverException ex3) {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			holdExecution(4000);
			performClickByActionBuilder(locator);
			log.warn("⚠ Clicked Element " + element + " after catching WebDriver Exception");
		}

	}
	public void holdExecution(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			logMessage("Failed while trying to halt execution!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void performClickByActionBuilder(By locator) {
		WebElement element = finder(locator);
		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
		builder.moveToElement(element).click().perform();
	}
	public void logMessage(String message) {
		log.info("✔  " + message);
	}
	public void logWarning(String message) {
		log.warn("⚠ " + message);
	}
	
	//
	public void logError(String message) {
		log.error("❌" + message);
	}
}
