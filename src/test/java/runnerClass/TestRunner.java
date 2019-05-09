package runnerClass;



import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/FunctionalTest", glue= {"webStepDef"},
tags= {"@AddingSingleProductCheckout"}, plugin = { "pretty", "html:target/cucumber-reports","json:target/cucumber.json"}, dryRun = false
)
public class TestRunner {

}


 