package coreClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
//import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.GrillAccessoriesPage;

@SuppressWarnings("unused")
public class BasePageObject {
	private static Logger Log = Logger.getLogger(BasePageObject.class.getName());

	String APPLICATION_URL;
	protected WebDriver driver;
	Actions build;
	Alert alert;
	String testUrl;

	public static int Seconds = 15;

	public BasePageObject(WebDriver driver) {

		this.driver = driver;

		build = new Actions(driver);

	}

	public void click(By by) throws IOException {
		try {
			WebElement element = driver.findElement(by);
			getHighlightElement(element); // highligts
			build.moveToElement(element).click().perform();

		} catch (NoSuchElementException e) {
			driver.findElement(by).click();
		} catch (Exception e) {
			Assert.fail("Fail to click on link : " + by + " on page : " + e.getMessage());

		}
	}

	public void getHighlightElement(final WebElement element) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, 10);
			// Wait for search to complete
			wait.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver webDriver) {
					return element != null;
				}
			});
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid red'", element);
		} catch (Exception e) {
			Log.info("Fail to highlight the Element");
		}

	}

	public void timeinterval(int i) throws InterruptedException {
		Thread.sleep(1000 * i);

	}

	public void sendkeys(By by, String keys) {
		getHighlightElement(driver.findElement(by));
		driver.findElement(by).sendKeys(keys);
	}

	public void navigatetoURL() throws IOException {
		APPLICATION_URL = spreetailProperties.getInstance().getProperty("qa_DEV_URL").trim();
		driver.navigate().to(APPLICATION_URL);

	}

	public void selectOptionFromDropDown(By by, String option) throws IOException {

		waitForParticularElement(by, Seconds);
		Select select_list = null;
		try {
			moveToElement(by);
			select_list = new Select(driver.findElement(by));
			select_list.selectByVisibleText(option);
		} catch (NoSuchElementException e) {
			Assert.fail("Fail to find drop down box to select option : " + by + " on page : " + e.getMessage());
		} catch (Exception e) {
			Log.warn("Fail to select option : " + e.getMessage());
		}
	}



	public void waitForParticularElement(final By element, int waitForSeconds) throws IOException {
		int i = 1;
		do {
			try {
				driver.findElement(element).isDisplayed();

				break;
			} catch (Exception e) {

				i++;
				System.out.println("waiting for element : " + element.toString() + " :  Waiting Time [ " + i
						+ " ] out of " + waitForSeconds);
			}
		} while (i <= waitForSeconds);
	}

	public void moveToElement(By by) throws IOException {
		WebElement element;

		try {
			element = driver.findElement(by);
			getHighlightElement(driver.findElement(by));
			build.moveToElement(element).build().perform();
		} catch (NoSuchElementException e) {

		} catch (Exception e) {

		}
	}

	public void moveToElement(List<WebElement> webElements,int elementIndex) throws IOException {
		WebElement element = webElements.get(elementIndex);
		try {
			build.moveToElement(element).build().perform();
		} catch (NoSuchElementException e) {

		} catch (Exception e) {

		}
	}

	public boolean isDisplayed(By by) throws IOException {
		try {
			moveToElement(by);
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			System.out.println("Exception 2:" + e);
		}
		return false;
	}

	public String getAttributeValue(By by){
		try {
			return driver.findElement(by).getAttribute("value");
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println("Exception 2:" + e);
		}
		return "";
	}

	public List<WebElement> getlistofelement(By by) {
		return driver.findElements(by);
	}

	public String getText(By by) throws IOException, InterruptedException {
		waitForParticularElement(by, Seconds);
		try {
			getHighlightElement(driver.findElement(by));
			return driver.findElement(by).getText().trim();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Fail to get text value from : " + by + " on page:" + e.getMessage());

		} catch (Exception e) {
			Log.info(e.getMessage());

		}
		return null;
	}
	
public void switchToIframe(String Name) {
	driver.switchTo().frame(Name);
}
public void switchToDefaultContent() {
	driver.switchTo().defaultContent();
}
public void closeCurrentWindow() {
	driver.close();
}
public boolean isEnable(By by) throws IOException {
	waitForParticularElement(by, Seconds);
	getHighlightElement(driver.findElement(by));
	return driver.findElement(by).isEnabled();
}

public void scrollDown() {
	((JavascriptExecutor) driver).executeScript("scroll(0,6000);");	
	
}

public void scrollElementIntoView(By by) throws InterruptedException {
	timeinterval(4);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(by));

	
}
public void navigateBack() {
	driver.navigate().back();
	
}

public void cancelPopUp() {
	driver.switchTo().alert().dismiss();
	
}

public String getAlertText() {
	Alert alert = driver.switchTo().alert();
	return alert.getText();

	
}
public void openNewTab() {
	  String a = "window.open('about:blank','_blank');";
	  ((JavascriptExecutor)driver).executeScript(a);

	 }
	 
	 public void openNewTab (String URL) {
	    String a = "window.open('"+URL+"','_blank');";
	    ((JavascriptExecutor)driver).executeScript(a);
	   }
	   
	   public void switchToWindow(int i ) {
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    System.out.println(tabs);
	          driver.switchTo().window(tabs.get(i));
	   }
	   
	   public void swichToIFrame(String nameOrId) {
	   driver.switchTo().frame(nameOrId);
	   }
	   public String getPageTitle() {
		   return driver.getTitle();
	   }
	   }
	


