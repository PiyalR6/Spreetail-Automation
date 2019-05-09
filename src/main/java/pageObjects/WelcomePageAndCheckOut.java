package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.Dynamic;
import com.util.UtilsMethods;

import coreClasses.BasePageObject;

public class WelcomePageAndCheckOut extends BasePageObject {
	By VerifyWelcome =By.xpath("//div[@class='logo-text navigation-item']/a");
	By Products=By.xpath("//div[@class=' wrapper']");
	By ProductsDynamicXpath=By.xpath("(//div[@class=' wrapper'])[%s]");
	By ShopFor=By.xpath("//div[@class='navigation-item is-hidden-touch']");
	By ceteogry=By.xpath("//div[@class='category-label' and contains(text(),'%s')]");
	UtilsMethods util = null;
	WebDriver driver = null;

	public WelcomePageAndCheckOut(WebDriver driver) {
		super(driver);
//		this.driver = driver;
//		util = new UtilsMethods(driver);
	}

	public boolean verifyWelcomePage() throws Exception {
		if (isDisplayed(VerifyWelcome)) {
			return true;

		} else {
			System.out.println("User is not able to see Spreetail Home Page");
			return false;

		}
	}

	public void clickOnProductRandomly() throws IOException, InterruptedException {
		timeinterval(3);
		List<WebElement> list = getlistofelement(Products);
		int size = list.size();
		By by = Dynamic.getNewLocator(ProductsDynamicXpath, Integer.toString(util.RandomSelect(1, size)));
		click(by);
		timeinterval(3);
	}

	public void Shopfor() throws Exception {
		click(ShopFor);
	}

	public void ClickOncateogry(String name) throws Exception {
		By by = Dynamic.getNewLocator(ceteogry, name);
		timeinterval(3);
		click(by);
	}
}
