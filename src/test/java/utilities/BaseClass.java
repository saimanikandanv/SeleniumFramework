package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass extends BrowserHelper {
	
	public WebDriver ldriver;
	
	@BeforeTest
	
	public WebDriver initApp() throws IOException
	{
		ldriver=BrowserHelper.startApplication(ldriver);
		return ldriver;
	}
	
	@AfterTest
	public void quitapp()
	{
		BrowserHelper.exitApplication(ldriver);
	}

}
