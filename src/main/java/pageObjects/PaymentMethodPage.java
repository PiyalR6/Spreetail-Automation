package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentMethodPage extends BasePageObject {
By Iframe = By.xpath("//iframe[@title='Secure payment input frame']");

	public PaymentMethodPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	WebDriverWait wait = new WebDriverWait(driver,10);

	public void enterCreditCardInfo() throws IOException, InterruptedException {
		sendkeys(By.id("address-full-name"), "Madonna");
		switchToIframe("__privateStripeFrame4");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/form/div/div[2]/span[1]/span[2]/label/input")));
		sendkeys(By.xpath("//*[@id=\"root\"]/form/div/div[2]/span[1]/span[2]/label/input"), "4242 4242 4242 4242");
		sendkeys(By.name("exp-date"), "0424");
		sendkeys(By.name("cvc"),"123");
		//sendkeys(By.name("postal"),"11102");
//		timeinterval(3);
		switchToDefaultContent();
//		timeinterval(3);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Save & Continue')]"))).click();
	}
}
