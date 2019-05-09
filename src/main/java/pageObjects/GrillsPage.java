package pageObjects;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import coreClasses.BasePageObject;

public class GrillsPage extends BasePageObject {
	private static Logger Log = Logger.getLogger(GrillsPage.class.getName());

	public GrillsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void showGrillNames() {

		List<WebElement> products = getlistofelement(By.xpath("//section//a//div[@id='product-title']"));
		System.out.print(products.size());
		for (WebElement e : products) {
			String product = e.getText();
			Log.info(product);
			System.out.println(product);

		}
//	for(WebElement product: products) {
//		   String productName = product .getText();
//		    System.out.println(productName);
//}
	}

	public void clickOnGrillTab() throws IOException, InterruptedException {
		click(By.xpath("//div[@class='tile box is-child notification is-primary']"));
		Thread.sleep(6000);

	}

public void showGrillsNames() {
	List<WebElement> products = getlistofelement(By.xpath("//section//a//div[@id='product-title']"));
	System.out.print(products.size());
	for (WebElement e : products) {
		String product = e.getText();
		Log.info(product);

	}

}
	public boolean verifyGrillsProductNames() {
		List<WebElement> grillsProducts = getlistofelement(
				By.xpath("//section//a//div[@id='product-title']"));
		System.out.print(grillsProducts.size());
		for (WebElement e : grillsProducts) {
			String product = e.getText();
			if (product.isEmpty()) {
				return false;
			}
		}
		return true;

	}
}
