package testscripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.FlipkartPage;
import utilities.BaseClass;
import utilities.ReadData;

public class LoginApp extends BaseClass {
	
	static FlipkartPage flipkartApp;
	
	@Test(priority = 1)
	public void checkURL()
	{
		String curentURL = ldriver.getTitle();
		Assert.assertEquals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", curentURL);
	}
	
	@Test(dependsOnMethods = {"checkURL"})
	public void Login() throws IOException
	{	
		flipkartApp=PageFactory.initElements(ldriver, FlipkartPage.class);
		flipkartApp.loginApp(ReadData.readExcelData("LoginDetails", "UserId"),ReadData.readExcelData("LoginDetails", "Password"));
		Assert.assertEquals(ReadData.readExcelData("LoginDetails", "UserName"), flipkartApp.lblUserId.getText());
	}
	
	@Test(dependsOnMethods = {"Login"})
	public void search() throws IOException, InterruptedException
	{
		flipkartApp.search(ReadData.readExcelData("SearchProducts", "ProductName"));
		Thread.sleep(1000);
		Assert.assertTrue(flipkartApp.validateSearchText(ReadData.readExcelData("SearchProducts", "ProductName")));
		
	}
}
