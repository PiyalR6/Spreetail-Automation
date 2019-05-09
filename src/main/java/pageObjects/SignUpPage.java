package pageObjects;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class SignUpPage extends BasePageObject {
	
	By EnteRandomEmail = By.name("email");
	By Password = By.name("password");
	By FirstName = By.name("firstName");
	By LastName =By.name("lastName");
	By CreateAccountButton = By.xpath("//input[@value='Create account']");
	
	public SignUpPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
public void  createAccount() throws InterruptedException, IOException {
	sendkeys(EnteRandomEmail,"testuser"+RandomStringUtils.randomAlphanumeric(3)+ "@spreetail.com");
	timeinterval(3);
	sendkeys(Password, "test@123");
	sendkeys(FirstName, "Test");
	sendkeys(LastName, "User");
	click(CreateAccountButton);
	timeinterval(3);
	
	
}

}
