package pageObjects;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import coreClasses.BasePageObject;

public class AddAPaymentPage extends BasePageObject {
	private static Logger Log = Logger.getLogger(AddAPaymentPage.class.getName());

	public AddAPaymentPage(WebDriver driver) {
		super(driver);
		By Iframe = By.xpath("//iframe[@title='Secure payment input frame']");

		// TODO Auto-generated constructor stub
	}

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public void AddPaymentMethodPage() throws IOException {
		click(By.xpath(" //span[contains(text(),'Add Payment Method')]"));
		click(By.xpath(" //span[contains(text(),'Add Payment Method')]"));
		sendkeys(By.xpath("//input[@id='address-full-name']"), "Piyal");
		switchToIframe("__privateStripeFrame4");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"root\"]/form/div/div[2]/span[1]/span[2]/label/input")));
		sendkeys(By.xpath("//*[@id=\"root\"]/form/div/div[2]/span[1]/span[2]/label/input"), "4242 4242 4242 4242");
		sendkeys(By.name("exp-date"), "0424");
		sendkeys(By.name("cvc"), "123");
		switchToDefaultContent();
		sendkeys(By.id("address-line1"), "1955 Cactus Mound Dr");
		sendkeys(By.id("address-zip"), "78641");
		click(By.xpath("//button[contains(text(),'Save')]"));

	}

	public boolean verifyPaymentMethod() throws IOException {
		if (isDisplayed(By.xpath(" //h2[contains(text(),'Payment Method')]"))) {
			return true;
		} else {
			Log.info("Payment Method Page did not load ");
			System.out.println("User is not able to see Payment Method page");
			return false;
		}
	}

	public void clickBackToCheckout() throws IOException {
		click(By.xpath(" //button[contains(text(),'Back To Checkout')]"));

	}

	/*
	 * Random random = new Random();
	 * 
	 * String[] stringData = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
	 * "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
	 * "Z" };
	 * 
	 * int[] numericData = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; String[] stateData = {
	 * "AK", "AL", "AR", "AS", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "GU",
	 * "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN",
	 * "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK",
	 * "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VI", "VT", "WA",
	 * "WI", "WV", "WY" };
	 * 
	 * String address = "";
	 * 
	 * for (int i = 0; i < 3; i++) { int select =
	 * random.nextInt(numericData.length); address += numericData[select]; } address
	 * = address + " ";
	 * 
	 * for (int i = 0; i < 10; i++) { int select =
	 * random.nextInt(stringData.length); address += stringData[select]; }
	 * 
	 * String zipCode = "";
	 * 
	 * for (int i = 0; i < 5; i++) { int select =
	 * random.nextInt(numericData.length); zipCode += numericData[select]; }
	 * 
	 * sendkeys(By.id("address-line1"), address);
	 */
}
