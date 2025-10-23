package com.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	

	
	//1)By Locator
	private By emailId=By.xpath("//input[@name='email']");
	private By companyName=By.xpath("//div[@class='login-input']");
	private By companyselect=By.xpath("//ul[@class='dropdown-menu login_dropdown custDropdown w-100 show']//li[text()=' SQA Test ']");
	private By signin=By.xpath("//button[@type='submit']");
	private By continuebutton=By.xpath("//button[@type='button']");
	private By passwords=By.xpath("//input[@name='password']");
	private By profile=By.xpath("//div[text()=' G ']");
	private By logout=By.xpath("//div[text()='Log out']");
	private By profilenames=By.xpath("//div[@class='profile-email']");
	private By errorMessage=By.xpath("//span[text()='Invalid credentials!']");
	
	
	//2.constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3.page actions: features(behaviour) of the page the form of methods
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterusernamecompanyandpassword() {
		driver.findElement(emailId).sendKeys("geetha.t@simplify3x.com");
		driver.findElement(signin).click();
		driver.findElement(companyName).click();
		driver.findElement(companyselect).click();
		driver.findElement(continuebutton).click();
		driver.findElement(passwords).sendKeys("GEEtha!@#12");
	}
	
	public void clickOnLogin() {
		driver.findElement(signin).click();
	}
	
	public String profile() {
		driver.findElement(profile).click();
		WebElement profileText=driver.findElement(profilenames);
		String profilename=profileText.getText();
		return profilename;
	}
	
	public void logout() {
		driver.findElement(profile).click();
		driver.findElement(logout);
	}
	
	public void enterusername(String username) {
		driver.findElement(emailId).clear();	
		driver.findElement(emailId).sendKeys(username);
	}
	public void entercompanyname(String companyname) {
		driver.findElement(companyName).click();
		driver.findElement(companyselect).click();
	}
	 public void enterPassword(String password) {
	        driver.findElement(passwords).clear();
	        driver.findElement(passwords).sendKeys(password);
	    }
	 
	 public void invalidlogin(String username, String companyname, String password) {
		 
			enterusername(username);
			driver.findElement(signin).click();
			if (username.equals("geetha.t@simplify3x.com")) {
				entercompanyname(companyname);
				driver.findElement(continuebutton).click();
				enterPassword(password);
				driver.findElement(signin).click();
			} 
	 }
	 
	 public String errorMessage() {
		
		 WebElement errormessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Invalid credentials!']")));
		 System.out.println("Error Message: " + errormessage.getText());
		 return errormessage.getText();

	 }
	        
}
