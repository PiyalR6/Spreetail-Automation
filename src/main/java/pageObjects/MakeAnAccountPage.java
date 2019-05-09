package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class MakeAnAccountPage extends BasePageObject {

	public MakeAnAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void makeAnAccount() throws IOException {
		sendkeys(By.xpath(" //input[@placeholder='First Name']"), "Bon");
		sendkeys(By.xpath("//input[@placeholder='Last Name']"), "Jovi");
		sendkeys(By.xpath("//input[@placeholder='Passwords']"), "Passwrod");
		click(By.xpath("//button[contains(text(),'Create Account & Checkout')]"));

	}

}
