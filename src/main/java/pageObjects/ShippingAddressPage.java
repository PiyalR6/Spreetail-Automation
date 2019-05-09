package pageObjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingAddressPage extends BasePageObject {
	private static Logger Log = Logger.getLogger(ShippingAddressPage.class.getName());
	
    By FirstName = By.id("address-first-name");
    By LastName = By.id("address-last-name");
    By AddStreet = By.id("address-street");
    By AddCity = By.id("address-city");
    By DropDown = By.name("state");
    By AddZip = By.id("address-zip");
    By AddPhone = By.id("address-phone");
    By SaveContinue =  By.xpath("//button[@class='Buttons__PrimaryButton-sc-17gamhm-0 cNPOkx']//span[contains(text(),'Save & Continue')]");
    
	public ShippingAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriverWait wait = new WebDriverWait(driver,10);
	public void filloutShippingAddress() throws IOException, InterruptedException {

//		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName)).sendKeys("Def");
		sendkeys(FirstName,"aakla");
		sendkeys(LastName,"Leppard");
		sendkeys(AddStreet, " 30-95 Pour Some Sugar on Me");
		sendkeys(AddCity, "Love Bites");
		selectOptionFromDropDown(DropDown, "NY");
		sendkeys(AddZip, "11102");
		sendkeys(AddPhone, "718-545-9474");
		click (SaveContinue);

	}

	public void filloutInvalidShippingAddress() throws IOException, InterruptedException {
		timeinterval(3);
		sendkeys (FirstName, "");
		sendkeys(LastName,"Leppard");
		sendkeys(AddStreet, " 30-95 Pour Some Sugar on Me");
		sendkeys(AddCity, "Love Bites");
		selectOptionFromDropDown(DropDown, "NY");
		sendkeys(AddZip, "11102");
		sendkeys(AddPhone, "718-545-9474");
		click (SaveContinue);
		timeinterval(3);
	}

	public boolean verifyInvalidErrorMessage() throws IOException {
		return isDisplayed(By.xpath("//em[contains(text(),'Warning!')]"));
	}

	public boolean verifyInvalidFieldErrorMessage() throws IOException, InterruptedException {
		timeinterval(3);
		Log.info(getText(By.xpath("//div[contains(@class,'notification is-danger')]")));
		return isDisplayed(By.xpath("//div[contains(@class,'notification is-danger')]"));

	}

}
