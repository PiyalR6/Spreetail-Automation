package pageObjects;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PDPPage extends BasePageObject {

	public PDPPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriverWait wait = new WebDriverWait(driver,10);

	By addToCart = By.xpath("//span[contains(text(),'Add To Cart')]");
	By brandName = By.xpath("//div[@class='Product__ProductListingWrapper-o90kst-0 cACWNG']//a[@itemprop='brand']");

	public void checkLawnGarden() throws IOException, InterruptedException {
		click(By.xpath("//a[@class='mat-button horizontal-active-link']"));
	}

	public boolean verifyUserSeesProductDetails() throws IOException {
		return isDisplayed(By.xpath("//b[contains(text(),'Lawn & Garden')]"));

	}

	public void clickAddToCart() throws IOException, InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();

//		timeinterval(3);
//		if (isDisplayed(By.xpath("//span[contains(text(),'Add To Cart')]")))
//		{
//			click(By.xpath("//span[contains(text(),'Add To Cart')]"));
//			timeinterval(3);
//		}else {
//			navigateBack();
//
//
//		}
		
	}

	public void clickonBrandNameAndVerifyResult() throws IOException, InterruptedException {
		String expectedText = getText(brandName);
		wait.until(ExpectedConditions.elementToBeClickable(brandName)).click();
		List<WebElement> productListingBrandNames = driver.findElements(By.xpath("//div[@class='columns is-tablet is-multiline']//span[@id='product-title']//b"));

		for (WebElement productBrand : productListingBrandNames) {
			Assert.assertEquals(productBrand.getText(),expectedText, productBrand.getText() + " was supposed to be " + expectedText +" --- !!! WRONG BRAND SHOWN !!! ---");
		}
	}

}
