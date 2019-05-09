package pageObjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class FooterPage extends BasePageObject {
	Logger Log = Logger.getLogger(FooterPage.class.getName());

	By ShippingReturnPolicy = By.xpath("//span[contains(text(),'Shipping & Return Policy')]");
	By FAQs = By.xpath(" //span[contains(text(),'FAQs')]");
	By AboutUS = By.xpath("//span[contains(text(),'About Us')]");
	By CommunityImpact = By.xpath("//span[contains(text(),'Community Impact')]");
	By Careers = By.xpath("//span[contains(text(),'Careers')]");
	By Suppliers = By.xpath("//span[contains(text(),'Suppliers')]");
	By PhoneNumber = By.xpath(
			" //a[@class='Footer__ContactActionLink-sc-17y52m2-9 XTeGk']//span[contains(text(),'(833) 777-3382')]");

	public FooterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean verifyPageTitleOnNewTab(String PageTitle) {
		switchToWindow(1);
		Log.info(getPageTitle());
		if (getPageTitle().equalsIgnoreCase(PageTitle)) {
			return true;
		}
		return false;
	}

	public void clickOnLink(String link) throws IOException, InterruptedException {
		timeinterval(3);
		scrollElementIntoView(By.xpath("//span[contains(text(),'" + link + "')]"));
		click(By.xpath("//span[contains(text(),'" + link + "')]"));
		timeinterval(10);
	}

	public void clickShippingReturnPolicy() throws IOException {
		click(ShippingReturnPolicy);

	}

	public void closeCurrentPage() {
		closeCurrentPage();
	}

	public void clickFAQs() throws IOException {
		click(FAQs);

	}

	public void clickAboutUs() throws IOException {
		click(AboutUS);

	}

	public void clickCommunityImpact() throws IOException {
		click(CommunityImpact);

	}

	public void clickCareers() throws IOException {
		click(Careers);

	}

	public void clickSuppliers() throws IOException {
		click(Suppliers);
	}

	public void clickPhoneNumber() throws IOException, InterruptedException {
		// scrollDown();
		scrollElementIntoView(PhoneNumber);
		click(PhoneNumber);
		timeinterval(10);
		String AlertMessage = getAlertText();
		Log.info(AlertMessage);
		cancelPopUp();
	}
}
