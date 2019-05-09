package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabs {
	
	public static final String USERNAME = "piyal.kamal@spreetail.com";
	  public static final String ACCESS_KEY = "0cfc0c35-7ca2-4474-be0f-77d57ef84226";
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	 
	  public static void main(String[] args) throws Exception {
	 
	    DesiredCapabilities caps = DesiredCapabilities.chrome();
	    caps.setCapability("platform", "Windows 10");
	    caps.setCapability("version", "latest");
	 
	    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	 
	    /**
	     * Goes to Sauce Lab's guinea-pig page and prints title
	     */
	    
	    
	    driver.get("https://www.spreetaildemo.com/");
	    System.out.println(driver.getTitle());
	    driver.findElement(By.name("serachparam")).sendKeys("Lawn");
	 
	    driver.get("https://saucelabs.com/test/guinea-pig");
	    System.out.println("title of page is: " + driver.getTitle());
	 
	    driver.quit();
	  }
	}


