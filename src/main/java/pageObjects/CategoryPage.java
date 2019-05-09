package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class CategoryPage extends BasePageObject {
	By ClickIcon = By.xpath("//a[@href='/product/B54D52CC43E2CC6939334DB1A435520D']//div[@class='container wrapper']");

	public CategoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickOnIcon() throws IOException {
		click(ClickIcon);
		
	}
	
	
}
