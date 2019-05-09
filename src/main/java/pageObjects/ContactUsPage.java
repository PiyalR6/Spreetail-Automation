package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class ContactUsPage extends BasePageObject {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 public void  doContact() {
		 sendkeys(By.xpath("//input[@id='mat-input-0'"), "Piyal kamal");
		sendkeys(By.xpath("//input[@id='mat-input-5"), "piyal.kamal@spreetail.com");
		sendkeys(By.xpath("//input[@id='mat-input-6']"), "512-666-666");
		sendkeys(By.xpath("//input[@id='mat-input-7']"), "I am just Testing" );
		//click.(By.xpath("//button[@type='submit']"));
		
	
		 
	 }

		
	}

