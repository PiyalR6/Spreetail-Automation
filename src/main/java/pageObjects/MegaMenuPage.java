package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import coreClasses.BasePageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MegaMenuPage extends BasePageObject {
	private static Logger Log = Logger.getLogger(MegaMenuPage.class.getName());

	By SmartHome = By
			.xpath("//div[@class='MegaMenuCard__LabelWrapper-sc-1dqelas-1 bcdOzX'][contains(text(),'Smart Home')]");
	By Kitchen = By.xpath(" //div[@title='kitchen']");
	By SportsOutdoors = By.xpath(
			"//div[@class='MegaMenuCard__LabelWrapper-sc-1dqelas-1 bcdOzX'][contains(text(),'Sports & Outdoors')]");
	By PoolSpa = By
			.xpath(" //div[@class='MegaMenuCard__LabelWrapper-sc-1dqelas-1 bcdOzX'][contains(text(),'Pool & Spa')]");
	By LawnGarden = By
			.xpath("//div[@class='MegaMenuCard__LabelWrapper-sc-1dqelas-1 bcdOzX'][contains(text(),'Lawn & Garden')]");
	By ShopByRoom = By.xpath("//div[@title='shop-by-room']");
	By OutdoorLiving = By
			.xpath("//div[@class='MegaMenuCard__LabelWrapper-sc-1dqelas-1 bcdOzX'][contains(text(),'Outdoor Living')]");
	By Tools = By.xpath("//div[@title='tools']");

	public MegaMenuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	WebDriverWait wait = new WebDriverWait(driver,10);

	public void clickOnMegaMenu(String megaMenu) throws IOException, InterruptedException{
		Boolean elementIsPresent= false;
		int count=0;

		do {
			List<WebElement> text = driver.findElements(By.xpath("//section[@class='spree-modal-body']//div[contains(text(),'"+ megaMenu + "')]"));
			if(text.size()!=0 || count==4){
				elementIsPresent=true;
			}
			count++;

			System.out.println(count);

		}while (!elementIsPresent);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//section[@class='spree-modal-body']//div[contains(text(),'"+ megaMenu + "')]")))).click();

}

	public void clickSmartHome() throws IOException {
		click(SmartHome);
	}

	public void clickOnKitchen() throws IOException {
		click(Kitchen);
	}

	public void clickOnSportsOutdoor() throws IOException {
		click(SportsOutdoors);
	}

	public void clickOnPoolSpa() throws IOException {
		click(PoolSpa);

	}

	public void clickOnLawnGarden() throws IOException {
		click(LawnGarden);
	}

	public void clickOnShopByRoom() throws IOException {
		click(ShopByRoom);
	}

	public void clickOnOutdoorLiving() throws IOException {
		click(OutdoorLiving);
	}

	public void clickOnTools() throws IOException {
		click(Tools);
	}

	public void clickOutdoorGrillAccessories() throws IOException, InterruptedException {
		click(By.xpath("//div[contains(text(),'Outdoor Grill Accessories')]"));
		timeinterval(3);

	}

	public void clickPoolSpa() throws IOException {
		click(By.xpath(
				" //div[@class='MegaMenuCard__LabelWrapper-sc-1dqelas-1 bcdOzX'][contains(text(),'Pool & Spa')]"));
	}

	public void clickSwimingPool() throws IOException, InterruptedException {
		click(By.xpath(
				"//div[@class='MegaMenuCard__LabelWrapper-sc-1dqelas-1 bcdOzX'][contains(text(),'Swimming Pools')]"));
		timeinterval(10);

	}

	public void clickGrills() throws IOException, InterruptedException {
		click(By.xpath("//div[@title='grills']"));
		timeinterval(10);

	}

	public void clickGrillsGrillAcccessories() throws IOException, InterruptedException {
		click(By.xpath("//div[contains(text(),'Grills and Grill Accessories')]"));
		timeinterval(3);

	}

	public void printMenuName() {
		List<WebElement> menuitem = getlistofelement(
				By.xpath("//section//div[@role='button']//div[@class='category-label']"));
		System.out.print(menuitem.size());
		for (WebElement e : menuitem) {
			String menu = e.getText();
			Log.info(" Mega Menu Name :" + menu);

		}
	}

	public boolean verifyMegaMenuCategoryList() throws InterruptedException {
		int i = 0;

		List<WebElement> menuitem = getlistofelement(
				By.xpath("//section//div[@role='button']//div[@class='category-label']"));
		timeinterval(3);

		List<String> expectedOrder = new ArrayList<String>();
		expectedOrder.add("Smart Home");
		expectedOrder.add("Kitchen");
		expectedOrder.add("Sports & Outdoors");
		expectedOrder.add("Pool & Spa");
		expectedOrder.add("Lawn & Garden");
		expectedOrder.add("Shop By Room");
		expectedOrder.add("Outdoor Living");
		expectedOrder.add("Tools");
		expectedOrder.add("Home");

		for (WebElement e : menuitem) {
			String menu = e.getText();
			Log.info(" Mega Menu Name :" + menu);
			Log.info("Expected Menu Iteam Name:" + expectedOrder.get(i));

			if (!expectedOrder.get(i).equals(menu)) {
				return false;
			}
			i++;
		}
		return true;
	}
}
