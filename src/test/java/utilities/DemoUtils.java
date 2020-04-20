package utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class DemoUtils {
	
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

}
