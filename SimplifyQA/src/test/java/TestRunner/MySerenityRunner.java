package TestRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)   // ✅ Needed for JUnit to run Cucumber
@CucumberOptions(
    features = { "src/test/resources/Parallel/LoginPage.feature"},   // Path to your feature files
    glue = {"Parallel"},  // Step definitions and hooks
    		plugin = {"pretty"}
)



public class MySerenityRunner {

}
