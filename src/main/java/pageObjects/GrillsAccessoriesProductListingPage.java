package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class GrillsAccessoriesProductListingPage extends BasePageObject {

	public GrillsAccessoriesProductListingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean verifyGrillsPageisDisplayed() throws IOException {
		return isDisplayed(By.xpath("//h3[@class='title is-3']"));
	}

	public boolean VerifyUserIsOnGrillsPage() throws IOException, InterruptedException {
	timeinterval(3);
		return isDisplayed(By.xpath("//h3[@class='title is-3']piyalTest"));

	}
}
