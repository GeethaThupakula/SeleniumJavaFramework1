package Parallel;

import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import com.factory.DriverFactory;
import com.page.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageStep {

 private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
 private static String title;
 private static String profilename;
 private static String invalidmessage;
	
	
@Given("the user is on the SimplifyQA login page")
public void the_user_is_on_the_simplify_qa_login_page() {
 DriverFactory.getDriver().get("https://qa.simplifyqa.com/login");
 
}

@Then("page title should be {string}")
public void page_title_should_be(String expectedtitleName) {
    title=loginPage.getLoginPageTitle();
    System.out.println("Title Page name is :"+title);
   Assert.assertTrue(title.contains(expectedtitleName));
}


@Given("the user enters a valid username and password and companyname")
public void the_user_enters_a_valid_username_and_password_and_companyname() {
   loginPage.enterusernamecompanyandpassword();
	
}

@When("clicks on the login button")
public void clicks_on_the_login_button() {
   loginPage.clickOnLogin();	
}

@Then("I should be loggged in successfully and validate profile name {string}")
public void i_should_be_loggged_in_successfully_and_validate_profile_name(String expectedprofileName) {
	 profilename=loginPage.profile();
	    System.out.println("Title Page name is :"+profilename);
	   Assert.assertTrue(profilename.contains(expectedprofileName));
}

@Then("Logout from the Application")
public void logout_from_the_application() {
    loginPage.logout();
}

@Given("the user enters a valid {string} and {string} and {string}")
public void the_user_enters_a_valid_and_and(String username, String companyname, String password) {
   loginPage.invalidlogin(username, companyname, password);
}

@Then("I should see an error message indicated {string}")
public void i_should_see_an_error_message_indicated(String errormessage) {
   invalidmessage=loginPage.errorMessage();
   System.out.println("Error Message for invalid credentials name is :"+invalidmessage);
   Assert.assertTrue(invalidmessage.contains(errormessage));
}

	
}
