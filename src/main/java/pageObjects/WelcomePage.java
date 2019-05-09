package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;
import freemarker.log.Logger;

public class WelcomePage extends BasePageObject {
	By Welcome = By.xpath("//span[contains(text(),'Welcome to Spreetail')]");
	By Spreetail = By.xpath("//a[@title='Go to Spreetail.com homepage']");
	By Shopfor =  By.xpath("//div[@class='navigation-item is-hidden-touch']");
	By SearchField = By.xpath("//input[@placeholder='Search...']");
	By SearchButtom = By.xpath("//span[@class='is-hidden-touch']//img[@title='Search Button']");
	By ShoppingCart = By.xpath("//body[@screen_capture_injected='true']/div[@id='app']/div/header[@role='banner']/nav[@class='navigation']/div[@class='container flex-container navigation-container']/div[@class='navigation-right']/div[@class='navigation-item']/img[1]");
	By Footer = By.xpath(" //div[@class='ui inverted vertical centered footer segment']");
	By Loggedout = By.xpath("//button[contains(text(),'Logout')]");
	
	public WelcomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private static Logger Log = Logger.getLogger(WelcomePage.class.getName());

	public void clickGrills() throws IOException {
		click(By.xpath("//p[contains(text(),'Grills')]"));
	}
	
	public boolean verifyUserLoggedInSuccessfully() throws IOException, InterruptedException {
		if (isDisplayed(Loggedout)) {
			Log.info("User is able to See Logout Button" + getText(Loggedout));
		return true;
	}else {
		Log.info("User is not able to see Login page");
		return false;
	}
	}
	
	public boolean verifyWelcomePageSuccessfully() throws IOException {
		if (isDisplayed((Welcome)) &&isDisplayed((Spreetail)) && isDisplayed((Shopfor)) && isDisplayed((SearchField)) && isDisplayed((SearchButtom)) && isDisplayed((Footer))) {
			return true;
		} else {
			Log.info("Welcome Page Did Not Load");
			System.out.println("User is not able to see Spreetail Home Page");
			return false;
		}
		
	}
}

