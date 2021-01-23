package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pom.FlightBookingPOM;

public class Base {
	public static WebDriver driver;
	public FlightBookingPOM flightBooking;
	
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser) throws Exception {
		if(browser.equalsIgnoreCase("chrome"))
{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/Driver/chromedriver.exe");
		    driver=new ChromeDriver();
		    driver.get("https://www.cleartrip.com/");
		    driver.manage().window().maximize();
		    Thread.sleep(100);
}
}
		
@AfterTest
public void afterTest()
		{
			//driver.quit();
		}	




}
