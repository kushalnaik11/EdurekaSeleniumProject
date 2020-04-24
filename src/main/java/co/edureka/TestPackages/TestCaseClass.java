package co.edureka.TestPackages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
 
import co.edureka.frameworkPackages.BrowserFactory;
import co.edureka.frameworkPackages.CaptureScreenShot;
import co.edureka.uiPackages.BookFlightPage;
import co.edureka.uiPackages.FlightConfirmationPage;
import co.edureka.uiPackages.FlightFinderPage;
import co.edureka.uiPackages.LoginPage;
import co.edureka.uiPackages.SelectFlightPage;
 
public class TestCaseClass extends HelperClass 
{
	public TestCaseClass()
	{
	}
 
	@Test
	public void returnTicket() {
		try {
			System.out.println("in returnTicket");
			driver.get("http://newtours.demoaut.com/");
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.loginWordPress("mercury", "mercury");
			FlightFinderPage flightFinderpage = PageFactory.initElements(driver, FlightFinderPage.class);
			flightFinderpage.continueWordPress("1","Zurich","July","12","Frankfurt","September","15","Business Class","Unified Airlines");
			SelectFlightPage selectFlightPage = PageFactory.initElements(driver, SelectFlightPage.class);
			selectFlightPage.departAirlineWordPress("Pangaea Airlines 362");
			selectFlightPage.returnAirlineWordPress("Unified Airlines 363");
			selectFlightPage.continu();
			BookFlightPage bookFlightPage = PageFactory.initElements(driver, BookFlightPage.class);
			bookFlightPage.purchasePress("Anirudh", "AS", "Vegetarian", "MasterCard", "12345678", "12", "2008", "Anirudh", "A", "S");
			FlightConfirmationPage flightConfirmationPage = PageFactory.initElements(driver, FlightConfirmationPage.class);
			String bookingDetailsFile = System.getProperty("user.dir")+"\\"+"ScreenShots\\FlightConfirmationDetails - "+CaptureScreenShot.getDateTimeStamp()+".png";
			try 
			{
				CaptureScreenShot.getScreenShot(BrowserFactory.getDriver(), bookingDetailsFile);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
 
			flightConfirmationPage.logoutPress();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}
}
