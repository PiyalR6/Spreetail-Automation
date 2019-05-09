package pageObjects;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import coreClasses.BasePageObject;

public class GrillAccessoriesPage extends BasePageObject {
	private static Logger Log = Logger.getLogger(GrillAccessoriesPage.class.getName());

	public GrillAccessoriesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickOnGrillAccessories() throws IOException, InterruptedException {
		click(By.xpath("//p[contains(text(),'Grill Accessories')]"));
//		timeinterval(3);
	}

	public void showGrillAccessoriesNames() {

		List<WebElement> products = getlistofelement(By.xpath("//div[@id='product-title']"));
		System.out.print(products.size());
		for (WebElement e : products) {
			String product = e.getText();
			Log.info("Product Name :" + product);
		}
	}

	public boolean verifyGrillAccessoriesNames() throws IOException {
		int i = 0;

		List<WebElement> grillAccessoriesProducts = getlistofelement(By.xpath("//div[@id='product-title']"));
		System.out.print(grillAccessoriesProducts.size());
		for (WebElement e : grillAccessoriesProducts) {
			i++;
			String product = e.getText();
			Log.info(i + ". Product Name :" + product);
			if (product.isEmpty()) {
				return false;
			}
		}

		return true;
		// return (grillAccessoriesProducts.size() >= 7);
	}

	public boolean verifyProductNameDisplayed () throws IOException, InterruptedException {
		int j = 0;
		    String product; 
	 timeinterval(10);
		List<WebElement> productsOnPage;
		 productsOnPage = getlistofelement(
					By.xpath("//div[@id='product-title']"));
			System.out.print(productsOnPage.size());
			for (WebElement e : productsOnPage) {
				j++;
				product = e.getText();
				Log.info(j+". Product Name :"+product);
				if (product.isEmpty()) {
					return false;
				}
			}
			if (isDisplayed(By.id("pagination-next-arrow"))) {
			do	{
				click(By.id("pagination-next-arrow"));
				timeinterval(10);
				 productsOnPage = getlistofelement(
						By.xpath("//div[@id='product-title']"));
				System.out.print(productsOnPage.size());
				for (WebElement e1 : productsOnPage) {
					j++;
					 product = e1.getText();
					Log.info(j+". Product Name :"+product);
					if (product.isEmpty()) {
						return false;
					}
				}
			}while(!isDisplayed(By.xpath("//img[@alt=\"There are no more pages to load\"]")));
			
			}
			return true;
}
}
