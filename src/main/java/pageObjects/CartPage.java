package pageObjects;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePageObject {
	WebDriverWait wait = new WebDriverWait(driver,10);
	By CheckOutButton = By.xpath("//button[contains(text(),'Checkout')]");
	By EnterEmailAddress = By.xpath("//input[@placeholder='Email Address");
	By ContinueButton = By.xpath("//button[@type='submit']");

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stubz
	}

	public void clickOnChekout() throws IOException, InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(CheckOutButton)).click();

	}
	public void enterEmailAddress() throws InterruptedException {
		sendkeys(EnterEmailAddress,"bon"+RandomStringUtils.randomAlphanumeric(3)+ "@spreetail.com");
//		timeinterval(5);
		
	}
	public void clickOnContinue() throws IOException {
		click(ContinueButton);
	}

}
