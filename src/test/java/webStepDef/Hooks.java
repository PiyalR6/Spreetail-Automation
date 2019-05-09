package webStepDef;

import coreClasses.BaseTestScript;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        // only takes a screenshot if the scenario fails
        if (scenario.isFailed()) {
            // taking a screenshot
            final byte[] screenshot = ((TakesScreenshot) BaseTestScript.driver).getScreenshotAs(OutputType.BYTES);
            // adding the screenshot to the report
        scenario.embed(screenshot, "image/png");
         }
        BaseTestScript.driver.quit();
    }
}
