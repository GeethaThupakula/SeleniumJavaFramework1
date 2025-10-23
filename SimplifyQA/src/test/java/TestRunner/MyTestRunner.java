package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)   // ✅ Needed for JUnit to run Cucumber
@CucumberOptions(
    features = "src/test/resources/Features",   // Path to your feature files
    glue = {"Stepdefinitions", "AppHooks"},  // Step definitions and hooks
    		plugin = {
    			    "pretty",
    			    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
    			    "timeline:test-output-thread/"
    			}
)



public class MyTestRunner {

	
	
}
