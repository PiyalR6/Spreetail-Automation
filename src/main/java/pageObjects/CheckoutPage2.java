package pageObjects;

import com.util.Dynamic;
import coreClasses.BasePageObject;
import coreClasses.BaseTestScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CheckoutPage2 extends BaseTestScript {
    BasePageObject basePageObject = new BasePageObject(driver);
    public CheckoutPage2(){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Spreetail')]")
    public WebElement VerifyHeader;

    @FindBy(xpath = "//h5[@class='section-title']")
    public WebElement VerifySectionTitle;

    @FindBy(xpath ="//input[@type='Email Address']" )
    public WebElement email;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueButton;

    @FindBy(xpath = "//button[contains(text(),'Create Account & Checkout')]")
    public WebElement CheckoutButton;

    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    public WebElement PlaceOrderButton;

    @FindBy(xpath = "//button[contains(text(),'Save & Continue')]")
    public WebElement SaveButton;

    @FindBy(xpath = "//input[@placeholder='%s']")
    public By DynamicInputByPlaceHolder;

    @FindBy(xpath = "//select[@class='level-item']")
    public By SelectState;




    public Boolean verifyHeader() throws Exception {
        if (VerifyHeader.isDisplayed()) {
            return true;
        } else {
            System.out.println("User is not able to See VerifyHeader");
            return false;
        }
    }

    public Boolean verifyHeader2() throws Exception {
        if (VerifySectionTitle.isDisplayed()) {
            return true;
        } else {
            System.out.println("User is not able to See VerifySectionTitle");
            return false;
        }
    }

}
