package pom;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

import utils.Base;

public class FlightBookingPOM extends Base{
	 public FlightBookingPOM(WebDriver driver)
	 {
		 this.driver=driver;
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
	 
	 DateFormat  dateformat;
	 public Assert assertion;
	 WebDriverWait wait = new WebDriverWait(driver,30);
	 JavascriptExecutor executor = (JavascriptExecutor) driver;
	 Date openEnrollmentStartDate_date;
	 By RoundTrip=By.xpath("//input[@id='RoundTrip']");
	 By Origin=By.xpath("//input[@name='origin']");
	 By Destination=By.xpath("//input[@name='destination']");
	 By Departure=By.xpath("//input[@title='Depart date']");
	 By Return=By.xpath("//input[@id='ReturnDate']");
	 By SearchFlights=By.xpath("//input[@id='SearchBtn']");
	 By AirAsia=By.xpath("//p[text()=\"Air Asia\"]");
	 By GoAir=By.xpath("//p[text()=\"GoAir\"]");
	 By SpiceJet=By.xpath("//p[text()=\"SpiceJet\"]");
	 By Vistara=By.xpath("//p[text()=\"Vistara\"]");
	 By Book=By.xpath("//button[text()=\"Book\"]");
	 By Fee=By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/main/div[2]/div/div/div[25]/div[1]/div");
	 By Continue=By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[33]/div[1]/button[1]");
	 By PhoneNumber=By.xpath("//input[@placeholder='Mobile number']");
	 By EmailId=By.xpath("//input[@placeholder='Email address']");
	 By ContinueDetails=By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[5]/div[1]/div[1]/div[7]/button[1]");
	 By FirstName=By.xpath("//input[@placeholder='First name']");
	 By LastName=By.xpath("//input[@placeholder='Last name']");
	 By ContinuePayment=By.xpath("//button[text()=\"Continue to payment\"]");
	 By itinerary=By.cssSelector("span[class='c-neutral-900 mx-4  fw-700 flex flex-right fs-7']");
	 protected String rate;
	 By itinerarybook=By.cssSelector("p[class='fs-6 fw-700']");
	 By gender=By.xpath("//div[text()=\"Gender\"]");
	 By male=By.xpath("//li[text()=\"Male\"]");
	 By itinerarydetails=By.xpath("//p[text()=\"Flight itinerary\"]");
	 public void HomePage() throws Exception
	 {
		 
		 try
	 {
		wait.until(ExpectedConditions.visibilityOfElementLocated(RoundTrip));
		 driver.findElement(RoundTrip).click();
		 driver.findElement(Origin).sendKeys("Mumbai, IN - Chatrapati Shivaji Airport (BOM)");
		 driver.findElement(Destination).sendKeys("Chennai, IN - Chennai Airport (MAA)");
		 Robot rob=new Robot();
		 rob.keyPress(KeyEvent.VK_TAB);
		 Date currentDate = new Date();
         dateformat = new SimpleDateFormat("dd/MM/yyyy");
         Calendar c1 = Calendar.getInstance();
         c1.setTime(currentDate);
         c1.add(Calendar.DATE, 2);
         openEnrollmentStartDate_date = c1.getTime();
         String departure = dateformat.format(openEnrollmentStartDate_date);
         driver.findElement(Departure).sendKeys(departure);
         Calendar c2 = Calendar.getInstance();
         c2.add(Calendar.DATE, 5);
         openEnrollmentStartDate_date = c2.getTime();
         String arrival = dateformat.format(openEnrollmentStartDate_date);
         driver.findElement(Return).clear();
         driver.findElement(Return).sendKeys(arrival);
		 rob.keyPress(KeyEvent.VK_TAB);
		 executor.executeScript("arguments[0].click();", driver.findElement(SearchFlights));
	 }
		 	 
	 catch(Exception e){
		 System.out.println("Error while Searching for flights");
	 }
	 }
		public void flightPage() throws Exception
		{
			try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(AirAsia));	
			 executor.executeScript("arguments[0].click();", driver.findElement(AirAsia));
			 executor.executeScript("arguments[0].click();", driver.findElement(GoAir));
			 executor.executeScript("arguments[0].click();", driver.findElement(SpiceJet));
			 executor.executeScript("arguments[0].click();", driver.findElement(Vistara));
			 rate=driver.findElement(itinerary).getText();
			 System.out.println("enter:"+rate);
			 driver.findElement(Book).click();
			
		}
		
			catch(Exception e)
			{
				System.out.println("could not select flights");
			}
		}
		
		public void BookTicket() throws Exception
		{
			
				
				  for(String winHandle : driver.getWindowHandles())
				  {
				  driver.switchTo().window(winHandle);
				  }
				    for (String handle1 : driver.getWindowHandles())
				 { 
				  driver.switchTo().window(handle1);
				 }
				wait.until(ExpectedConditions.visibilityOfElementLocated(itinerarybook));
				//Verifying if the same flight is booked
				String ratebook=driver.findElement(itinerarybook).getText();
				System.out.println("enter:"+ratebook);
				Assert.assertEquals(rate.equals(ratebook), true);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				 executor.executeScript("arguments[0].click();", driver.findElement(Fee));
				 executor.executeScript("arguments[0].click();", driver.findElement(Continue));
				 wait.until(ExpectedConditions.visibilityOfElementLocated(PhoneNumber));
				 driver.findElement(PhoneNumber).sendKeys("1234567890");
				 driver.findElement(EmailId).sendKeys("ab@abc.com");
				 driver.findElement(ContinueDetails).click();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName));
				 driver.findElement(FirstName).sendKeys("ab");
				 driver.findElement(LastName).sendKeys("CD");
				 driver.findElement(gender).click();
				 driver.findElement(male).click();
				 driver.findElement(ContinuePayment).click();
				 String itinerarypayment=driver.findElement(itinerarydetails).getText();
				 Assert.assertEquals(itinerarypayment.equals("Flight itinerary"), true);
		
		}
		
		
	 }

