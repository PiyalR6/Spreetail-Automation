package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class RegistrationPage extends BasePageObject {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
public void registrationPage() throws IOException {
	sendkeys(By.id("ad-first-name"),"Piyal");
	sendkeys(By.id("ad-last-name"),"Kamal");
	click(By.xpath("//button[contains(text(),'Save & Continue')]"));
	
	
	

}

}
