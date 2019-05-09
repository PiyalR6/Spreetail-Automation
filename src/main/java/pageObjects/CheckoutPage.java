package pageObjects;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.util.Dynamic;

import coreClasses.BasePageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPage extends BasePageObject {
	
	private static Logger Log = Logger.getLogger(CheckoutPage.class.getName());


//		WebDriver driver = null;
		By VerifyHeader=By.xpath("//a[contains(text(),'Spreetail')]");
		By VerifySectionTitle=By.xpath("//h5[@class='section-title']");
		By email=By.xpath("//input[@type='Email Address']");
		By continueButton=By.xpath("//button[@type='submit']");
		By CheckoutButton=By.xpath("//button[contains(text(),'Create Account & Checkout')]");
		By PlaceOrderButton=By.xpath("//button[contains(text(),'Place Order')]");
		By SaveButton=By.xpath("//button[contains(text(),'Save & Continue')]");
		By DynamicInputByPlaceHolder=By.xpath("//input[@placeholder='%s']");
		By SelectState=By.xpath("//select[@class='level-item']");
		By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
		By orderID = By.id("order-id");
		
		public CheckoutPage(WebDriver driver) {
			super(driver);
			this.driver = driver;
		}

	WebDriverWait wait = new WebDriverWait(driver,10);



		public Boolean verifyHeader() throws Exception {
			if (isDisplayed(VerifyHeader)) {
				return true;
			} else {
				System.out.println("User is not able to See VerifyHeader");
				return false;
			}
		}

		public Boolean verifyHeader2() throws Exception {
			if (isDisplayed(VerifySectionTitle)) {
				return true;
			} else {
				System.out.println("User is not able to See VerifySectionTitle");
				return false;
			}
		}

		public void GiveInputToField(String name, String value) {
			By by = Dynamic.getNewLocator(DynamicInputByPlaceHolder, name);
			sendkeys(by, value);
//			sendkeys(email, "Mike@gmail.com");
		}

		public void clickContinue() throws Exception {
			click(continueButton);
		}

		public void Checkout() throws Exception {
			click(CheckoutButton);
		}

		public void ClickSaveButton() throws Exception {
			click(SaveButton);
		}

		public void PlaceOrder() throws Exception {
			click(PlaceOrderButton);
		}
		public void ShippingAddress() throws IOException {
			GiveInputToField("First name", "Mike");
			GiveInputToField("Last name", "David");
			GiveInputToField("Street address", "Barton Springs");
			GiveInputToField("Unit, apt, suite, etc.", "1212");
			GiveInputToField("City", "Austin");
			selectOptionFromDropDown(SelectState, "TX");
			GiveInputToField("Zip code", "78702");
			GiveInputToField("Phone number", "5124563456");
		}

		public void randomShippingAddress() throws IOException {
			Random random = new Random();

			String[] stringData = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

			int[] numericData = {1,2,3,4,5,6,7,8,9};
			String[] stateData = {"AK","AL","AR","AS","AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "GU","HI", "IA", "ID", "IL", "IN","KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS","MT",
					"NC","ND","NE","NH","NJ","NM","NV","NY","OH","OK","OR","PA","PR","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};


			String address ="";

			for(int i=0; i<3; i++){
				int select = random.nextInt(numericData.length);
				address += numericData[select];
			}
			address = address + " ";

			for(int i=0; i<10; i++){
				int select = random.nextInt(stringData.length);
				address += stringData[select];
			}


			String zipCode = "";
			String state = "";

			for(int i=0; i<5; i++){
				int select = random.nextInt(stringData.length);
				zipCode += numericData[select];
			}

			int select = random.nextInt(stateData.length);
			state += stateData[select];

			GiveInputToField("First name", "Mike");
			GiveInputToField("Last name", "David");
			GiveInputToField("Street address", address);
//			GiveInputToField("Unit, apt, suite, etc.", "1212");
			GiveInputToField("City", "Austin");
			selectOptionFromDropDown(SelectState, state);
			GiveInputToField("Zip code", zipCode);
			GiveInputToField("Phone number", "5124563456");

		}

		public void accountDetails() {
			GiveInputToField("First Name", "Mike");
			GiveInputToField("Last Name", "David");
			GiveInputToField("Passwords", "Password");
		}
	

	public void placeOrder() throws IOException, InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();

	}

public boolean verifyThankYouOrderNumberDisplayed() throws IOException, InterruptedException {
	String orderIDText = wait.until(ExpectedConditions.visibilityOfElementLocated(orderID)).getText();


//	String [] s = orderID.split("#");
//	System.out.println(s[0]);
//	if  (s.length<2) {
//		Log.info("Order ID Number is Missing");
//		return false;
//	}
//	Log.info(s[1]);
Log.info(orderIDText);
System.out.print(orderIDText);
	return isDisplayed(orderID);
	}

}
