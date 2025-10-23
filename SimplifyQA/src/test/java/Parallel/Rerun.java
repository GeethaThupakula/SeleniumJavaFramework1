package Parallel;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)   // ✅ Needed for JUnit to run Cucumber
@CucumberOptions(
    features = { "@target/failedrun.txt"},   // Path to your feature files
    glue = {"Parallel"},  // Step definitions and hooks
    		plugin = {"pretty",
    			    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
    			    "timeline:test-output-thread/",
    			    "rerun:target/failedrerun.txt"
    			} 
)

public class Rerun extends  AbstractTestNGCucumberTests {
	
	  @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    } 

}
