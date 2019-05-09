package pageObjects;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import coreClasses.BasePageObject;

public class NavBarPage extends BasePageObject {
	By HomeMenu = By.xpath("//div[@class='navigation-item HeaderCategoryMenu__HeaderCatItem-sc-1ax1cp5-2 ffQorQ']");
	By KitchenMenu = By.xpath("//div[@class='navigation-item HeaderCategoryMenu__HeaderCatItem-sc-1ax1cp5-2 fyJbXi'][contains(text(),'Kitchen')]");
	By LawnGardenMenu = By.xpath("//div[@class='navigation-item HeaderCategoryMenu__HeaderCatItem-sc-1ax1cp5-2 fyJbXi'][contains(text(),'Lawn & Garden')]");
	By OutdoorLivingMenu = By.xpath("//div[@class='navigation-item HeaderCategoryMenu__HeaderCatItem-sc-1ax1cp5-2 fyJbXi'][contains(text(),'Outdoor Living')]");
	By PoolSpaMenu = By.xpath("//div[@class='navigation-item HeaderCategoryMenu__HeaderCatItem-sc-1ax1cp5-2 fyJbXi'][contains(text(),'Pool & Spa')]");
	By ShopByRoomMenu = By.xpath("//div[@class='navigation-item HeaderCategoryMenu__HeaderCatItem-sc-1ax1cp5-2 fyJbXi'][contains(text(),'Shop By Room')]");
	By SmartHomeMenu = By.xpath("//div[@class='navigation-item HeaderCategoryMenu__HeaderCatItem-sc-1ax1cp5-2 fyJbXi'][contains(text(),'Smart Home')]");
	By SportsOutdoorMenu =By.xpath("//div[@class='navigation-item HeaderCategoryMenu__HeaderCatItem-sc-1ax1cp5-2 fyJbXi'][contains(text(),'Sports & Outdoors')]");
	By ToolsMenu =By.xpath("//div[@class='navigation-item HeaderCategoryMenu__HeaderCatItem-sc-1ax1cp5-2 fyJbXi'][contains(text(),'Tools')]");

		
	public NavBarPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickOnHome() {

	}
	

	public void clickOnKitchen() throws IOException {
		click(KitchenMenu);

	}
	public void clickOnLawnGardenMenu() throws IOException {
		click(LawnGardenMenu);
		
	}
	public void clickOnOutdoorLivingMenu() throws IOException {
		click(OutdoorLivingMenu);
		
	}
	public void clickOnPoolSpaMenu() throws IOException {
		click(PoolSpaMenu);
	}
	public void clickOnShopByRoomMenu() throws IOException {
		click(ShopByRoomMenu);
		
		
	}
	public void clickSmartHomeMenu() throws IOException	{
		click(SmartHomeMenu);
		
	}
	public void clickSportsOutdoorMenu() throws IOException {
		click(SportsOutdoorMenu);
		
	}
	public void clickToolsMenu() throws IOException {
		click(ToolsMenu);
		
	}
}
