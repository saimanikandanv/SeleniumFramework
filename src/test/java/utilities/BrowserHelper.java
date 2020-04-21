package utilities;

import java.io.IOException;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BrowserHelper extends ReadData {
	
	public static WebDriver driver;
	private static String browserName,appUrl;
	
			
	@BeforeTest
	public static WebDriver startApplication() throws IOException
	{					
		browserName=ReadData.getProp("browserName");
		appUrl=ReadData.getProp("URL");	

		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser Name");
		}
		
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}	
	
	@AfterTest
	public static void exitApplication()
	{
		driver.quit();
	}
	

}
