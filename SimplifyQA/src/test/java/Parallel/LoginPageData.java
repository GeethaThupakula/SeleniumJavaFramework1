package Parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.factory.DriverFactory;
import com.page.LoginPage;

import Utilies.ExcelReader;
import io.cucumber.java.en.Given;

public class LoginPageData {
	
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());

	@Given("the user enters a valid {string} and {int}")
	public void the_user_enters_a_valid_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
	   
		
		ExcelReader reader = new ExcelReader();
	    // Use the path provided in your request
	    List<Map<String,String>> testData = reader.getData("C:/Users/geetha.t/TestdataExcelSelenium.xlsx", SheetName);

	    // 2. Extract the data for the specified row
	    String username = testData.get(Rownumber).get("username");
	    String companyname = testData.get(Rownumber).get("companyname");
	    String password = testData.get(Rownumber).get("password");

	    // 3. Perform the action using the LoginPage object
	    // Assuming your LoginPage has a method to input credentials:
	    loginPage.invalidlogin(username, companyname, password);
	   
	}
	
	
}
