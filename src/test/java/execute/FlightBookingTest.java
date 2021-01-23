package execute;
import org.testng.annotations.Test;

import pom.FlightBookingPOM;
import utils.Base;


public class FlightBookingTest extends Base{
	//new
	@Test
	public void BookingTests() throws Exception {
		flightBooking=new FlightBookingPOM(driver);
		flightBooking.HomePage();
		flightBooking.flightPage();
		flightBooking.BookTicket();
	}

}
