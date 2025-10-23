	package com.factory;
	
	import java.time.Duration;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.safari.SafariDriver;
	
	import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class DriverFactory {
	
		
		public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
		
		public WebDriver init_driver(String browser) {
			System.out.println("browser value is: "+ browser);
			
			if(browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				tlDriver.set(new ChromeDriver());
			}
			else if(browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				tlDriver.set(new FirefoxDriver());
			}
			else if(browser.equals("safari")) {
				tlDriver.set(new SafariDriver());
			}
			else {
				System.out.println("please pass the current browser value : "+browser);
			}
			
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return getDriver();
			
		}
		
		//to get the driver
		public static synchronized WebDriver getDriver() {
			return tlDriver.get();
		}
		
		
		
	}
