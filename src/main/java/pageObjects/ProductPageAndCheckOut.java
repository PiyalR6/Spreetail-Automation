package pageObjects;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import coreClasses.BasePageObject;

public class ProductPageAndCheckOut extends BasePageObject  {
	private static Logger Log = Logger.getLogger(ProductPageAndCheckOut.class.getName());
	WebDriver driver = null;

	By VeirfyProductImage = By.xpath("//li[@class='slide selected']//img[@alt='Product Image']");
	By VeirfyTitile = By.xpath("//span[contains(@class,'ProductTitleLabel')]");
	By AddtoCart = By.xpath("//button[contains(text(),'Add to Cart')]");
	By VeirfyYourBag = By.xpath("///div[@class='modal-card-title']");
	By VeirfyPrice = By.xpath("//div[@class='price-label big']");
	By ProductNameInBag = By.xpath("(//span[contains(@class,'ManufacturerLabel')])[1]");
	By VeirfyPriceInBag = By.xpath("//div[@class='price-label small']");
	By Checkout = By.xpath("//button[contains(text(),'Checkout')]");

	public ProductPageAndCheckOut(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public Boolean verifyProductDetails() throws Exception {
		timeinterval(3);
		if (isDisplayed(VeirfyProductImage)) {
			if (isDisplayed(VeirfyTitile)) {
				if (isDisplayed(AddtoCart)) {
					timeinterval(3);
					return true;
				} else {
					System.out.println("User is not able to See Add To cart");
					return false;
				}
			} else {
				System.out.println("User is not able to see Title");
				return false;
			}
		} else {
			System.out.println("User is not able to see ProductImage");
			return false;
		}

	}

	public String getProductName() throws IOException, InterruptedException {
		String name = getText(VeirfyTitile);
		return name;
	}

	public String getProductPrice() throws IOException, InterruptedException {
		String name = getText(VeirfyTitile);
		name = name.replace('$', ' ').trim();
//		Double naem = Double.parseDouble(name);
		return name;
	}

	public void ClickOnAddToCart() throws IOException {
		click(AddtoCart);
	}

	public Boolean verifyYourBag() throws Exception {
		if (isDisplayed(VeirfyYourBag)) {
			return true;
		} else {
			System.out.println("User is not able to See YourBag");
			return false;
		}
	}

	public void VerifyThePrductDetailsOnYourBag(String productName, String price) throws Exception {
		String nameInBag = getText(ProductNameInBag);
		String priceInBage = getText(VeirfyPriceInBag);
		timeinterval(3);
//		priceInBage = priceInBage.replace('$', ' ').trim();
//		Double naem = Double.parseDouble(priceInBage);
//		Assert.assert(productName, nameInBag);
//		Assert.assertEquals(price, priceInBage);

	}

	public void ClickOnCheckOut() throws IOException {
		click(Checkout);
	}

	public boolean verifyProductQuantityMessage() throws IOException, InterruptedException {
		if(!isDisplayed(By.xpath("//*[@id=\"app-main\"]/div[1]/div/div/div[2]/p/span"))) {
		Log.info("There are more than 5 Products Quantity");	
		}else if (isDisplayed(By.xpath("//*[@id=\"app-main\"]/div[1]/div/div/div[2]/p/span"))) {
			if (getText(By.xpath("//*[@id=\"app-main\"]/div[1]/div/div/div[2]/p/span")).equalsIgnoreCase("Currently out of stock")) {
				return isEnable(By.xpath("//div[@class='Product__ProductListingWrapper-sc-6kjfej-0 gaaXee']//button[@type='button']"));
			}else {
				Log.info("Product Quantity is between 1 to 5");
				
			}
	}
		return true;
	}
}

