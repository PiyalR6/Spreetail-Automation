package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePageObject {


	By ShopFor = By.xpath("//div[@class='Typography__DivText-rz6iur-4 Typography__SBodyDiv-rz6iur-23 HeaderCategoryMenu__HeaderCatItem-sc-1a3ly1o-2 HeaderCategoryMenu__MenuItem-sc-1a3ly1o-4 gJDDZE']");
	By LawnGarden = By.xpath("//mat-toolbar[@class='top-navbar mat-elevation-z2 mat-toolbar mat-toolbar-single-row']//a[2]");
	By HamburgerMenu = By.xpath("\\\"//div[@class='navigation-item is-hidden-desktop']\\");
	By Generators = By.xpath("//a[@class='mat-button horizontal-active-link']");
	By PoolSupplies = By.xpath("//mat-toolbar[@class='top-navbar mat-elevation-z2 mat-toolbar mat-toolbar-single-row']//a[5]");
	By HouseHoldApplience = By.xpath("//mat-toolbar[@class='top-navbar mat-elevation-z2 mat-toolbar mat-toolbar-single-row']//a[6]");
	By AllProducts = By.xpath("//mat-toolbar[@class='top-navbar mat-elevation-z2 mat-toolbar mat-toolbar-single-row']//a[8]");
	By Contact = By.xpath("//mat-toolbar[@class='top-navbar mat-elevation-z2 mat-toolbar mat-toolbar-single-row']//a[8]");
	By GrillAccessories = By.xpath("//div[@class='tile box is-child notification is-info']");
	By Input0= By.id ("mat-input-0");
	By Input1 = By.id("mat-input-1");
	By Input2 = By.id("mat-input-2");
	By Input3 = By.id("mat-input-3");
	By LoginButton = By.xpath("//button[contains(text(),'Login')]");
	By searchBox = By.id("search-input");
	
	public HomePage(WebDriver driver) throws InterruptedException {
		super(driver);
//		timeinterval(4);
		// TODO Auto-generated constructor stub
	}

	WebDriverWait wait = new WebDriverWait(driver,10);
	public void clicklawnGarden() throws IOException {
		click(LawnGarden);
	}
	
	public void logInButton() throws IOException, InterruptedException {
		click(LoginButton);
		
	}
	public void clickMainMenu() throws IOException {
	wait.until(ExpectedConditions.elementToBeClickable(ShopFor)).click();

	}
	
	public void clickHamburgerMenu() throws IOException {
		click(HamburgerMenu);	
	}

	public void clickGenerators() throws IOException {
		click(Generators);
	}

	public void clickPoolsSupplies() throws IOException {
		click(PoolSupplies);
	}
	public void clickHouseholdAppliances() throws IOException {
		click(HouseHoldApplience);
	}
	public void clickAllProducts() throws IOException {
		click(AllProducts);
	}
	public void clickContact() throws IOException {
		click(Contact);
	}
	public void searchProduct(String searchQuery) throws IOException, InterruptedException {
		sendkeys(By.xpath("//input[@placeholder='Search...']"), searchQuery);
		click(By.xpath("//span[@class='is-hidden-touch']//img[@title='Search Button']"));
		timeinterval(5);
	}
	public void clickGrillAccessories() throws IOException {
		click(GrillAccessories);
	}
	public void contactUs() throws IOException {
		sendkeys(Input0, " Piyal");
		sendkeys(Input1, "piyal.kamal@spreetail.com");
		sendkeys(Input2,"5126875309");
		sendkeys(Input3, " I do wanna buy the biggest grill you have in your stock");
		click(By.xpath(" //button[@type='submit']"));

	}
	
}

