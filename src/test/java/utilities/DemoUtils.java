package utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DemoUtils {

	public static WebDriverWait wait;

	public static String captureScreenshot(WebDriver driver)
	{
		String scrnshotpath=null;
		try
		{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			scrnshotpath="./Screenshots/DemoTour_"+ getcurrentTimestamp() +"./png";
			FileHandler.copy(src, new File(scrnshotpath));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return scrnshotpath;
	}

	public static String getcurrentTimestamp()
	{
		Date d =new Date();
		DateFormat formatter=new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		return formatter.format(d);
	}

	public static void waitForElementClickable(WebDriver driver,WebElement element,long waitTime)
	{
		wait=new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitforElementVisible(WebDriver driver,WebElement element,long waitTime)
	{
		wait=new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


}
