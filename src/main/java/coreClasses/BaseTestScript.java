package coreClasses;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Driver;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTestScript {

	public static WebDriver driver;

	static String APPLICATION_URL;

	public static final String USERNAME = "PIyalKamal";
	public static final String ACCESS_KEY = "69fb453b-9811-4213-a6bd-77d45360b61a";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	// builds a new report using the html template

	static ExtentHtmlReporter htmlReporter;

	public static ExtentReports extent;

	// helps to generate the logs in test report.

	public ExtentTest test;

	@BeforeSuite

	public void beforesuite() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/testReport.html");

		// initialize ExtentReports and attach the HtmlReporter

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		// To add system or environment info by using the setSystemInfo method.

//                    extent.setSystemInfo("OS", OS);

//                    extent.setSystemInfo("Browser", browser);

		// configuration items to change the look and feel

		// add content, manage tests etc

		htmlReporter.config().setChartVisibilityOnOpen(true);

		htmlReporter.config().setDocumentTitle("Extent Report Demo");

		htmlReporter.config().setReportName("Test Report");

		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);

		htmlReporter.config().setTheme(Theme.STANDARD);

		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	}

	@BeforeTest
	public static void beoferTest() throws IOException {
		driver = setUp();
		driver.navigate().to("http://uat.spreetest.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static WebDriver setUp() throws MalformedURLException {
		System.out.println(System.getProperty("browserName"));
		if (System.getProperty("browserName") == null) {

		/*	DOMConfigurator.configure("log4j.xml");
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("deviceName", "Google Nexus 7 HD Emulator");
			caps.setCapability("version", "latest");
			return new RemoteWebDriver(new java.net.URL(URL), caps);*/
			
			System.setProperty("webdriver.chrome.driver", "./bin/chromedriver.exe");
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.addArguments("disable -extensions");
			chromeoptions.addArguments("--start-maximized");
			return new ChromeDriver(chromeoptions);

		} else if (System.getProperty("browserName").equalsIgnoreCase("localchrome")) {
			DOMConfigurator.configure("log4j.xml");
			System.setProperty("webdriver.chrome.driver", "./bin/chromedriver.exe");
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.addArguments("disable -extensions");
			chromeoptions.addArguments("--start-maximized");
			return new ChromeDriver(chromeoptions);
		} else if (System.getProperty("browserName").equalsIgnoreCase("localfirefox")) {
			System.setProperty("webdriver.gecko.driver", "./bin/geckodriver.exe");
			FirefoxOptions firefoxoptions = new FirefoxOptions();
			firefoxoptions.addArguments("disable -extensions");
			firefoxoptions.addArguments("--start-maximized");
			return new FirefoxDriver(firefoxoptions);
		} else if (System.getProperty("browserName").equalsIgnoreCase("localie")) {
			System.setProperty("webdriver.ie.driver", "./bin/IEDriverServer.exe");
			InternetExplorerOptions ieoptions = new InternetExplorerOptions();
			/*
			 * ieoptions.addArguments("disable -extensions");
			 * ieoptions.addArguments("--start-maximized");
			 */
			return new InternetExplorerDriver(ieoptions);

		} else if (System.getProperty("browserName").equalsIgnoreCase("SauceLabsNexus7")) {
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("deviceName", "Google Nexus 7 HD Emulator");
			caps.setCapability("version", "latest");
			return new RemoteWebDriver(new java.net.URL(URL), caps);

		} else if (System.getProperty("browserName").equalsIgnoreCase("SauceLabsGalaxyS8")) {
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("deviceName", "Galaxy S8 GoogleAPI Emulator");
			caps.setCapability("version", "latest");
			//caps.setCapability("platformName", "Android");
			return new RemoteWebDriver(new java.net.URL(URL), caps);
		} else {

			DOMConfigurator.configure("log4j.xml");
			System.setProperty("webdriver.chrome.driver", "./bin/chromedriver.exe");
			ChromeOptions dchromeoptions = new ChromeOptions();
			dchromeoptions.addArguments("disable -extensions");
			dchromeoptions.addArguments("--start-maximized");
			return new ChromeDriver(dchromeoptions);
		}

	}


	@AfterMethod

	public void getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));

			test.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));

		} else {

			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));

			test.skip(result.getThrowable());

		}


	}

	@AfterTest
	public static void tearDown() {
		driver.quit();

	}


}