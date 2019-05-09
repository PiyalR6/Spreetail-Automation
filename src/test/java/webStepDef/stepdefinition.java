package webStepDef;

import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import coreClasses.BaseTestScript;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AddAPaymentPage;
import pageObjects.CartPage;
import pageObjects.CategoryPage;
import pageObjects.CheckoutPage;
import pageObjects.FooterPage;
import pageObjects.GrillAccessoriesPage;
import pageObjects.GrillsAccessoriesProductListingPage;
import pageObjects.GrillsPage;
import pageObjects.HomePage;
import pageObjects.MakeAnAccountPage;
import pageObjects.MegaMenuPage;
import pageObjects.NavBarPage;
import pageObjects.PDPPage;
import pageObjects.PaymentMethodPage;
import pageObjects.ProductListingPage;
import pageObjects.ProductPageAndCheckOut;
import pageObjects.SearchPage;
import pageObjects.ShippingAddressPage;
import pageObjects.SignInPage;
import pageObjects.SignUpPage;
import pageObjects.WelcomePage;
import pageObjects.WelcomePageAndCheckOut;
import sun.security.krb5.Config;

public class stepdefinition extends BaseTestScript {
	private static Logger Log = Logger.getLogger(stepdefinition.class.getName());

	HomePage homepage;
	SearchPage searchpage;
	ProductListingPage productlistingpage;
	WelcomePage welcomepage;
	GrillsPage grillspage;
	MegaMenuPage megamenupage;
	CategoryPage categorypage;
	PDPPage pdppage;
	GrillAccessoriesPage grillaccessoriespage;
	GrillsAccessoriesProductListingPage gaplp;
	CartPage cartpage;
	MakeAnAccountPage makeanaccountpage;
	ShippingAddressPage shippingaddresspage;
	CheckoutPage checkoutpage;
	WelcomePageAndCheckOut welcome;
	NavBarPage navbarpage;
	PaymentMethodPage paymentmethodpage;
	ProductPageAndCheckOut productpageandcheckoutpage;
	SignInPage signinpage;
	SignUpPage signuppage;
	FooterPage footerpage;
	AddAPaymentPage addpaymentpage;

	
	@Given("^User on Home Page$")
	public void userIsOnHomePage() throws Throwable {
		BaseTestScript.beoferTest();
		homepage = new HomePage(BaseTestScript.driver);
		Assert.assertTrue(driver.findElement(By.xpath("//nav[@class='Header__NavigationWrapper-sc-1ryesrd-0 gOyvnw']")).isDisplayed(),"Page is Not Loaded ! ");

	}
	
	@Then("User Clicks on Log in Button$")
	public void  userClicksOnLogInButton() throws InterruptedException, IOException {
		homepage = new HomePage(BaseTestScript.driver);
		homepage.logInButton();
	}

	@Then("User Search for \"([^\"]*)\"Product$")
	public void userIsAbleSearchQuery(String searchQuery) throws InterruptedException, IOException {
		homepage = new HomePage(BaseTestScript.driver);
		homepage.searchProduct(searchQuery);
	}
	

	@And("User Clicks on Hamburger Menu$")
	public void userClicksOnHamburgerMenu() throws IOException, InterruptedException {
		homepage = new HomePage(BaseTestScript.driver);
		homepage.clickHamburgerMenu();

	}
	
	@And("User Clicks on PoolSpa$")
	public void userClicksonPoolSpa() throws IOException {
		navbarpage = new NavBarPage(BaseTestScript.driver);
		navbarpage.clickOnShopByRoomMenu();
	}

	@Given("^User can click on contact$")
	public void user_can_click() throws Throwable {
		homepage.clickContact();
	}

	@And("^User is able to submit Contact Us$")
	public void enterName() throws IOException {
		homepage.contactUs();

	}

	@When("^User Search for \"([^\"]*)\"$")
	public void searchP(String product) throws IOException {
		searchpage = new SearchPage(BaseTestScript.driver);
		searchpage.searchProductOnSearchPage(product);

	}

	@Then("User verify product$")
	public void verifyProductList() throws IOException {
		Assert.assertTrue(searchpage.verifyProductsList(), "Product is not  Visiable");

	}

	@When("User clicks on Lawn&Garen$")
	public void clickLawnGarden() throws IOException {
		homepage.clicklawnGarden();
	}

	@Then("User verify product loaded$")
	public void clickOnProductLinks() throws IOException, InterruptedException {
		productlistingpage = new ProductListingPage(BaseTestScript.driver);
		productlistingpage.clickOnFirstProduct();

	}

	@Then("User can see home page loaded$")
	public void verifySpreetail() throws IOException {
		welcomepage = new WelcomePage(BaseTestScript.driver);
		Assert.assertTrue(welcomepage.verifyWelcomePageSuccessfully(), "Welcome Page loaded succesfully ");
		Log.info(" User is able to see: Welcome Page , Spreetail , Search ,Search Button and Shopping Cart and Footer ");
	}
	
	@When("User clicks on Grills$")
	public void clickOnGrillLink() throws IOException, InterruptedException {
		grillspage = new GrillsPage(BaseTestScript.driver);
		grillspage.clickOnGrillTab();

	}

	@Then("User verify product loaded for Grills Category$")
	public void verifyGrillsList() {
		Log.info("Verify Product Loaded for Grill Category");
		grillspage.showGrillNames();

	}

	@Then("User Verify product loaded for Grill Accessories$")
	public void verifyGrillAccessories() {
		grillaccessoriespage = new GrillAccessoriesPage(BaseTestScript.driver);
		grillaccessoriespage.showGrillAccessoriesNames();

	}

	@And("User Clicks on first grill$")
	public void clickGril() throws IOException {
		productlistingpage = new ProductListingPage(BaseTestScript.driver);
		productlistingpage.clickGrill();
	}

	@And("User clicks on first product$")
	public void firstProduct() throws IOException, InterruptedException {
		productlistingpage = new ProductListingPage(BaseTestScript.driver);
		productlistingpage.clickOnFirstProduct();
	}

	@And("Close Browser$")
	public void closeBrowser() {
		BaseTestScript.tearDown();

	}

	@And("User is able to click on Icon Grills$")
	public void clickIcon() throws IOException {
		categorypage = new CategoryPage(BaseTestScript.driver);
		categorypage.clickOnIcon();

	}

	@And("Click on add to cart$")
	public void clickOnAddToCart() throws IOException, InterruptedException {
		pdppage = new PDPPage(BaseTestScript.driver);
		pdppage.clickAddToCart();

	}
	
	@And("Sign In$")
	public void userSignIn() throws IOException, InterruptedException {
		signinpage = new SignInPage(driver);
		signinpage.SignIn();
		
	}
	
	@And("Add Payment Method$")
	public void AddPaymentMethod() throws IOException {
		addpaymentpage = new AddAPaymentPage(BaseTestScript.driver);
		addpaymentpage.AddPaymentMethodPage();
		
		
	}
	
	
	
	
	@And("User Clicks on Sign Up link$")
	public void userClicksOnSignUpLink() throws IOException, InterruptedException {
		signinpage =new SignInPage(BaseTestScript.driver);
		signinpage.signUpLink();
	}
	
	@And("User Proceeds to Create Account$")
	public void userCreatesAccount() throws InterruptedException, IOException {
		signuppage =new SignUpPage(BaseTestScript.driver);
		signuppage.createAccount();
		
	}
	
	@And("Verify User Logged In Successfully$")
	public void userLoggedInSuccessfully() throws IOException, InterruptedException {
		welcomepage =new WelcomePage(BaseTestScript.driver);
		welcomepage.verifyUserLoggedInSuccessfully();
		
	}

	@When("User click first product$")
	public void clickOnFirstProduct() throws IOException, InterruptedException {
		productlistingpage = new ProductListingPage(BaseTestScript.driver);
		productlistingpage.clickOnFirstProduct();

	}

	@Then("User Verify product title displayed  in product detail page$")
	public void verifyProductTitle() throws IOException, InterruptedException {
		Log.info("Verify Product Title");
		Assert.assertTrue(productlistingpage.verifyProductName(),
				"Product Name Is NOT Displayed in Product Detail Page ");

	}

	@And("User clicks on Grill Accessories$")
	public void clickOnGrillAccessories() throws IOException, InterruptedException {
		grillaccessoriespage = new GrillAccessoriesPage(BaseTestScript.driver);
		grillaccessoriespage.clickOnGrillAccessories();
	}

	@Then("User is able to see Grills Title on the page$")
	public void userSeesGrill() throws IOException, InterruptedException {
		gaplp = new GrillsAccessoriesProductListingPage(BaseTestScript.driver);
		if (gaplp.VerifyUserIsOnGrillsPage()) {
			Log.info("User is able to see Grills Page Header");
		} else {
			Log.info("User is NOT able to see Grills Page Header");
			Assert.assertTrue(false);
		}
	}

	@And("Click on Checkout$")
	public void userClicksOnCheckout() throws IOException, InterruptedException {
		cartpage = new CartPage(BaseTestScript.driver);
		cartpage.clickOnChekout();
	}

	@And("Enter an email address$")
	public void userEntersEmail() throws InterruptedException {
		cartpage.enterEmailAddress();
	}

	@And("Click on Continue Button$")
	public void userClicksOnContinueButton() throws IOException {
		cartpage.clickOnContinue();

	}

	@And("Add Let's make an account for$")
	public void userCreatsAnAccount() throws IOException {
		makeanaccountpage = new MakeAnAccountPage(BaseTestScript.driver);
		makeanaccountpage.makeAnAccount();

	}

	@Then("Enter Shipping Address information, Save & Continue$")
	public void userFillsOutShippingInformation() throws IOException, InterruptedException {
		shippingaddresspage = new ShippingAddressPage(driver);
		shippingaddresspage.filloutShippingAddress();

	}
	
	@And("Enter Credit Card information, Save & Continue$")
	public void userEntersCreditCardInfo() throws IOException, InterruptedException {
		paymentmethodpage = new PaymentMethodPage(BaseTestScript.driver);
		paymentmethodpage.enterCreditCardInfo();
	}
	
	@Then("User enters invalid shipping information Save & Continue$")
	public void userFillsOutInvalidShippingInformation() throws IOException, InterruptedException {
		shippingaddresspage = new ShippingAddressPage(BaseTestScript.driver);
		shippingaddresspage.filloutInvalidShippingAddress();

	}
	
	@Then("User Verifies Error Message$")
	public void userValidatesErrorMessage() throws IOException {
		shippingaddresspage = new ShippingAddressPage(BaseTestScript.driver);
		if (shippingaddresspage.verifyInvalidErrorMessage()) {
			Log.info("User is getting Error Message");
		}else {
			Log.info("User is NOT getting Error Message");
			Assert.assertTrue(false);
		}
	}
		
		@Then("User Verifies Shipping Address Error message$")
		public void userIsAbleToSeeShippingAddressErrorMessage() throws IOException, InterruptedException {
			shippingaddresspage =new ShippingAddressPage(BaseTestScript.driver);
			if (shippingaddresspage.verifyInvalidFieldErrorMessage()) {
				Log.info("User is able to See Invalid Address Field Error Message when Mandatory  fields missing information");
			} else {
				Log.info("User is NOT Seeing Invalid Address Field Error Message");
				Assert.assertTrue(false);
			}
			
		}
	

	@Then("Click on Place Order$")
	public void userClicksOnPlaceOrder() throws IOException, InterruptedException {
		checkoutpage = new CheckoutPage(BaseTestScript.driver);
		checkoutpage.placeOrder();

	}

	@Then("Verify Thank you page and Order Number$")
	public void userCanSeeThankyouAndOrderNumber() throws IOException, InterruptedException {
		if (checkoutpage.verifyThankYouOrderNumberDisplayed()) {
			Log.info("User is able to see Thank you Page with order Number");
		} else {
			Log.info("User is NOT ABLE TO SEE Thank you page with order number");
			Assert.assertTrue(false);
		}
	}

	@And("User Verify Grill Product Name is Displayed$")
	public void verifyGrillsProductName() {
		if (grillspage.verifyGrillsProductNames()) {
			Log.info("User is able to see All Grills Products  Name");
		} else {
			Log.info("User is NOT ABLE TO SEE Grills Products Name");
			Assert.assertTrue(false);
		}
	}

	@And("User Verify Product Name is Displayed$")
	public void verifyGrillAccessoriesProductName() throws IOException, InterruptedException {
		grillaccessoriespage = new GrillAccessoriesPage(BaseTestScript.driver);
		if (grillaccessoriespage.verifyProductNameDisplayed()) {
			Log.info("User is able to see c Products  Name");
		} else {
			Log.info("User is NOT ABLE TO SEE User Verify Grill Product Name is Displayed Product Name");
			Assert.assertTrue(false);

		}
	}

	@And("User Clicks on Shop For$")
	public void UserClicksOnMainMenu() throws IOException {
		homepage.clickMainMenu();

	}
	
	@And("User Clicks on \"([^\"]*)\" Menu$")
	public void UserClicksOnMenus(String menus) throws IOException, InterruptedException {
		megamenupage = new MegaMenuPage(BaseTestScript.driver);
		megamenupage.clickOnMegaMenu(menus);


	}
	
	@And("User Clicks on \"([^\"]*)\"$")
	public void UserClicksOnLinks(String link) throws IOException, InterruptedException {
		footerpage = new FooterPage(BaseTestScript.driver);
		footerpage.clickOnLink(link);
	}
	
	@And("Verify User is on the right page with correct \"([^\"]*)\"$")
	public void userIsOnRightPage(String PageTitle) {
		footerpage = new FooterPage(BaseTestScript.driver);
		if (footerpage.verifyPageTitleOnNewTab(PageTitle)){
			Log.info("User is on right page with right Title");
		}else {
		Log.info("User is not able to see correct Page Title");
		Assert.assertTrue(false);
		}
	}
	@And("Close Current  window$")
	public void userClosesCurrentPage() {
		footerpage = new FooterPage(BaseTestScript.driver);
		footerpage.closeCurrentWindow();
	}
	
	


	@And("User is able to see all Menu Items$")
	public void UserSeesMegaMenu() {
		megamenupage = new MegaMenuPage(BaseTestScript.driver);
		megamenupage.printMenuName();

	}
	@And("Click On Phone Number$")
	public void UserClicksOnPhoneNumber() throws IOException, InterruptedException	{
		footerpage = new FooterPage(BaseTestScript.driver);
		footerpage.clickPhoneNumber();
		
	}
	
	@And("Verify and close Alert Pop Up$")
		public void UserVerifyPopUp() throws IOException, InterruptedException {
		footerpage = new FooterPage(BaseTestScript.driver);
		footerpage.clickPhoneNumber();
	
		
	}

	
	@Then("User Verify Mega Menu Category list order$")
	public void UserVerifyMegaMenuListOrder() throws InterruptedException {
		megamenupage = new MegaMenuPage(BaseTestScript.driver);
		if (megamenupage.verifyMegaMenuCategoryList()) {
			Log.info("User is able to see Mega Menu List in Order ");
		} else {
			Log.info("Mega Menu Category List is not in Order ");
			Assert.assertTrue(false);

		}

	}

	@And("User Clicks on Outdoor Living$")
	public void UserClicksOnOUtdoorLiving() throws IOException {
		megamenupage = new MegaMenuPage(BaseTestScript.driver);
		megamenupage.clickOnOutdoorLiving();

	}


	@And("User Clicks on Outdoor Grill Accessories$")
	public void userClicksOnGrillAccessories() throws IOException, InterruptedException {
		megamenupage.clickOutdoorGrillAccessories();

	}
	@And("User Clicks on Pool&Spa$")
	public void userClickOnPoolSpa() throws IOException	{
		megamenupage = new MegaMenuPage(BaseTestScript.driver);
		megamenupage.clickPoolSpa();
	}
	@And("User Click on Swiming Pool$")
	public void userClickOnSwimingPool() throws IOException, InterruptedException {
		megamenupage = new MegaMenuPage(BaseTestScript.driver);
		megamenupage.clickSwimingPool();
	}
	
	
	

	@Then("Click on Grills$")
	public void userClicksOnGrill() throws IOException, InterruptedException {
		megamenupage.clickGrills();

	}
	@Then("User Verify Product Quantity$")
	public void verifyProductQuantity() throws IOException, InterruptedException {
		productpageandcheckoutpage =new ProductPageAndCheckOut(BaseTestScript.driver);
		if (productpageandcheckoutpage.verifyProductQuantityMessage()){
			Log.info("User is able to see Product Quantity is More than 5 ");
		} else {
			Log.info("User is able to see Out of Stock");
			Assert.assertTrue(false);
		}	
	}
	
	
	@And("User Click on a random product$")
	public void userClicksOnRandomProduct() throws IOException, InterruptedException {
		productlistingpage = new ProductListingPage(BaseTestScript.driver);
		productlistingpage.clickOnRandomProduct();
		
	}

	@And("Click Grills and Grill Accessories$")
	public void userClicksOnGrillsGrillsAccessories() throws IOException, InterruptedException {
		megamenupage.clickGrillsGrillAcccessories();
	}

	@When("^User clicks on Grills ForCheckout$")
	public void clickonGrills() throws Throwable {
		welcome = new WelcomePageAndCheckOut(BaseTestScript.driver);
		welcome.Shopfor();
		welcome.ClickOncateogry("Outdoor Living");
		welcome.ClickOncateogry("Grills and Grill Accessories");
		welcome.ClickOncateogry("Outdoor Grill Accessories");
		welcome.clickOnProductRandomly();
	}

	@And("^User add multiple items to cart ForCheckout$")
	public void AddItems() throws Throwable {
		ProductPageAndCheckOut product = new ProductPageAndCheckOut(BaseTestScript.driver);
		product.verifyProductDetails();
		String ProductName = product.getProductName();
		Log.info("The Product name is :" + ProductName);
		String Price = product.getProductPrice();
		Log.info("The Product Price is :" + Price);
		product.ClickOnAddToCart();
		product.verifyYourBag();
		product.VerifyThePrductDetailsOnYourBag(ProductName, Price);
	}

	@Then("^User click on Checkout ForCheckout$")
	public void clickonCheckout() throws Throwable {
		ProductPageAndCheckOut product = new ProductPageAndCheckOut(BaseTestScript.driver);
		product.ClickOnCheckOut();
	}

	@And("^User add account ForCheckout$")
	public void Addaccount() throws Throwable {
		CheckoutPage CheckOutPage = new CheckoutPage(BaseTestScript.driver);
		CheckOutPage.verifyHeader();
		CheckOutPage.verifyHeader2();
		// Note This method is Used for input Field With placeHolder Attribute In this
		// First value is Placeholder value and second value is Input data.
		CheckOutPage.GiveInputToField("Email Address", "Mike@gmail.com");
		CheckOutPage.clickContinue();
		CheckOutPage.accountDetails();
		CheckOutPage.Checkout();
		CheckOutPage.ShippingAddress();
		CheckOutPage.ClickSaveButton();
		CheckOutPage.PlaceOrder();
	}

	/*
	 * @And("^Close the browser$") public void EnterUserDetails() throws Throwable {
	 * BaseTestScript.beoferTest(); homepage = new HomePage(BaseTestScript.driver);
	 * }
	 */



	// I am going to fix this code
	@Given("^Enter random Shipping Address city state and zipcode information, Save & Continue$")
	public void enter_random_Shipping_Address_city_state_and_zipcode_information_Save_Continue() throws Throwable {

		Random random = new Random();

		String[] stringData = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

		int[] numericData = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		String[] stateData = {"AK", "AL", "AR", "AS", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT",
				"NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VI", "VT", "WA", "WI", "WV", "WY"};

		int count =0;
		for (int j = 0; j < 100; j++) {
		WebDriverWait wait = new WebDriverWait(driver, 20);

			String address = "";

			for (int  i= 0; i < 3; i++) {
				int select = random.nextInt(numericData.length);
				address += numericData[select];
			}
			address = address + " ";

			for (int i = 0; i < 10; i++) {
				int select = random.nextInt(stringData.length);
				address += stringData[select];
			}


			String zipCode = "";
			String state = "";

			for (int i = 0; i < 5; i++) {
				int select = random.nextInt(numericData.length);
				zipCode += numericData[select];
			}

			int select = random.nextInt(stateData.length);
			state += stateData[select];

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='Typography__DivText-rz6iur-4 Typography__SBodyDiv-rz6iur-23 HeaderCategoryMenu__HeaderCatItem-sc-1a3ly1o-2 HeaderCategoryMenu__MenuItem-sc-1a3ly1o-4 JNXBC']")))).click();

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@title='outdoor-living']")))).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'Grills, Smokers & Grill Accessories')]")))).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href='/bull-outdoor-products-bop-26038-bull-outdoor-products-liquid-propane-outlaw-drop-in-steel-barbecue-grill-head/T6WXMO9MOQX0M9M/p']" +
					"//div[@type='cdp']//div[@type='cdp']//span[@id='product-title']//span[@class='ProductCard__ProductTitle-sc-1ihkjx9-3 kpqDYV']" +
					"//b[contains(text(),'Bull Outdoor Products')]"))));
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/bull-outdoor-products-bop-26038-bull-outdoor-products-liquid-propane-outlaw-drop-in-steel-barbecue-grill-head/T6WXMO9MOQX0M9M/p']" +
					"//div[@type='cdp']//div[@type='cdp']//span[@id='product-title']//span[@class='ProductCard__ProductTitle-sc-1ihkjx9-3 kpqDYV']" +
					"//b[contains(text(),'Bull Outdoor Products')]")))).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='Product__ProductListingWrapper-o90kst-0 cACWNG']//button[@type='button']")))).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='product-remove QuantityController__TrashWrapper-sc-13hcs76-4 Nolgs']"))));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")))).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("okta-signin-username")))).sendKeys("test@test.com");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("okta-signin-password")))).sendKeys("spreetail");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("okta-signin-submit")))).click();

			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='address-first-name']")))).sendKeys("TestUserName");
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='address-last-name']")))).sendKeys("TestuserLastName");
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='address-street']")))).sendKeys(address);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='address-zip']")))).sendKeys(zipCode);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='address-city']")))).sendKeys("Austin");

			Select dropdown = new Select(driver.findElement(By.xpath("//select[@title='state select field with options']")));
			dropdown.selectByVisibleText(state);

			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='address-phone']")))).sendKeys("2232322323");
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'Save & Continue')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("address-full-name")))).sendKeys("Mike Mike");

			driver.switchTo().frame("__privateStripeFrame4");

			driver.findElement(By.name("cardnumber")).sendKeys("4242 4242 4242 4242" + "1024" + "222");
			driver.switchTo().defaultContent();

			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@type='submit']")))).click();

			count++;

			System.out.println(count +". purchase has been made");
			System.out.println(address);
			System.out.println(zipCode);
			System.out.println(state);
//
//			driver.manage().deleteAllCookies();
			driver.quit();
			driver = setUp();
			driver.get("http://dev.spreetest.com/");
			driver.manage().deleteAllCookies();
		}

		System.out.println(count+ " purchase has been complated with differnet addresses and zip codes");
	}


	@Then("^User types \"([^\"]*)\" in searchbox$")
	public void user_types_in_searchbox(String userText) throws Throwable {
		SearchPage searchpage = new SearchPage(driver);
		searchpage.sendInputToSearchBox(userText);
	}

	@Then("^User should see dropdown menu after typing four letters$")
	public void user_should_see_dropdown_menu_after_typing_letters() throws Throwable {
		SearchPage searchpage = new SearchPage(driver);
		searchpage.verifyDropDownList();
	}

	@Then("^Verify when randomly one element is clicked, results match with selected dropdown$")
	public void verify_when_randomly_one_element_is_clicked_results_match_with_selected_dropdown() throws Throwable {
		SearchPage searchpage = new SearchPage(driver);
		searchpage.verifyWhenRandomlyOneElementIsClickedResultsMatchWithSelectedDropdown();
	}

	@When("^User Search for \"([^\"]*)\", result must match with user's input$")
	public void user_Search_for_result_must_match_with_user_s_input(String searchText) throws Throwable {
		SearchPage searchpage = new SearchPage(driver);
		searchpage.whenUserSearchForItemResultMustMatchWithUsersInput(searchText);
	}

	@Then("^User must see an error$")
	public void user_must_see_an_error() throws Throwable {
		SearchPage searchpage = new SearchPage(driver);
		searchpage.noResultsError();
	}

	@Then("^User Clicks on \"([^\"]*)\" from filter menu$")
	public void user_Clicks_on_from_filter_menu(String filterMenuText) throws Throwable {
		ProductListingPage productListingPage = new ProductListingPage(driver);
		productListingPage.clickOnItemFromFilterTitle(filterMenuText);
	}

	@Then("^User Clicks on \"([^\"]*)\" from filter$")
	public void user_Clicks_on_from_filter(String subFilterText) throws Throwable {
		ProductListingPage productListingPage = new ProductListingPage(driver);
		productListingPage.clickOnItemFromFilterSubTitle(subFilterText);
	}

	@Then("^Verify all products sorted low price to high price$")
	public void verify_all_products_sorted_low_price_to_high_price() throws Throwable {
		ProductListingPage productListingPage = new ProductListingPage(driver);
		productListingPage.verifyAllProductsSortedLowToHigh();
	}

	@Then("^Verify all products sorted high price to low price$")
	public void verify_all_products_sorted_high_price_to_low_price() throws Throwable {
		ProductListingPage productListingPage = new ProductListingPage(driver);
		productListingPage.verifyAllProductsSortedHighToLow();
	}

	@Then("^Verify all products sorted \"([^\"]*)\"$")
	public void verify_all_products_sorted(String verifyingText) throws Throwable {
		ProductListingPage productListingPage = new ProductListingPage(driver);
		if(verifyingText.equals("High to Low")){
			productListingPage.verifyAllProductsSortedHighToLow();
		}else if(verifyingText.equals("Low to High")){
			productListingPage.verifyAllProductsSortedLowToHigh();
		}else{
			Assert.fail("Text in feature file is not either Low to High or High to Low");
		}
	}


	@Then("^Verify all products are \"([^\"]*)\" brand\\.$")
	public void verify_all_products_are_brand(String brandNames) throws Throwable {
		ProductListingPage productListingPage = new ProductListingPage(driver);
		productListingPage.verifyProductBrand(brandNames);
	}

	@Given("^User Clicks on brand name and verifies all products has expected brand name$")
	public void user_Clicks_on_brand_name_and_verifies_all_products_has_expected_brand_name() throws Throwable {
		PDPPage pdpPage = new PDPPage(driver);
		pdpPage.clickonBrandNameAndVerifyResult();
	}

	@Then("^User selects random brand from filter$")
	public void user_selects_random_brand_from_filter() throws Throwable {

		ProductListingPage productListingPage = new ProductListingPage(driver);
		productListingPage.selectsRandomBrandFromFilter();
	}



	@Then("^Verify all products are selected brand$")
	public void verify_all_products_are_selected_brand() throws Throwable {

		ProductListingPage productListingPage = new ProductListingPage(driver);
		productListingPage.verifyAllProductsAreSelectedBrand();

	}

}
