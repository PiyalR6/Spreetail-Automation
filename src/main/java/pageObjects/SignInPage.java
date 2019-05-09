package pageObjects;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import coreClasses.BasePageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignInPage extends BasePageObject {

	By UserName = By.name("username");
	By Password = By.name("password");
	By SigninButton = By.id("okta-signin-submit");
	By SignUpLinkButton = By.xpath("//a[@title='Sign up']");

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriverWait wait = new WebDriverWait(driver,10);

	public void SignIn() throws IOException, InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(UserName)).sendKeys("piyal2020@gmail.com");
		sendkeys(Password, "spreetail");
		click(SigninButton);

		List<WebElement> signInFailed = driver.findElements(By.cssSelector(".o-form-error-container.o-form-has-errors"));
		Assert.assertEquals(signInFailed.size(), 0,"Wrong Username or Password! Sign In Failed!");
	}

	public void signUpLink() throws IOException, InterruptedException {
		click(SignUpLinkButton);
		timeinterval(3);
	}

}
